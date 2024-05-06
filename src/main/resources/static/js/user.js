let url = "http://localhost:80/user"

// table information initialization
function getAllUser(){
    fetch(url,{headers:{"Authorization":sessionStorage.getItem("token")}}).then(res => res.json()).then(data => {
        let str = '';
        data.data.forEach((item,index) => {
            str += "<tr>"+
                "<td>" + (index + 1) + "</td>" +
                "<td>" + item.userId + "</td>" +
                "<td>" + item.name + "</td>" +
                "<td>" + item.permission + "</td>" +
                "<td><button class='operate-button edit'>Edit</button>" +
                "<button class='operate-button delete' onclick='deleteUser(" + item.userId + ")'>Delete</button></td>" +
                "</tr>"
        });
        document.getElementById("productTableBody").innerHTML = str;
    })
}

// add user
function addUser(){
    let name = document.getElementById("name").value;
    let userId = document.getElementById("userId").value;
    let permission = document.getElementById("permission").value;
    if(!name.trim()||!userId.trim()||!permission.trim()){
        alert("Please fill out all fields.");
        return;
    }
    let data = {
        "name": name,
        "userId": userId,
        "permission": permission
    }
    fetch(url,{
        method:"POST",
        headers:{
            "Content-Type": "application/json",
            "Authorization":sessionStorage.getItem("token")
        },
        body:JSON.stringify(data)
    }).then(res => res.json()).then(res => {
        if(res.code === 200){
            getAllUser();
            document.getElementById("addProductForm").style.display = "none";
        }
    })
}

// delete user
function deleteUser(userId){
    if(confirm("Are you sure to delete this user?")){
        fetch(url+"/" + userId,{
            method:"DELETE",
            headers:{
                "Authorization":sessionStorage.getItem("token")
            }
        }).then(res => res.json()).then(res => {
            if(res.code === 200){
                getAllUser();
            }
        })
    }
}

document.addEventListener("DOMContentLoaded", function () {

    // Function to show or hide the add product form
    function toggleAddProductForm() {
        var form = document.getElementById("addProductForm");
        form.style.display = form.style.display === "none" ? "block" : "none";
    }

    // Function to edit a product
    function editProduct(row) {
        console.log("Edit button clicked");

        // Get the cells of the row
        var cells = row.getElementsByTagName("td");

        // Make all cells except the first (#) and last (Operate) editable
        for (var i = 1; i < cells.length - 1; i++) {
            var cellContent = cells[i].innerText;
            cells[i].innerHTML = "<input type='text' value='" + cellContent + "'>";
        }

        // Get the edit button and update text/listener
        var editButton = cells[cells.length - 1].querySelector(".edit");
        editButton.innerText = "Update";
        editButton.addEventListener("click", function (event) {
            event.stopPropagation(); // Stop event propagation
            updateProduct(row); // Call update function on click
        });
    }

    // Function to update a product
    function updateProduct(row) {
        console.log("Update button clicked");

        // Get the cells and input fields within them
        var cells = row.getElementsByTagName("td");
        var updatedValues = [];
        for (var i = 1; i < cells.length - 1; i++) {
            var inputField = cells[i].querySelector("input");
            updatedValues.push(inputField.value.trim());
        }

        let data = {
            "userId":updatedValues[0],
            "name":updatedValues[1],
            "permission":updatedValues[2]
        }

        fetch(url,{
            method:"PUT",
            headers:{
                "Content-Type": "application/json",
                "Authorization":sessionStorage.getItem("token")
            },
            body:JSON.stringify(data)
        }).then(res => res.json())
            .then(data => {
                if(data.code === 200){
                    // Update cell content with new values
                    for (var i = 1; i < cells.length - 1; i++) {
                        cells[i].innerText = updatedValues[i - 1];
                    }

                    // Reset cells back to non-editable state
                    for (var i = 1; i < cells.length - 1; i++) {
                        cells[i].innerHTML = updatedValues[i - 1];
                    }
                    // getAllUser();
                }
            })

        // Change button text back to "Edit"
        var editButton = cells[cells.length - 1].querySelector(".edit");
        editButton.innerText = "Edit";
        editButton.removeEventListener("click", updateProduct); // Remove update listener
        editButton.addEventListener("click", function (event) {
            event.stopPropagation(); // Stop event propagation
            editProduct(row); // Re-attach editProduct listener
        });
    }

    // Add event listener for showAddProductFormButton
    document.getElementById("showAddProductFormButton").addEventListener("click", toggleAddProductForm);

    // Add event listener for add button
    document.getElementById("addButton").addEventListener("click", addUser);

    // Event delegation for edit buttons
    document.getElementById("productTableBody").addEventListener("click", function (event) {
        var target = event.target;
        // Check if the clicked element is an edit button
        if (target.classList.contains("edit")) {
            var row = target.parentNode.parentNode;
            editProduct(row);
        }
    });

    getAllUser();

});




