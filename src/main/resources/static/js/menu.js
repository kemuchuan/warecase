document.addEventListener("DOMContentLoaded",()=>{
    let permission = sessionStorage.getItem("permission");
    let tagName = document.getElementById("sidebar").getElementsByTagName('ul');
    let menuItems = tagName[0].getElementsByTagName('li');
    if(permission === "Manager of Operations"){}
    else if(permission === "Senior Logistics and Shipping Associate"){
        for(let i = 0;i<menuItems.length;i++){
            let menu = menuItems[i];
            if(menu.innerText.includes("User")){
                menu.style.display = "none";
            }
        }
    }else if(permission === "Junior Logistics and Shipping Associate"){

        for(let i = 0;i<menuItems.length;i++){
            let menu = menuItems[i];
            if(menu.innerText.includes("User")
                || menu.innerText.includes("Refund")
                || menu.innerText.includes("Recycle")
                || menu.innerText.includes("Repair")){
                menu.style.display = "none";
            }
        }
    }
})