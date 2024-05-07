// let url = "http://43.136.37.148:80/statistics"
let url = "http://localhost:80/statistics"

// Function to get all receive data from the server
function getAllReceive() {
    fetch(url, {headers: {"Authorization": sessionStorage.getItem("token")}})
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
                        '            <td>' + item.returnType + '</td>\n' +
                        '            <td>' + item.returnDate + '</td>\n' +
                        '            <td>\n' +
                        '              <button class=\'operate-button edit\' onclick=\'editProduct(this.parentNode.parentNode)\'>Edit</button>\n' +
                        '              <button class="operate-button delete" onclick="deleteReceive(' + item.returnId + ')">Delete</button>\n' +
                        '            </td>\n' +
                        '        </tr>'
                })
                document.getElementById("productTableBody").innerHTML = str;
            }
        })
}

// Function to add a new receive
function addReceive() {
    let productName = document.getElementById("productName").value;
    let returnId = document.getElementById("returnId").value;
    let palletId = document.getElementById("palletId").value;
    let username = document.getElementById("staff").value;
    let returnType = document.getElementById("returnType").value;
    // let returnDate = document.getElementById("returnDate").value;

    if (!productName || !returnId || !palletId || !username) {
        alert("Please fill out all fields.");
        return;
    }

    let data = {
        "productName": productName,
        "returnId": returnId,
        "palletid": palletId,
        "username": username,
        "returnType": returnType
    }

    fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Authorization": sessionStorage.getItem("token")
        },
        body: JSON.stringify(data)
    }).then(res => res.json())
        .then(data => {
            if (data.code === 200) {
                document.getElementById("addProductForm").style.display = "none";
                getAllReceive();
            }
        })
}

// function to delete a receive
function deleteReceive(returnId) {
    if (confirm("Are you sure you want to delete this receive?")) {
        fetch(url + "/" + returnId, {
            method: "DELETE",
            headers: {
                "Authorization": sessionStorage.getItem("token")
            }
        }).then(res => res.json())
            .then(data => {
                if (data.code === 200) {
                    getAllReceive();
                }
            })
    }
}

document.addEventListener("DOMContentLoaded", function () {
    // Existing functions...

    // Function to copy product information to Repair Management page
    function copyToRepair(row) {
        // Get the product information from the row
        var productName = row.cells[1].innerText;
        var category = row.cells[2].innerText;
        var lorryID = row.cells[3].innerText;
        var palletID = row.cells[4].innerText;
        var staff = row.cells[5].innerText;
        var returnDate = row.cells[6].innerText;

        // Prepare data object
        var data = {
            productName: productName,
            category: category,
            lorryID: lorryID,
            palletID: palletID,
            staff: staff,
            returnDate: returnDate,
        };

        // Prevent default button behavior
        event.preventDefault();

        // Send data to Repair page using window.postMessage
        window.postMessage(data, '*'); // '*' indicates any origin
    }

    // Add event listener for Repair button in Receiving Management page
    document.getElementById("productTableBody").addEventListener("click", function (event) {
        var target = event.target;

        // Check if the clicked element is the Repair button
        if (target.classList.contains("repair")) {
            var row = target.parentNode.parentNode;
            copyToRepair(row);
        }
    });

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

        let data = {
            "productName": updatedValues[0],
            "returnId":updatedValues[1],
            "palletid": updatedValues[2],
            "username": updatedValues[3],
            "returnType": updatedValues[4],
            "returnDate": updatedValues[5]
        }

        // Send updated receive information to the server
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
                    getAllReceive();
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

    // Add event listener for showAddProductFormButton
    document.getElementById("showAddProductFormButton").addEventListener("click", toggleAddProductForm);

    // Add event listener for add button
    document.getElementById("addButton").addEventListener("click", addReceive);

    // Event delegation for edit buttons
    document.getElementById("productTableBody").addEventListener("click", function(event) {
        var target = event.target;

        // Check if the clicked element is an edit button
        if (target.classList.contains("edit")) {
            var row = target.parentNode.parentNode;
            editProduct(row);
        }
    });
    getAllReceive();
});

