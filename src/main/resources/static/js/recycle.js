// refund.js

// let url = "http://43.136.37.148:80/statistics";
let url = "http://localhost:80/statistics";

// Function to get all recycle data from the server
function getAllRecycle() {
    fetch(url+"/recycle", {headers: {"Authorization": sessionStorage.getItem("token")}})
        .then(response => response.json())
        .then(data => {
            if (data.code === 200) {
                let str = "";
                data.data.forEach((item, index) => {
                    str += '<tr>\n' +
                        '            <td>' + (index + 1) + '</td>\n' +
                        '            <td>' + item.productName + '</td>\n' +
                        '            <td>' + item.returnId + '</td>\n' +
                        '            <td>' + item.palletid + '</td>\n' +
                        '            <td>' + item.username + '</td>\n' +
                        '            <td>' + item.returnDate + '</td>\n' +
                        '            <td>\n' +
                        '              <button class=\'operate-button edit\' onclick=\'editProduct(this.parentNode.parentNode)\'>Edit</button>\n' +
                        '              <button class="operate-button delete" onclick="deleteRecycle(' + item.returnId + ')">Delete</button>\n' +
                        '            </td>\n' +
                        '        </tr>'
                })
                document.getElementById("productTableBody").innerHTML = str;
            }
        })
}

// Function to add a new recycle
function addRecycle(){
    let productName = document.getElementById("productName").value;
    let returnId = document.getElementById("returnId").value;
    let palletId = document.getElementById("palletId").value;
    let username = document.getElementById("staff").value;
    // let returnDate = document.getElementById("returnDate").value;

    if(!productName ||!returnId ||!palletId ||!username){
        alert("Please fill out all fields.");
        return;
    }

    let data = {
        "productName": productName,
        "returnId": returnId,
        "palletid": palletId,
        "username": username,
        "returnType":"recycle"
    }

    fetch(url,{
        method: "POST",
        headers:{
            "Content-Type": "application/json",
            "Authorization": sessionStorage.getItem("token")
        },
        body: JSON.stringify(data)
    }).then(res => res.json())
        .then(data => {
            if(data.code === 200){
                document.getElementById("addProductForm").style.display = "none";
                getAllRecycle();
            }
        })
}

// function to delete a recycle
function deleteRecycle(returnId){
    if(confirm("Are you sure you want to delete this recycle?")){
        fetch(url+"/"+returnId, {
            method: "DELETE",
            headers: {
                "Authorization": sessionStorage.getItem("token")
            }
        }).then(res => res.json())
            .then(data => {
                if (data.code === 200) {
                    getAllRecycle();
                }
            })
    }
}

document.addEventListener("DOMContentLoaded", function () {

    // Function to parse URL parameters
    // function getUrlParameter(name) {
    //     name = name.replace(/[\[\]]/g, "\\$&");
    //     var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
    //         results = regex.exec(window.location.href);
    //     if (!results) return null;
    //     if (!results[2]) return '';
    //     return decodeURIComponent(results[2].replace(/\+/g, " "));
    // }
    //
    // // Function to populate fields with URL parameters
    // function populateFields() {
    //     // Get product information from URL parameters
    //     var productName = getUrlParameter('productName');
    //     var category = getUrlParameter('category');
    //     var lorryID = getUrlParameter('lorryID');
    //     var palletID = getUrlParameter('palletID');
    //     var staff = getUrlParameter('staff');
    //     var returnDate = getUrlParameter('returnDate');
    //
    //
    //     console.log("Product Name:", productName);
    //     console.log("Category:", category);
    //     console.log("Lorry ID:", lorryID);
    //     console.log("Pallet ID:", palletID);
    //     console.log("Staff:", staff);
    //     console.log("Return Date:", returnDate);
    //
    //     // Populate fields with product information
    //     document.getElementById("productName").value = productName;
    //     document.getElementById("category").value = category;
    //     document.getElementById("lorryID").value = lorryID;
    //     document.getElementById("palletID").value = palletID;
    //     document.getElementById("staff").value = staff;
    //     document.getElementById("returnDate").value = returnDate;
    //     console.log("Populated Product Name:", document.getElementById("productName").value);
    //
    // }
    //
    //
    // // Call the populateFields function when the page loads
    // populateFields();

    // Listen for messages from Receiving page using window.postMessage
    // window.addEventListener('message', function (event) {
    //     if (event.origin !== window.location.origin) {
    //         return; // Only accept messages from the same origin
    //     }
    //
    //     var data = event.data;
    //
    //     // Get the table body of the Repair page
    //     var repairTableBody = document.getElementById("productTableBody");
    //
    //     // Create a new row for the Repair table
    //     var newRow = repairTableBody.insertRow(repairTableBody.rows.length);
    //
    //     // Add cells to the new row with the received information
    //     newRow.innerHTML = "<td>" + (repairTableBody.rows.length) + "</td>" +
    //         "<td>" + data.productName + "</td>" +
    //         "<td>" + data.category + "</td>" +
    //         "<td>" + data.lorryID + "</td>" +
    //         "<td>" + data.palletID + "</td>" +
    //         "<td>" + data.staff + "</td>" +
    //         "<td>" + data.returnDate + "</td>" +
    //         "<td><button class='operate-button edit'>Edit</button>" +
    //         "<button class='operate-button delete'>Delete</button></td>";
    // });

    // Function to show or hide the add product form
    function toggleAddProductForm() {
        var form = document.getElementById("addProductForm");
        form.style.display = form.style.display === "none" ? "block" : "none";
    }

    // Function to add a new product
    // Function to add a new product
    // function addProduct() {
    //     // Get form inputs
    //     var productName = document.getElementById("productName").value.trim();
    //     var category = document.getElementById("category").value.trim();
    //     var lorryID = document.getElementById("lorryID").value.trim();
    //     var palletID = document.getElementById("palletID").value.trim();
    //     var staff = document.getElementById("staff").value.trim();
    //     var returnDate = document.getElementById("returnDate").value.trim();
    //
    //     // Check if any field is empty
    //     if (productName === '' || category === '' || lorryID === '' || palletID === '' || staff === '' || returnDate === '') {
    //         alert("Please fill out all fields.");
    //         return;
    //     }
    //
    //     // Add new row to the table
    //     var table = document.getElementById("productTableBody");
    //     var newRow = table.insertRow(table.rows.length);
    //     newRow.innerHTML = "<td>" + (table.rows.length) + "</td>" +
    //         "<td>" + productName + "</td>" +
    //         "<td>" + category + "</td>" +
    //         "<td>" + lorryID + "</td>" +
    //         "<td>" + palletID + "</td>" +
    //         "<td>" + staff + "</td>" +
    //         "<td>" + returnDate + "</td>" +
    //         "<td><button class='operate-button edit'>Edit</button>" +
    //         "<button class='operate-button delete'>Delete</button></td>";
    //
    //     // Clear input fields after adding product
    //     document.getElementById("productName").value = '';
    //     document.getElementById("category").value = '';
    //     document.getElementById("lorryID").value = '';
    //     document.getElementById("palletID").value = '';
    //     document.getElementById("staff").value = '';
    //     document.getElementById("returnDate").value = '';
    //
    //     // Update serial numbers
    //     updateSerialNumbers();
    //
    //     // Hide the add product form after adding the product
    //     toggleAddProductForm();
    // }


    // Function to update serial numbers
    // function updateSerialNumbers() {
    //     var rows = document.querySelectorAll("#productTableBody tr");
    //     for (var i = 0; i < rows.length; i++) {
    //         rows[i].querySelector("td:first-child").textContent = i + 1;
    //     }
    // }

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
        editButton.addEventListener("click", function(event) {
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
        console.log(updatedValues)
        let data = {
            "productName": updatedValues[0],
            "returnId": updatedValues[1],
            "palletid": updatedValues[2],
            "username": updatedValues[3],
            "returnDate": updatedValues[4]
        }

        // Send updated product information to the server
        fetch(url, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
                "Authorization": sessionStorage.getItem("token")
            },
            body: JSON.stringify(data)
        }).then(res => res.json())
            .then(data => {
                if (data.code === 200) {
                    getAllRecycle();
                }
            })

        // Update cell content with new values
        for (var i = 1; i < cells.length - 1; i++) {
            cells[i].innerText = updatedValues[i - 1];
        }

        // Reset cells back to non-editable state
        for (var i = 1; i < cells.length - 1; i++) {
            cells[i].innerHTML = updatedValues[i - 1];
        }

        // Change button text back to "Edit"
        var editButton = cells[cells.length - 1].querySelector(".edit");
        editButton.innerText = "Edit";
        editButton.removeEventListener("click", updateProduct); // Remove update listener
        editButton.addEventListener("click", function(event) {
            event.stopPropagation(); // Stop event propagation
            editProduct(row); // Re-attach editProduct listener
        });
    }

    // Function to remove a product
    // function removeProduct(row) {
    //     row.parentNode.removeChild(row);
    //     updateSerialNumbers(); // Update serial numbers after deleting a row
    // }

    // Add event listener for showAddProductFormButton
    document.getElementById("showAddProductFormButton").addEventListener("click", toggleAddProductForm);

    // Add event listener for add button
    document.getElementById("addButton").addEventListener("click", addRecycle);

    // Event delegation for delete buttons
    // document.getElementById("productTableBody").addEventListener("click", function(event) {
    //     var target = event.target;
    //
    //     // Check if the clicked element is a delete button
    //     if (target.classList.contains("delete")) {
    //         var row = target.parentNode.parentNode;
    //         removeProduct(row);
    //     }
    // });

    // Event delegation for edit buttons
    document.getElementById("productTableBody").addEventListener("click", function(event) {
        var target = event.target;
        // Check if the clicked element is an edit button
        if (target.classList.contains("edit")) {
            var row = target.parentNode.parentNode;
            editProduct(row);
        }
    });

    getAllRecycle();
});

