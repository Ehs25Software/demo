# Render Deployment Guide

## Steps to Deploy on Render:

### 1. Push Code to GitHub
```bash
git add .
git commit -m "Add Render deployment config"
git push origin main
```

### 2. Create Render Account
- Go to https://render.com
- Sign up with GitHub

### 3. Deploy Web Service
1. Click "New +" → "Web Service"
2. Connect your GitHub repository
3. Configure:
   - **Name**: aarogya-india-api
   - **Environment**: Docker (or Java if using render.yaml)
   - **Build Command**: `./gradlew clean build -x test`
   - **Start Command**: `java -jar build/libs/demo-0.0.1-SNAPSHOT.jar`
   - **Instance Type**: Free

4. Click "Create Web Service"

### 4. Your API will be live at:
```
https://aarogya-india-api.onrender.com
```

## API Endpoints:
- POST `/api/mobile/auth/request-otp`
- POST `/api/mobile/auth/verify-otp`
- POST `/api/mobile/auth/resend-otp`
- GET `/api/mobile/orders/{mobileNo}`
- GET `/api/mobile/orders/details/{orderId}`
- GET `/api/mobile/orders/track/{orderId}`
- POST `/api/mobile/orders/reorder/{orderId}`
- GET `/api/mobile/profile/{mobileNo}`
- PUT `/api/mobile/profile/{mobileNo}`
- GET `/api/mobile/addresses/{mobileNo}`
- POST `/api/mobile/addresses`
- PUT `/api/mobile/addresses/{addressId}`
- DELETE `/api/mobile/addresses/{addressId}`
- GET `/api/mobile/reviews/{mobileNo}`
- POST `/api/mobile/reviews`
- GET `/api/mobile/support/chats/{mobileNo}`
- POST `/api/mobile/support/chats`
- GET `/api/mobile/dashboard/{mobileNo}`

## Note:
- Free tier may take 30-60 seconds for first request (cold start)
- Service sleeps after 15 minutes of inactivity
