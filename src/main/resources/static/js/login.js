// login page
document.addEventListener("DOMContentLoaded",()=>{
    if(localStorage.getItem("remember-me")){
        document.getElementById("remember-me").checked = true;
        document.getElementById("username").value = localStorage.getItem("userId");
        document.getElementById("password").value = localStorage.getItem("password");
    }
})

function login() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let isRemember = document.getElementById("remember-me").checked;

    if(!username.trim() || !password.trim()){
        alert("Please enter username or password");
        return;
    }

    let user = {"userId": username, "password": password}

    fetch("http://localhost:80/login",
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
                if(isRemember){
                    localStorage.setItem("userId",username);
                    localStorage.setItem("password",password);
                    localStorage.setItem("remember-me","remember");
                }else{
                    localStorage.removeItem("userId");
                    localStorage.removeItem("password");
                    localStorage.removeItem("remember-me");
                }
            }else{
                alert("Invalid username or password");
            }
        })
}
