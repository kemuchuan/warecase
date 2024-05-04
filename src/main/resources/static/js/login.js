// login page

function login() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    if(!username.trim() || !password.trim()){
        alert("Please enter username or password");
    }

    let user = {"userId": username, "password": password}

    fetch("http://localhost:8080/login",
        {
            method: "post",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(user)
        })
        .then(res => res.json())
        .then(data => {
            if(data.code === 200){
                sessionStorage.setItem("token", data.token)
                sessionStorage.setItem("permission", data.permission)
                sessionStorage.setItem("userId", user.userId)
                // localStorage.setItem("token", data.token)
                // localStorage.setItem("permission", data.permission)
                // localStorage.setItem("userId", user.userId)
                window.location.href = "home.html"; // Redirect to main application page
            }else{
                alert("Invalid username or password");
            }
        })
}
