import React, { useState } from 'react';
import { useAuth } from '../context/AuthContext';

const Profile: React.FC = () => {
  const { user, updateUser } = useAuth();
  const [isEditing, setIsEditing] = useState(false);
  const [formData, setFormData] = useState({
    firstName: user?.profile?.firstName || '',
    lastName: user?.profile?.lastName || '',
    dailyCalories: user?.profile?.goals?.dailyCalories?.toString() || '',
    targetWeight: user?.profile?.goals?.targetWeight?.toString() || '',
    theme: user?.preferences?.theme || 'light',
    notifications: user?.preferences?.notifications || true,
  });
  const [loading, setLoading] = useState(false);
  const [message, setMessage] = useState('');

  const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
    const { name, value, type } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: type === 'checkbox' ? (e.target as HTMLInputElement).checked : value,
    }));
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setLoading(true);
    setMessage('');

    try {
      const profileData = {
        profile: {
          firstName: formData.firstName,
          lastName: formData.lastName,
          goals: {
            dailyCalories: formData.dailyCalories ? parseInt(formData.dailyCalories) : undefined,
            targetWeight: formData.targetWeight ? parseInt(formData.targetWeight) : undefined,
          },
        },
        preferences: {
          theme: formData.theme,
          notifications: formData.notifications,
        },
      };

      // In a real app, this would make an API call to update the user
      updateUser(profileData);
      setIsEditing(false);
      setMessage('Profile updated successfully!');
    } catch (error) {
      setMessage('Error updating profile. Please try again.');
    } finally {
      setLoading(false);
    }
  };

  const handleCancel = () => {
    setFormData({
      firstName: user?.profile?.firstName || '',
      lastName: user?.profile?.lastName || '',
      dailyCalories: user?.profile?.goals?.dailyCalories?.toString() || '',
      targetWeight: user?.profile?.goals?.targetWeight?.toString() || '',
      theme: user?.preferences?.theme || 'light',
      notifications: user?.preferences?.notifications || true,
    });
    setIsEditing(false);
  };

  return (
    <div className="profile-container">
      <div className="profile-header">
        <h1>Your Profile</h1>
        <p>Manage your account settings and preferences</p>
      </div>

      {message && (
        <div className={`message ${message.includes('Error') ? 'error' : 'success'}`}>
          {message}
        </div>
      )}

      <div className="profile-content">
        <div className="profile-section">
          <h2>Account Information</h2>
          <div className="profile-field">
            <label>Username:</label>
            <span>{user?.username}</span>
          </div>
          <div className="profile-field">
            <label>Email:</label>
            <span>{user?.email}</span>
          </div>
        </div>

        <div className="profile-section">
          <div className="section-header">
            <h2>Personal Information</h2>
            {!isEditing && (
              <button 
                onClick={() => setIsEditing(true)}
                className="btn btn-secondary"
              >
                Edit Profile
              </button>
            )}
          </div>

          <form onSubmit={handleSubmit} className="profile-form">
            <div className="form-row">
              <div className="form-group">
                <label htmlFor="firstName">First Name</label>
                <input
                  type="text"
                  id="firstName"
                  name="firstName"
                  value={formData.firstName}
                  onChange={handleChange}
                  disabled={!isEditing}
                  placeholder="Enter your first name"
                />
              </div>

              <div className="form-group">
                <label htmlFor="lastName">Last Name</label>
                <input
                  type="text"
                  id="lastName"
                  name="lastName"
                  value={formData.lastName}
                  onChange={handleChange}
                  disabled={!isEditing}
                  placeholder="Enter your last name"
                />
              </div>
            </div>

            <div className="form-row">
              <div className="form-group">
                <label htmlFor="dailyCalories">Daily Calorie Goal</label>
                <input
                  type="number"
                  id="dailyCalories"
                  name="dailyCalories"
                  value={formData.dailyCalories}
                  onChange={handleChange}
                  disabled={!isEditing}
                  placeholder="e.g., 2000"
                />
              </div>

              <div className="form-group">
                <label htmlFor="targetWeight">Target Weight (lbs)</label>
                <input
                  type="number"
                  id="targetWeight"
                  name="targetWeight"
                  value={formData.targetWeight}
                  onChange={handleChange}
                  disabled={!isEditing}
                  placeholder="e.g., 150"
                />
              </div>
            </div>

            <div className="form-row">
              <div className="form-group">
                <label htmlFor="theme">Theme</label>
                <select
                  id="theme"
                  name="theme"
                  value={formData.theme}
                  onChange={handleChange}
                  disabled={!isEditing}
                >
                  <option value="light">Light</option>
                  <option value="dark">Dark</option>
                </select>
              </div>

              <div className="form-group">
                <label>
                  <input
                    type="checkbox"
                    name="notifications"
                    checked={formData.notifications}
                    onChange={handleChange}
                    disabled={!isEditing}
                  />
                  Enable notifications
                </label>
              </div>
            </div>

            {isEditing && (
              <div className="form-actions">
                <button 
                  type="submit" 
                  className="btn btn-primary"
                  disabled={loading}
                >
                  {loading ? 'Saving...' : 'Save Changes'}
                </button>
                <button 
                  type="button" 
                  onClick={handleCancel}
                  className="btn btn-secondary"
                  disabled={loading}
                >
                  Cancel
                </button>
              </div>
            )}
          </form>
        </div>
      </div>
    </div>
  );
};

export default Profile;