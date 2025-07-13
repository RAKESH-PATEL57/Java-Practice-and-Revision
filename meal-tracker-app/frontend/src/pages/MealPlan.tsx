import React, { useState, useEffect } from 'react';
import { useMeals } from '../context/MealContext';

const MealPlan: React.FC = () => {
  const { meals, loading, markMealAsEaten, skipMeal, fetchMeals } = useMeals();
  const [filter, setFilter] = useState('all');
  const [selectedDate, setSelectedDate] = useState('');

  useEffect(() => {
    fetchMeals();
  }, [fetchMeals]);

  const filteredMeals = meals.filter(meal => {
    if (filter === 'all') return true;
    return meal.status === filter;
  });

  const handleMarkAsEaten = async (mealId: string) => {
    try {
      await markMealAsEaten(mealId);
    } catch (error) {
      console.error('Error marking meal as eaten:', error);
    }
  };

  const handleSkipMeal = async (mealId: string) => {
    try {
      await skipMeal(mealId);
    } catch (error) {
      console.error('Error skipping meal:', error);
    }
  };

  const groupMealsByDate = (meals: any[]) => {
    const grouped: { [key: string]: any[] } = {};
    meals.forEach(meal => {
      const date = new Date(meal.scheduledDate).toDateString();
      if (!grouped[date]) {
        grouped[date] = [];
      }
      grouped[date].push(meal);
    });
    return grouped;
  };

  const groupedMeals = groupMealsByDate(filteredMeals);

  if (loading) {
    return (
      <div className="loading-container">
        <div className="loading-spinner"></div>
        <p>Loading meal plan...</p>
      </div>
    );
  }

  return (
    <div className="meal-plan-container">
      <div className="meal-plan-header">
        <h1>Your Meal Plan</h1>
        <p>Track your 60-meal journey</p>
      </div>

      <div className="meal-plan-filters">
        <div className="filter-group">
          <label>Filter by status:</label>
          <select 
            value={filter} 
            onChange={(e) => setFilter(e.target.value)}
            className="filter-select"
          >
            <option value="all">All Meals</option>
            <option value="planned">Planned</option>
            <option value="eaten">Eaten</option>
            <option value="skipped">Skipped</option>
          </select>
        </div>

        <div className="filter-group">
          <label>Filter by date:</label>
          <input
            type="date"
            value={selectedDate}
            onChange={(e) => setSelectedDate(e.target.value)}
            className="filter-date"
          />
        </div>
      </div>

      <div className="meal-plan-content">
        {Object.keys(groupedMeals).length === 0 ? (
          <div className="empty-state">
            <h3>No meals found</h3>
            <p>Start by creating your first meal plan</p>
            <button className="btn btn-primary">
              Create Meal Plan
            </button>
          </div>
        ) : (
          Object.entries(groupedMeals)
            .sort(([a], [b]) => new Date(a).getTime() - new Date(b).getTime())
            .map(([date, dayMeals]) => (
              <div key={date} className="day-section">
                <h2 className="day-header">
                  {new Date(date).toLocaleDateString('en-US', {
                    weekday: 'long',
                    year: 'numeric',
                    month: 'long',
                    day: 'numeric',
                  })}
                </h2>
                
                <div className="meals-grid">
                  {dayMeals.map(meal => (
                    <div key={meal._id} className={`meal-card ${meal.status}`}>
                      <div className="meal-header">
                        <h3>{meal.name}</h3>
                        <span className="meal-type">{meal.type}</span>
                      </div>
                      
                      <div className="meal-content">
                        {meal.description && (
                          <p className="meal-description">{meal.description}</p>
                        )}
                        
                        {meal.nutrition && (
                          <div className="meal-nutrition">
                            <span>Calories: {meal.nutrition.calories}</span>
                          </div>
                        )}
                        
                        <div className="meal-status-badge">
                          Status: {meal.status}
                        </div>
                      </div>
                      
                      <div className="meal-actions">
                        {meal.status === 'planned' && (
                          <>
                            <button 
                              onClick={() => handleMarkAsEaten(meal._id)}
                              className="btn btn-sm btn-success"
                            >
                              Mark as Eaten
                            </button>
                            <button 
                              onClick={() => handleSkipMeal(meal._id)}
                              className="btn btn-sm btn-warning"
                            >
                              Skip Meal
                            </button>
                          </>
                        )}
                        
                        {meal.status === 'eaten' && (
                          <span className="status-indicator eaten">
                            ✓ Completed
                          </span>
                        )}
                        
                        {meal.status === 'skipped' && (
                          <span className="status-indicator skipped">
                            ⏭ Skipped
                          </span>
                        )}
                      </div>
                    </div>
                  ))}
                </div>
              </div>
            ))
        )}
      </div>
    </div>
  );
};

export default MealPlan;