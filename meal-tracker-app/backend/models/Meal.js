const mongoose = require('mongoose');

const mealSchema = new mongoose.Schema({
  user: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'User',
    required: true
  },
  name: {
    type: String,
    required: true,
    trim: true
  },
  type: {
    type: String,
    enum: ['lunch', 'dinner'],
    required: true
  },
  description: {
    type: String,
    trim: true
  },
  ingredients: [{
    name: String,
    quantity: String,
    calories: Number
  }],
  nutrition: {
    calories: Number,
    protein: Number,
    carbs: Number,
    fat: Number,
    fiber: Number
  },
  status: {
    type: String,
    enum: ['planned', 'eaten', 'skipped'],
    default: 'planned'
  },
  originalDate: {
    type: Date,
    required: true
  },
  scheduledDate: {
    type: Date,
    required: true
  },
  position: {
    type: Number,
    required: true // Position in the 60-meal plan (1-60)
  },
  notes: {
    type: String,
    trim: true
  },
  rating: {
    type: Number,
    min: 1,
    max: 5
  }
}, {
  timestamps: true
});

// Index for efficient querying
mealSchema.index({ user: 1, position: 1 });
mealSchema.index({ user: 1, scheduledDate: 1 });
mealSchema.index({ user: 1, status: 1 });

module.exports = mongoose.model('Meal', mealSchema);