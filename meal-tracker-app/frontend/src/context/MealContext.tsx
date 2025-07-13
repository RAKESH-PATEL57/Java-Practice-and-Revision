import React, { createContext, useContext, useState, useEffect, useCallback, ReactNode } from 'react';
import { mealService } from '../services/mealService';
import { useAuth } from './AuthContext';

interface Meal {
  _id: string;
  name: string;
  type: 'lunch' | 'dinner';
  description?: string;
  ingredients?: Array<{
    name: string;
    quantity: string;
    calories: number;
  }>;
  nutrition?: {
    calories: number;
    protein: number;
    carbs: number;
    fat: number;
    fiber: number;
  };
  status: 'planned' | 'eaten' | 'skipped';
  originalDate: string;
  scheduledDate: string;
  position: number;
  notes?: string;
  rating?: number;
}

interface MealContextType {
  meals: Meal[];
  loading: boolean;
  fetchMeals: (filters?: any) => Promise<void>;
  createMeal: (mealData: Partial<Meal>) => Promise<void>;
  updateMeal: (id: string, mealData: Partial<Meal>) => Promise<void>;
  markMealAsEaten: (id: string) => Promise<void>;
  skipMeal: (id: string) => Promise<void>;
  deleteMeal: (id: string) => Promise<void>;
  getMealStats: () => Promise<any>;
}

const MealContext = createContext<MealContextType | undefined>(undefined);

export const useMeals = () => {
  const context = useContext(MealContext);
  if (context === undefined) {
    throw new Error('useMeals must be used within a MealProvider');
  }
  return context;
};

interface MealProviderProps {
  children: ReactNode;
}

export const MealProvider: React.FC<MealProviderProps> = ({ children }) => {
  const [meals, setMeals] = useState<Meal[]>([]);
  const [loading, setLoading] = useState(false);
  const { user } = useAuth();

  const fetchMeals = useCallback(async (filters?: any) => {
    if (!user) return;

    setLoading(true);
    try {
      const response = await mealService.getMeals(filters);
      setMeals(response.meals);
    } catch (error) {
      console.error('Error fetching meals:', error);
    } finally {
      setLoading(false);
    }
  }, [user]);

  const createMeal = async (mealData: Partial<Meal>) => {
    try {
      const response = await mealService.createMeal(mealData);
      setMeals(prev => [...prev, response.meal]);
    } catch (error) {
      console.error('Error creating meal:', error);
      throw error;
    }
  };

  const updateMeal = async (id: string, mealData: Partial<Meal>) => {
    try {
      const response = await mealService.updateMeal(id, mealData);
      setMeals(prev => prev.map(meal => 
        meal._id === id ? response.meal : meal
      ));
    } catch (error) {
      console.error('Error updating meal:', error);
      throw error;
    }
  };

  const markMealAsEaten = async (id: string) => {
    try {
      const response = await mealService.markMealAsEaten(id);
      setMeals(prev => prev.map(meal => 
        meal._id === id ? response.meal : meal
      ));
    } catch (error) {
      console.error('Error marking meal as eaten:', error);
      throw error;
    }
  };

  const skipMeal = async (id: string) => {
    try {
      const response = await mealService.skipMeal(id);
      setMeals(prev => prev.map(meal => 
        meal._id === id ? response.meal : meal
      ));
    } catch (error) {
      console.error('Error skipping meal:', error);
      throw error;
    }
  };

  const deleteMeal = async (id: string) => {
    try {
      await mealService.deleteMeal(id);
      setMeals(prev => prev.filter(meal => meal._id !== id));
    } catch (error) {
      console.error('Error deleting meal:', error);
      throw error;
    }
  };

  const getMealStats = async () => {
    try {
      return await mealService.getMealStats();
    } catch (error) {
      console.error('Error getting meal stats:', error);
      throw error;
    }
  };

  useEffect(() => {
    if (user) {
      fetchMeals();
    }
  }, [user, fetchMeals]);

  const value: MealContextType = {
    meals,
    loading,
    fetchMeals,
    createMeal,
    updateMeal,
    markMealAsEaten,
    skipMeal,
    deleteMeal,
    getMealStats,
  };

  return <MealContext.Provider value={value}>{children}</MealContext.Provider>;
};