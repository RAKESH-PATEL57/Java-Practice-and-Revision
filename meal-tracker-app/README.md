# Meal Tracker Application

A full-stack meal tracking application that helps users plan, track, and manage their 60-meal journey. Built with React.js frontend and Node.js/Express.js backend.

## Features

### Core Functionality
- **Meal Planning**: Create and manage a 60-meal plan with lunches and dinners
- **Meal Tracking**: Mark meals as eaten, skipped, or planned
- **Smart Postponement**: Skipped meals are automatically rescheduled to the next day
- **Progress Monitoring**: View completion statistics and meal history
- **User Authentication**: Secure JWT-based authentication system

### User Experience
- **Responsive Design**: Works seamlessly on desktop and mobile devices
- **Intuitive Interface**: Clean, modern UI with easy navigation
- **Dashboard**: Overview of meal progress and upcoming meals
- **Profile Management**: Customize user preferences and goals

## Technology Stack

### Frontend
- **React.js** (v18+) with TypeScript
- **React Router** for navigation
- **Axios** for API communication
- **Context API** for state management
- **Responsive CSS** (no external UI libraries)

### Backend
- **Node.js** with Express.js
- **MongoDB** with Mongoose ODM
- **JWT** for authentication
- **bcryptjs** for password hashing
- **CORS** configured for development

## Project Structure

```
meal-tracker-app/
├── frontend/                 # React.js application
│   ├── src/
│   │   ├── components/       # Reusable UI components
│   │   ├── pages/           # Page components
│   │   ├── context/         # React Context providers
│   │   ├── services/        # API service functions
│   │   ├── styles/          # CSS styles
│   │   └── utils/           # Utility functions
│   ├── public/              # Static assets
│   └── package.json
├── backend/                  # Node.js/Express.js API
│   ├── config/              # Database configuration
│   ├── controllers/         # Route controllers
│   ├── middleware/          # Custom middleware
│   ├── models/              # Mongoose models
│   ├── routes/              # API routes
│   ├── server.js            # Main server file
│   └── package.json
├── README.md
└── .gitignore
```

## Getting Started

### Prerequisites
- Node.js (v14 or higher)
- MongoDB (local installation or MongoDB Atlas)
- npm or yarn

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd meal-tracker-app
   ```

2. **Set up the backend**
   ```bash
   cd backend
   npm install
   cp .env.example .env
   # Edit .env with your configuration
   npm run dev
   ```

3. **Set up the frontend**
   ```bash
   cd ../frontend
   npm install
   npm start
   ```

4. **Access the application**
   - Frontend: http://localhost:3000
   - Backend API: http://localhost:5000

### Environment Configuration

Create a `.env` file in the backend directory:

```env
PORT=5000
MONGODB_URI=mongodb://localhost:27017/meal-tracker
JWT_SECRET=your-super-secret-jwt-key-here
FRONTEND_URL=http://localhost:3000
NODE_ENV=development
```

## API Endpoints

### Authentication
- `POST /api/auth/register` - Register new user
- `POST /api/auth/login` - User login
- `GET /api/auth/me` - Get current user
- `POST /api/auth/refresh` - Refresh JWT token

### Meals
- `GET /api/meals` - Get all meals for user
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

## Usage

1. **Sign Up/Login**: Create an account or login with existing credentials
2. **Dashboard**: View your meal progress and today's meals
3. **Meal Plan**: Create, view, and manage your 60-meal plan
4. **Track Meals**: Mark meals as eaten or skip them to reschedule
5. **Profile**: Update your preferences and goals

## Features in Detail

### Meal Tracking System
- **60-Meal Plan**: Structured meal planning for optimal nutrition tracking
- **Meal Types**: Separate tracking for lunch and dinner
- **Status Management**: Three states - planned, eaten, skipped
- **Smart Rescheduling**: Skipped meals automatically move to the next day

### User Management
- **Secure Authentication**: JWT-based authentication with password hashing
- **Profile Customization**: Personal information and dietary goals
- **Preferences**: Theme selection and notification settings

### Analytics & Insights
- **Progress Tracking**: Visual representation of meal completion
- **Statistics**: Comprehensive stats on eating habits
- **History**: Complete meal history and patterns

## Development

### Frontend Development
```bash
cd frontend
npm start          # Start development server
npm run build      # Build for production
npm test           # Run tests
```

### Backend Development
```bash
cd backend
npm run dev        # Start with nodemon (auto-restart)
npm start          # Start production server
```

### Code Structure

#### Frontend Architecture
- **Components**: Reusable UI components
- **Pages**: Route-based page components
- **Context**: Global state management
- **Services**: API communication layer
- **Styles**: Responsive CSS styling

#### Backend Architecture
- **Models**: MongoDB schemas with Mongoose
- **Routes**: Express.js route definitions
- **Middleware**: Authentication and validation
- **Controllers**: Business logic handlers

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the ISC License. See the LICENSE file for details.

## Support

For support, please open an issue in the GitHub repository or contact the development team.

---

Built with ❤️ using React.js and Node.js