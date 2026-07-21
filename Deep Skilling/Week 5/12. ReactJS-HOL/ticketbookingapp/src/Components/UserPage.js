import React, { useState } from 'react';
import flights from './flightData';

function UserPage({ onLogout }) {
  const [bookedFlights, setBookedFlights] = useState([]);
  const [notification, setNotification] = useState(null);

  const handleBook = (flight) => {
    if (bookedFlights.find((f) => f.id === flight.id)) {
      showNotification(`✅ Already booked ${flight.airline} to ${flight.to}!`, 'info');
      return;
    }
    setBookedFlights([...bookedFlights, flight]);
    showNotification(`🎉 Successfully booked ${flight.airline} to ${flight.to}!`, 'success');
  };

  const showNotification = (msg, type) => {
    setNotification({ msg, type });
    setTimeout(() => setNotification(null), 3000);
  };

  const handleCancel = (flightId) => {
    setBookedFlights(bookedFlights.filter((f) => f.id !== flightId));
    showNotification('❌ Booking cancelled.', 'cancel');
  };

  return (
    <div className="page user-page">
      {/* Notification */}
      {notification && (
        <div className={`notification notification-${notification.type}`}>
          {notification.msg}
        </div>
      )}

      {/* User Hero */}
      <div className="hero user-hero">
        <div className="hero-content">
          <p className="hero-badge user-badge">👤 Logged In</p>
          <h1 className="hero-title">Book Your Next Adventure</h1>
          <p className="hero-subtitle">
            Welcome back, <strong>Traveler!</strong> Choose from our best flights and book instantly.
          </p>
          <button className="btn btn-logout-hero" onClick={onLogout}>
            🚪 Logout
          </button>
        </div>
        <div className="hero-stats">
          <div className="stat">
            <span className="stat-num">{bookedFlights.length}</span>
            <span className="stat-label">Booked</span>
          </div>
          <div className="stat">
            <span className="stat-num">{flights.length - bookedFlights.length}</span>
            <span className="stat-label">Available</span>
          </div>
          <div className="stat">
            <span className="stat-num">24/7</span>
            <span className="stat-label">Support</span>
          </div>
        </div>
      </div>

      {/* Booked Flights Summary */}
      {bookedFlights.length > 0 && (
        <div className="booked-section">
          <h2 className="section-title booked-title">🎟️ Your Bookings ({bookedFlights.length})</h2>
          <div className="booked-list">
            {bookedFlights.map((flight) => (
              <div className="booked-card" key={flight.id}>
                <span className="booked-logo">{flight.logo}</span>
                <div className="booked-info">
                  <p className="booked-airline">{flight.airline}</p>
                  <p className="booked-route">{flight.from} → {flight.to}</p>
                  <p className="booked-time">{flight.departure} - {flight.arrival}</p>
                </div>
                <div className="booked-price">{flight.price}</div>
                <button className="btn btn-cancel" onClick={() => handleCancel(flight.id)}>
                  ✕ Cancel
                </button>
              </div>
            ))}
          </div>
        </div>
      )}

      {/* All Flights */}
      <section className="flights-section">
        <h2 className="section-title">Available Flights</h2>
        <div className="flights-grid">
          {flights.map((flight) => {
            const isBooked = bookedFlights.find((f) => f.id === flight.id);
            return (
              <div className={`flight-card ${isBooked ? 'flight-booked' : ''}`} key={flight.id}>
                <div className="flight-header">
                  <div className="airline-info">
                    <span className="airline-logo">{flight.logo}</span>
                    <div>
                      <p className="airline-name">{flight.airline}</p>
                      <p className="flight-class">{flight.class}</p>
                    </div>
                  </div>
                  <div className="flight-badge">{flight.type}</div>
                </div>

                <div className="flight-route">
                  <div className="route-point">
                    <p className="route-time">{flight.departure}</p>
                    <p className="route-city">{flight.from}</p>
                  </div>
                  <div className="route-line">
                    <span className="route-duration">{flight.duration}</span>
                    <div className="line">
                      <div className="dot"></div>
                      <div className="dash"></div>
                      <span className="plane-icon">✈</span>
                      <div className="dash"></div>
                      <div className="dot"></div>
                    </div>
                  </div>
                  <div className="route-point">
                    <p className="route-time">{flight.arrival}</p>
                    <p className="route-city">{flight.to}</p>
                  </div>
                </div>

                <div className="flight-footer">
                  <div className="price-block">
                    <span className="price-label">Starting from</span>
                    <span className="price">{flight.price}</span>
                  </div>
                  {isBooked ? (
                    <button className="btn btn-booked-state" disabled>
                      ✅ Booked
                    </button>
                  ) : (
                    <button className="btn btn-book" onClick={() => handleBook(flight)}>
                      🎟️ Book Now
                    </button>
                  )}
                </div>
              </div>
            );
          })}
        </div>
      </section>
    </div>
  );
}

export default UserPage;
