import api from './api';

export const mealService = {
  async getMeals(filters?: any) {
    const params = new URLSearchParams();
    if (filters) {
      Object.keys(filters).forEach(key => {
        if (filters[key]) {
          params.append(key, filters[key]);
        }
      });
    }
    const response = await api.get(`/meals?${params}`);
    return response.data;
  },

  async getMealById(id: string) {
    const response = await api.get(`/meals/${id}`);
    return response.data;
  },

  async createMeal(mealData: any) {
    const response = await api.post('/meals', mealData);
    return response.data;
  },

  async updateMeal(id: string, mealData: any) {
    const response = await api.put(`/meals/${id}`, mealData);
    return response.data;
  },

  async markMealAsEaten(id: string) {
    const response = await api.patch(`/meals/${id}/eat`);
    return response.data;
  },

  async skipMeal(id: string) {
    const response = await api.patch(`/meals/${id}/skip`);
    return response.data;
  },

  async deleteMeal(id: string) {
    const response = await api.delete(`/meals/${id}`);
    return response.data;
  },

  async getMealStats() {
    const response = await api.get('/meals/stats/summary');
    return response.data;
  },
};