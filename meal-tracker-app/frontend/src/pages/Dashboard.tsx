import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';
import { useMeals } from '../context/MealContext';

const Dashboard: React.FC = () => {
  const { user } = useAuth();
  const { meals, getMealStats } = useMeals();
  const [stats, setStats] = useState<any>({});

  useEffect(() => {
    const fetchStats = async () => {
      try {
        const statsData = await getMealStats();
        setStats(statsData.stats);
      } catch (error) {
        console.error('Error fetching stats:', error);
      }
    };

    fetchStats();
  }, [getMealStats]);

  const todaysMeals = meals.filter(meal => {
    const today = new Date();
    const mealDate = new Date(meal.scheduledDate);
    return mealDate.toDateString() === today.toDateString();
  });

  const upcomingMeals = meals
    .filter(meal => {
      const today = new Date();
      const mealDate = new Date(meal.scheduledDate);
      return mealDate > today && meal.status === 'planned';
    })
    .slice(0, 5);

  const completionRate = stats.totalMeals > 0 
    ? Math.round((stats.eatenMeals / stats.totalMeals) * 100)
    : 0;

  return (
    <div className="dashboard-container">
      <div className="dashboard-header">
        <h1>Welcome back, {user?.username}!</h1>
        <p>Here's your meal tracking progress</p>
      </div>

      <div className="dashboard-stats">
        <div className="stat-card">
          <h3>Total Meals</h3>
          <div className="stat-value">{stats.totalMeals || 0}</div>
        </div>
        
        <div className="stat-card">
          <h3>Eaten</h3>
          <div className="stat-value eaten">{stats.eatenMeals || 0}</div>
        </div>
        
        <div className="stat-card">
          <h3>Skipped</h3>
          <div className="stat-value skipped">{stats.skippedMeals || 0}</div>
        </div>
        
        <div className="stat-card">
          <h3>Completion Rate</h3>
          <div className="stat-value">{completionRate}%</div>
        </div>
      </div>

      <div className="dashboard-content">
        <div className="dashboard-section">
          <h2>Today's Meals</h2>
          {todaysMeals.length > 0 ? (
            <div className="meals-grid">
              {todaysMeals.map(meal => (
                <div key={meal._id} className={`meal-card ${meal.status}`}>
                  <h3>{meal.name}</h3>
                  <p className="meal-type">{meal.type}</p>
                  <p className="meal-status">{meal.status}</p>
                  {meal.description && (
                    <p className="meal-description">{meal.description}</p>
                  )}
                </div>
              ))}
            </div>
          ) : (
            <div className="empty-state">
              <p>No meals scheduled for today</p>
              <Link to="/meal-plan" className="btn btn-primary">
                Create Meal Plan
              </Link>
            </div>
          )}
        </div>

        <div className="dashboard-section">
          <h2>Upcoming Meals</h2>
          {upcomingMeals.length > 0 ? (
            <div className="meals-list">
              {upcomingMeals.map(meal => (
                <div key={meal._id} className="meal-item">
                  <div className="meal-info">
                    <h4>{meal.name}</h4>
                    <p>{meal.type} • {new Date(meal.scheduledDate).toLocaleDateString()}</p>
                  </div>
                  <div className="meal-actions">
                    <span className="meal-status">{meal.status}</span>
                  </div>
                </div>
              ))}
            </div>
          ) : (
            <div className="empty-state">
              <p>No upcoming meals planned</p>
              <Link to="/meal-plan" className="btn btn-secondary">
                Plan Your Meals
              </Link>
            </div>
          )}
        </div>
      </div>

      <div className="dashboard-actions">
        <Link to="/meal-plan" className="btn btn-primary">
          View Full Meal Plan
        </Link>
        <Link to="/profile" className="btn btn-secondary">
          Update Profile
        </Link>
      </div>
    </div>
  );
};

export default Dashboard;