// login page

function login() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    // Simulated user database
    var users = [
        { username: "admin", password: "admin", role: "admin" },
        { username: "user", password: "user", role: "user" }
    ];

    // Check if user exists and password matches
    var authenticatedUser = users.find(function(user) {
        return user.username === username && user.password === password;
    });

    if (authenticatedUser) {
        // Set user role and redirect to main application page
        localStorage.setItem("currentUser", JSON.stringify(authenticatedUser));
        window.location.href = "home.html"; // Redirect to main application page
    } else {
        alert("Invalid username or password");
    }
}
