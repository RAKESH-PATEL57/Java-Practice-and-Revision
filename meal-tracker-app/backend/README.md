# Meal Tracker API

Backend API for the Meal Tracking application built with Node.js, Express.js, and MongoDB.

## Features

- User authentication with JWT
- CRUD operations for meals
- Meal tracking with status (planned, eaten, skipped)
- Meal postponement for skipped meals
- User profile management
- Statistics and analytics
- RESTful API design

## Setup Instructions

### Prerequisites

- Node.js (v14 or higher)
- MongoDB (local or cloud instance)
- npm or yarn

### Installation

1. Install dependencies:
```bash
npm install
```

2. Create environment file:
```bash
cp .env.example .env
```

3. Update the `.env` file with your configuration:
```
PORT=5000
MONGODB_URI=mongodb://localhost:27017/meal-tracker
JWT_SECRET=your-super-secret-jwt-key-here
FRONTEND_URL=http://localhost:3000
```

### Running the Application

#### Development Mode
```bash
npm run dev
```

#### Production Mode
```bash
npm start
```

The server will start on `http://localhost:5000`

## API Endpoints

### Authentication
- `POST /api/auth/register` - Register new user
- `POST /api/auth/login` - User login
- `GET /api/auth/me` - Get current user
- `POST /api/auth/refresh` - Refresh JWT token

### Meals
- `GET /api/meals` - Get all meals for user
- `GET /api/meals/:id` - Get meal by ID
- `POST /api/meals` - Create new meal
- `PUT /api/meals/:id` - Update meal
- `PATCH /api/meals/:id/eat` - Mark meal as eaten
- `PATCH /api/meals/:id/skip` - Skip meal (postpone to next day)
- `DELETE /api/meals/:id` - Delete meal
- `GET /api/meals/stats/summary` - Get meal statistics

### Users
- `PUT /api/users/profile` - Update user profile
- `PUT /api/users/password` - Change password
- `GET /api/users/stats` - Get user statistics
- `DELETE /api/users/account` - Delete user account

### Health Check
- `GET /api/health` - Server health check

## Data Models

### User Model
- Username, email, password
- Profile information (name, goals, etc.)
- Preferences (theme, notifications)

### Meal Model
- User reference
- Name, type (lunch/dinner), description
- Ingredients and nutrition information
- Status (planned, eaten, skipped)
- Dates (original, scheduled)
- Position in 60-meal plan
- Notes and rating

## Authentication

The API uses JWT (JSON Web Tokens) for authentication. Include the token in the Authorization header:

```
Authorization: Bearer <your-jwt-token>
```

## Error Handling

The API returns appropriate HTTP status codes and error messages:
- 400: Bad Request
- 401: Unauthorized
- 404: Not Found
- 500: Internal Server Error

## Development

### Project Structure
```
backend/
├── config/          # Database configuration
├── controllers/     # Route controllers (future expansion)
├── middleware/      # Custom middleware
├── models/          # Mongoose models
├── routes/          # API routes
├── server.js        # Main server file
└── package.json     # Dependencies and scripts
```

### Testing

To run tests (when implemented):
```bash
npm test
```

## Environment Variables

| Variable | Description | Default |
|----------|-------------|---------|
| PORT | Server port | 5000 |
| MONGODB_URI | MongoDB connection string | mongodb://localhost:27017/meal-tracker |
| JWT_SECRET | JWT signing secret | fallback-secret |
| FRONTEND_URL | Frontend URL for CORS | http://localhost:3000 |
| NODE_ENV | Environment mode | development |

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## License

This project is licensed under the ISC License.