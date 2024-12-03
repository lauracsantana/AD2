// -------------------------------------- animation page -----------------------------------------------------------

document.addEventListener("DOMContentLoaded", () => {
  const container = document.querySelector(".falling-money-container");

  function createMoney() {
    const money = document.createElement("img");
    money.src = "../images/small_logo1.png"; // Path to your money image
    money.classList.add("money");

    // Random horizontal start position
    money.style.left = Math.random() * window.innerWidth + "px";

    // Random animation duration
    money.style.animationDuration = Math.random() * 2 + 3 + "s";

    container.appendChild(money);

    // Remove the element after animation ends
    money.addEventListener("animationend", () => {
      money.remove();
    });
  }

  // Create multiple falling money elements
  setInterval(createMoney, 300); // Change frequency as needed
});


// -------------------------------------- bills page -----------------------------------------------------------
document.getElementById('fetchEventsBtn').addEventListener('click', fetchGoogleCalendarEvents);

function fetchGoogleCalendarEvents() {
    fetch('/api/calendar/events')
        .then(response => response.json())
        .then(events => {
            const eventsContainer = document.getElementById('eventsContainer');
            eventsContainer.innerHTML = ''; // Clear previous events

            if (events.length === 0) {
                eventsContainer.innerHTML = '<p>No upcoming events found.</p>';
            } else {
                events.forEach(event => {
                    const eventElement = document.createElement('p');
                    const start = event.start.dateTime || event.start.date; // Use dateTime if available
                    eventElement.textContent = `${start}: ${event.summary}`;
                    eventsContainer.appendChild(eventElement);
                });
            }
        })
        .catch(error => {
            console.error('Error fetching Google Calendar events:', error);
            document.getElementById('eventsContainer').innerHTML = '<p>Error loading events.</p>';
        });
}



// -------------------------------------- analytics page ----------------------------------------------------------

function showAnalytics() {
  // Get selected date
  const date = document.getElementById("timeSlotDate").value;
  
  // Placeholder function to show analytics result
  const resultDiv = document.getElementById("analyticsResult");
  if (date) {
      resultDiv.innerHTML = `Displaying analytics data for selected date: ${date}`;
  } else {
      resultDiv.innerHTML = "Please select a date to view analytics.";
  }
  resultDiv.style.display = "block";
}
