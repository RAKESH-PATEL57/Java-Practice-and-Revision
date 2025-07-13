const express = require('express');
const Meal = require('../models/Meal');
const auth = require('../middleware/auth');

const router = express.Router();

// Get all meals for a user
router.get('/', auth, async (req, res) => {
  try {
    const { status, type, date } = req.query;
    const filter = { user: req.user._id };

    if (status) filter.status = status;
    if (type) filter.type = type;
    if (date) {
      const startDate = new Date(date);
      const endDate = new Date(startDate);
      endDate.setDate(endDate.getDate() + 1);
      filter.scheduledDate = { $gte: startDate, $lt: endDate };
    }

    const meals = await Meal.find(filter)
      .sort({ position: 1 })
      .populate('user', 'username email');

    res.json({ meals });
  } catch (error) {
    console.error('Get meals error:', error);
    res.status(500).json({ message: 'Server error' });
  }
});

// Get meal by ID
router.get('/:id', auth, async (req, res) => {
  try {
    const meal = await Meal.findOne({ 
      _id: req.params.id, 
      user: req.user._id 
    }).populate('user', 'username email');

    if (!meal) {
      return res.status(404).json({ message: 'Meal not found' });
    }

    res.json({ meal });
  } catch (error) {
    console.error('Get meal error:', error);
    res.status(500).json({ message: 'Server error' });
  }
});

// Create a new meal
router.post('/', auth, async (req, res) => {
  try {
    const mealData = {
      ...req.body,
      user: req.user._id
    };

    const meal = new Meal(mealData);
    await meal.save();

    res.status(201).json({ 
      message: 'Meal created successfully', 
      meal 
    });
  } catch (error) {
    console.error('Create meal error:', error);
    res.status(500).json({ message: 'Server error' });
  }
});

// Update meal
router.put('/:id', auth, async (req, res) => {
  try {
    const meal = await Meal.findOneAndUpdate(
      { _id: req.params.id, user: req.user._id },
      req.body,
      { new: true, runValidators: true }
    );

    if (!meal) {
      return res.status(404).json({ message: 'Meal not found' });
    }

    res.json({ message: 'Meal updated successfully', meal });
  } catch (error) {
    console.error('Update meal error:', error);
    res.status(500).json({ message: 'Server error' });
  }
});

// Mark meal as eaten
router.patch('/:id/eat', auth, async (req, res) => {
  try {
    const meal = await Meal.findOneAndUpdate(
      { _id: req.params.id, user: req.user._id },
      { status: 'eaten' },
      { new: true }
    );

    if (!meal) {
      return res.status(404).json({ message: 'Meal not found' });
    }

    res.json({ message: 'Meal marked as eaten', meal });
  } catch (error) {
    console.error('Mark meal eaten error:', error);
    res.status(500).json({ message: 'Server error' });
  }
});

// Skip meal (postpone to next day)
router.patch('/:id/skip', auth, async (req, res) => {
  try {
    const meal = await Meal.findOne({ 
      _id: req.params.id, 
      user: req.user._id 
    });

    if (!meal) {
      return res.status(404).json({ message: 'Meal not found' });
    }

    // Update the meal to skipped status and postpone to next day
    const nextDay = new Date(meal.scheduledDate);
    nextDay.setDate(nextDay.getDate() + 1);

    meal.status = 'skipped';
    meal.scheduledDate = nextDay;
    
    await meal.save();

    res.json({ message: 'Meal skipped and postponed to next day', meal });
  } catch (error) {
    console.error('Skip meal error:', error);
    res.status(500).json({ message: 'Server error' });
  }
});

// Delete meal
router.delete('/:id', auth, async (req, res) => {
  try {
    const meal = await Meal.findOneAndDelete({ 
      _id: req.params.id, 
      user: req.user._id 
    });

    if (!meal) {
      return res.status(404).json({ message: 'Meal not found' });
    }

    res.json({ message: 'Meal deleted successfully' });
  } catch (error) {
    console.error('Delete meal error:', error);
    res.status(500).json({ message: 'Server error' });
  }
});

// Get meal statistics
router.get('/stats/summary', auth, async (req, res) => {
  try {
    const stats = await Meal.aggregate([
      { $match: { user: req.user._id } },
      {
        $group: {
          _id: '$status',
          count: { $sum: 1 },
          totalCalories: { $sum: '$nutrition.calories' }
        }
      }
    ]);

    res.json({ stats });
  } catch (error) {
    console.error('Get stats error:', error);
    res.status(500).json({ message: 'Server error' });
  }
});

module.exports = router;