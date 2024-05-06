
document.addEventListener("DOMContentLoaded", function() {
    // Retrieve user information from local storage
    var currentUser = JSON.parse(localStorage.getItem("currentUser"));

    if (currentUser) {
        // Display welcome message with username
        var welcomeMessage = "Welcome, " + currentUser.username + "!";
        document.getElementById("welcomeMessage").innerText = welcomeMessage;
    }

    // Display current date and time
    var dateTime = new Date().toLocaleString();
    document.getElementById("dateTime").innerText = "Current Date and Time: " + dateTime;
});
