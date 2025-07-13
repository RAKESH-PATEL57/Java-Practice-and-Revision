import React from 'react';
import { Link } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';

const Home: React.FC = () => {
  const { user } = useAuth();

  return (
    <div className="home-container">
      <div className="hero-section">
        <h1>Welcome to Meal Tracker</h1>
        <p className="hero-subtitle">
          Track your 60-meal journey with ease. Plan, eat, and manage your meals efficiently.
        </p>
        
        <div className="hero-features">
          <div className="feature-card">
            <h3>📋 Plan Your Meals</h3>
            <p>Create a comprehensive meal plan with 60 meals (lunch and dinner)</p>
          </div>
          
          <div className="feature-card">
            <h3>✅ Track Progress</h3>
            <p>Mark meals as eaten or skip them to postpone to the next day</p>
          </div>
          
          <div className="feature-card">
            <h3>📊 View Statistics</h3>
            <p>Monitor your meal completion rate and nutritional intake</p>
          </div>
        </div>

        <div className="hero-actions">
          {user ? (
            <>
              <Link to="/dashboard" className="btn btn-primary">
                Go to Dashboard
              </Link>
              <Link to="/meal-plan" className="btn btn-secondary">
                View Meal Plan
              </Link>
            </>
          ) : (
            <>
              <Link to="/register" className="btn btn-primary">
                Get Started
              </Link>
              <Link to="/login" className="btn btn-secondary">
                Login
              </Link>
            </>
          )}
        </div>
      </div>

      <div className="info-section">
        <h2>How It Works</h2>
        <div className="steps">
          <div className="step">
            <div className="step-number">1</div>
            <h3>Create Your Account</h3>
            <p>Sign up and set up your profile with your meal preferences</p>
          </div>
          
          <div className="step">
            <div className="step-number">2</div>
            <h3>Plan Your Meals</h3>
            <p>Create a 60-meal plan with lunches and dinners for the month</p>
          </div>
          
          <div className="step">
            <div className="step-number">3</div>
            <h3>Track Your Progress</h3>
            <p>Mark meals as eaten or skip them to automatically reschedule</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Home;