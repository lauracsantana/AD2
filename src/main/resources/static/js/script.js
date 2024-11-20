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

const calendar = document.getElementById('calendarBody');
const monthYear = document.getElementById('monthYear');
let date = new Date();
let currentMonth = date.getMonth();
let currentYear = date.getFullYear();

function generateCalendar(month, year) {
    calendar.innerHTML = ''; // Clear previous calendar
    monthYear.innerHTML = `${new Date(year, month).toLocaleString('default', { month: 'long' })} ${year}`;

    const firstDay = new Date(year, month).getDay();
    const daysInMonth = 32 - new Date(year, month, 32).getDate();

    // Create empty cells for days before the start of the month
    for (let i = 0; i < firstDay; i++) {
        calendar.innerHTML += `<div></div>`;
    }

    // Create cells for each day of the month
    for (let day = 1; day <= daysInMonth; day++) {
        calendar.innerHTML += `<div>${day}</div>`;
    }
}

function prevMonth() {
    currentMonth = (currentMonth === 0) ? 11 : currentMonth - 1;
    currentYear = (currentMonth === 11) ? currentYear - 1 : currentYear;
    generateCalendar(currentMonth, currentYear);
}

function nextMonth() {
    currentMonth = (currentMonth === 11) ? 0 : currentMonth + 1;
    currentYear = (currentMonth === 0) ? currentYear + 1 : currentYear;
    generateCalendar(currentMonth, currentYear);
}

generateCalendar(currentMonth, currentYear);


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
