const express = require('express');
const User = require('../models/User');
const auth = require('../middleware/auth');

const router = express.Router();

// Update user profile
router.put('/profile', auth, async (req, res) => {
  try {
    const updates = req.body;
    const allowedUpdates = ['profile', 'preferences'];
    const updateData = {};

    // Only allow updates to specific fields
    Object.keys(updates).forEach(key => {
      if (allowedUpdates.includes(key)) {
        updateData[key] = updates[key];
      }
    });

    const user = await User.findByIdAndUpdate(
      req.user._id,
      updateData,
      { new: true, runValidators: true }
    ).select('-password');

    res.json({ 
      message: 'Profile updated successfully', 
      user 
    });
  } catch (error) {
    console.error('Update profile error:', error);
    res.status(500).json({ message: 'Server error' });
  }
});

// Change password
router.put('/password', auth, async (req, res) => {
  try {
    const { currentPassword, newPassword } = req.body;

    const user = await User.findById(req.user._id);
    
    // Verify current password
    const isMatch = await user.comparePassword(currentPassword);
    if (!isMatch) {
      return res.status(400).json({ message: 'Current password is incorrect' });
    }

    // Update password
    user.password = newPassword;
    await user.save();

    res.json({ message: 'Password updated successfully' });
  } catch (error) {
    console.error('Change password error:', error);
    res.status(500).json({ message: 'Server error' });
  }
});

// Get user statistics
router.get('/stats', auth, async (req, res) => {
  try {
    const userId = req.user._id;
    
    // Get meal statistics
    const Meal = require('../models/Meal');
    const mealStats = await Meal.aggregate([
      { $match: { user: userId } },
      {
        $group: {
          _id: null,
          totalMeals: { $sum: 1 },
          eatenMeals: { $sum: { $cond: [{ $eq: ['$status', 'eaten'] }, 1, 0] } },
          skippedMeals: { $sum: { $cond: [{ $eq: ['$status', 'skipped'] }, 1, 0] } },
          plannedMeals: { $sum: { $cond: [{ $eq: ['$status', 'planned'] }, 1, 0] } },
          totalCalories: { $sum: '$nutrition.calories' }
        }
      }
    ]);

    const stats = mealStats[0] || {
      totalMeals: 0,
      eatenMeals: 0,
      skippedMeals: 0,
      plannedMeals: 0,
      totalCalories: 0
    };

    // Calculate completion percentage
    stats.completionPercentage = stats.totalMeals > 0 
      ? Math.round((stats.eatenMeals / stats.totalMeals) * 100) 
      : 0;

    res.json({ stats });
  } catch (error) {
    console.error('Get user stats error:', error);
    res.status(500).json({ message: 'Server error' });
  }
});

// Delete user account
router.delete('/account', auth, async (req, res) => {
  try {
    const { password } = req.body;

    // Verify password before deletion
    const user = await User.findById(req.user._id);
    const isMatch = await user.comparePassword(password);
    
    if (!isMatch) {
      return res.status(400).json({ message: 'Password is incorrect' });
    }

    // Delete user and all associated meals
    const Meal = require('../models/Meal');
    await Meal.deleteMany({ user: req.user._id });
    await User.findByIdAndDelete(req.user._id);

    res.json({ message: 'Account deleted successfully' });
  } catch (error) {
    console.error('Delete account error:', error);
    res.status(500).json({ message: 'Server error' });
  }
});

module.exports = router;