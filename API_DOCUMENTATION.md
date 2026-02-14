# Aarogya India Phone App - API Documentation

## Base URL
```
http://localhost:8080
```

## Authentication APIs

### 1. Request OTP
**Endpoint:** `POST /api/mobile/auth/request-otp`

**Request:**
```json
{
  "mobileno": "7838082254"
}
```

**Response:**
```json
{
  "Status": "Success",
  "Message": "OTP sent successfully",
  "autoWord": "123456"
}
```

### 2. Verify OTP
**Endpoint:** `POST /api/mobile/auth/verify-otp`

**Request:**
```json
{
  "mobileno": "7838082254",
  "otp": "123456"
}
```

**Response:**
```json
{
  "Status": "Success",
  "Message": "Login successful",
  "customer": {
    "id": 1,
    "name": "Arjun Sharma",
    "mobileNumber": "7838082254",
    "email": "awesome.123@yopmail.com",
    "gender": "MALE"
  }
}
```

### 3. Resend OTP
**Endpoint:** `POST /api/mobile/auth/resend-otp`

**Request:**
```json
{
  "mobileno": "7838082254"
}
```

---

## Profile APIs

### 1. Get Profile
**Endpoint:** `GET /api/mobile/profile/{mobileNo}`

**Example:** `GET /api/mobile/profile/7838082254`

### 2. Update Profile
**Endpoint:** `PUT /api/mobile/profile`

**Request:**
```json
{
  "mobileno": "7838082254",
  "name": "John Doe",
  "email": "awesome.123@yopmail.com",
  "gender": "MALE"
}
```

---

## Address APIs

### 1. Get All Addresses
**Endpoint:** `GET /api/mobile/addresses/{mobileNo}`

**Example:** `GET /api/mobile/addresses/7838082254`

### 2. Add New Address
**Endpoint:** `POST /api/mobile/addresses`

**Request:**
```json
{
  "mobileno": "7838082254",
  "locality": "B-429, ABC colony",
  "landmark": "Temple",
  "pincode": "201301",
  "city": "Noida",
  "state": "Uttar pradesh",
  "addressType": "HOME"
}
```

### 3. Update Address
**Endpoint:** `PUT /api/mobile/addresses/{addressId}`

**Example:** `PUT /api/mobile/addresses/1`

### 4. Delete Address
**Endpoint:** `DELETE /api/mobile/addresses/{addressId}`

**Example:** `DELETE /api/mobile/addresses/1`

---

## Order APIs

### 1. Get User Orders
**Endpoint:** `GET /api/mobile/orders/{mobileNo}`

**Example:** `GET /api/mobile/orders/7838082254`

### 2. Get Order Details
**Endpoint:** `GET /api/mobile/orders/details/{orderId}`

**Example:** `GET /api/mobile/orders/details/123911`

### 3. Track Order
**Endpoint:** `GET /api/mobile/orders/track/{orderId}`

**Example:** `GET /api/mobile/orders/track/123911`

### 4. Reorder
**Endpoint:** `POST /api/mobile/orders/reorder/{orderId}`

**Example:** `POST /api/mobile/orders/reorder/123911`

---

## Review APIs

### 1. Get Product Reviews
**Endpoint:** `GET /api/mobile/reviews/product/{productId}`

**Example:** `GET /api/mobile/reviews/product/1`

### 2. Submit Review
**Endpoint:** `POST /api/mobile/reviews`

**Request:**
```json
{
  "mobileno": "7838082254",
  "orderId": "123911",
  "productId": 1,
  "rating": 5,
  "title": "Just awesome",
  "description": "Exploring ways to increase your strength and stamina? Switch to the Ayurvedic goodness of Arigya India Shilajit.",
  "imageUrl": "base64_or_url"
}
```

---

## Support Chat APIs

### 1. Get Chat History
**Endpoint:** `GET /api/mobile/support/chat/{mobileNo}`

**Example:** `GET /api/mobile/support/chat/7838082254`

### 2. Send Chat Message
**Endpoint:** `POST /api/mobile/support/chat`

**Request:**
```json
{
  "mobileno": "7838082254",
  "message": "Products",
  "messageType": "TEXT"
}
```

### 3. Upload Chat Media
**Endpoint:** `POST /api/mobile/support/chat/upload`

**Form Data:**
- `file`: MultipartFile
- `mobileno`: String
- `messageType`: String (IMAGE/AUDIO/VIDEO)

---

## Dashboard API

### Get Dashboard Data
**Endpoint:** `GET /api/mobile/dashboard/{mobileNo}`

**Example:** `GET /api/mobile/dashboard/7838082254`

---

## Running the Application

1. Build the project:
```bash
./gradlew build
```

2. Run the application:
```bash
./gradlew bootRun
```

3. The API will be available at: `http://localhost:8080`

---

## Testing with cURL

### Request OTP:
```bash
curl -X POST http://localhost:8080/api/mobile/auth/request-otp \
  -H "Content-Type: application/json" \
  -d '{"mobileno": "7838082254"}'
```

### Verify OTP:
```bash
curl -X POST http://localhost:8080/api/mobile/auth/verify-otp \
  -H "Content-Type: application/json" \
  -d '{"mobileno": "7838082254", "otp": "123456"}'
```

### Get Profile:
```bash
curl http://localhost:8080/api/mobile/profile/7838082254
```

### Get Orders:
```bash
curl http://localhost:8080/api/mobile/orders/7838082254
```

---

## Dummy Data

The application comes pre-loaded with dummy data:

- **OTP:** Always use `123456` for testing
- **Mobile Numbers:** Any mobile number works
- **Addresses:** 2 pre-loaded addresses
- **Orders:** 2 sample orders (123911, 123912)
- **Reviews:** 2 sample reviews for product ID 1
- **Chat:** Initial bot greeting message

---

## Notes

- All endpoints return JSON responses
- Status field indicates "Success" or "Failed"
- Timestamps are in ISO 8601 format
- File uploads support up to 10MB
