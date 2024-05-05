document.addEventListener("DOMContentLoaded", function() {
    // Function to show or hide the add product form
    function toggleAddProductForm() {
        var form = document.getElementById("addProductForm");
        form.style.display = form.style.display === "none" ? "block" : "none";
    }

    // Receive data from localStorage
    var receivedData = localStorage.getItem("productData");
    if (receivedData) {
        var productData = JSON.parse(receivedData);
        // Only add if the category is "Repair"
        if (productData.category === "Repair") {  
            addProductToRepairTable(productData); 
        }
        localStorage.removeItem("productData"); // Clear after receiving
    }


    // Function to add a new product
    function addProduct() {
        // Get form inputs
        var productName = document.getElementById("productName").value.trim();
        var category = document.getElementById("category").value.trim();
        var lorryID = document.getElementById("lorryID").value.trim();
        var palletID = document.getElementById("palletID").value.trim();
        var staff = document.getElementById("staff").value.trim();
        var returnDate = document.getElementById("returnDate").value.trim();

        // Check if any field is empty
        if (productName === '' || category === '' || lorryID === '' || palletID === '' || staff === '' || returnDate === '') {
            alert("Please fill out all fields.");
            return;
        }

        // Add new row to the table
        var table = document.getElementById("productTableBody");
        var newRow = table.insertRow(table.rows.length);
        newRow.innerHTML = "<td>" + (table.rows.length) + "</td>" +
                           "<td>" + productName + "</td>" +
                           "<td>" + category + "</td>" +
                           "<td>" + lorryID + "</td>" +
                           "<td>" + palletID + "</td>" +
                           "<td>" + staff + "</td>" +
                           "<td>" + returnDate + "</td>" +
                           "<td><button class='operate-button edit'>Edit</button>" +
                           "<button class='operate-button delete'>Delete</button></td>";

        // Clear input fields after adding product
        document.getElementById("productName").value = '';
        document.getElementById("category").value = '';
        document.getElementById("lorryID").value = '';
        document.getElementById("palletID").value = '';
        document.getElementById("staff").value = '';
        document.getElementById("returnDate").value = '';

        // Update serial numbers
        updateSerialNumbers();

        // Hide the add product form after adding the product
        toggleAddProductForm();
    }


    function addProductToRepairTable(productData) {
        var table = document.getElementById("productTableBody");
        var newRow = table.insertRow(table.rows.length); 
    
        // Use productData to populate the cells 
        newRow.innerHTML = "<td>" + (table.rows.length) + "</td>" +
                           "<td>" + productData.productName + "</td>" +
                           "<td>" + productData.category + "</td>" +
                           "<td>" + productData.lorryID + "</td>" +
                           "<td>" + productData.palletID + "</td>" +
                           "<td>" + productData.staff + "</td>" +
                           "<td>" + productData.returnDate + "</td>" +
                           "<td><button class='operate-button edit'>Edit</button>" + 
                           "<button class='operate-button delete'>Delete</button></td>";
    
        // Update serial numbers (if needed)
        updateSerialNumbers(); 
    }
    

    // Define categories
    const categories = ["Repair", "Refund", "Recycle"];

    // Populate category select element
    console.log("Trying to find select element...");  
    const categorySelect = document.getElementById("category");
    console.log("categorySelect:", categorySelect);  

    if (categorySelect) {
        console.log("Found the select element!"); 

        categories.forEach(category => {
            console.log("Adding option:", category); 
            const option = document.createElement("option");
            option.value = category;
            option.text = category;
            categorySelect.appendChild(option);
        });
    } else {
        console.log("Cannot find the select element. Check your HTML 'id'.");  
    }

    // Function to update serial numbers
    function updateSerialNumbers() {
        var rows = document.querySelectorAll("#productTableBody tr");
        for (var i = 0; i < rows.length; i++) {
            rows[i].querySelector("td:first-child").textContent = i + 1;
        }
    }

    // Function to edit a product
    function editProduct(row) {
        console.log("Edit button clicked");
    
        // Get the cells of the row
        var cells = row.getElementsByTagName("td");
    
        // Make all cells except the first (#) and last (Operate) editable
        for (var i = 1; i < cells.length - 1; i++) {
            if (i === 2) { // Category column (index 2)
                var cellContent = cells[i].innerText; // Get existing category
    
                // Create the select element
                var select = document.createElement("select");
    
                // Populate the select element with options
                categories.forEach(category => {
                    const option = document.createElement("option");
                    option.value = category;
                    option.text = category;
                    select.appendChild(option);
    
                    // Select the option matching the existing category
                    if (category === cellContent) {
                        option.selected = true;
                    }
                });
    
                // Replace the cell content with the select element
                cells[i].innerHTML = "";
                cells[i].appendChild(select);
    
            } else { // Other columns
                var cellContent = cells[i].innerText;
                cells[i].innerHTML = "<input type='text' value='" + cellContent + "'>";
            }
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

        // Get the cells and input fields within them
        var cells = row.getElementsByTagName("td");
        var updatedValues = [];
    
        for (var i = 1; i < cells.length - 1; i++) {
            if (i === 2) { // Assuming index 2 is your Category column
                var select = cells[i].querySelector("select");
                updatedValues.push(select.value); 
            } else {
                var inputField = cells[i].querySelector("input");
                updatedValues.push(inputField.value.trim());
            }
        }
    
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
    function removeProduct(row) {
        row.parentNode.removeChild(row);
        updateSerialNumbers(); // Update serial numbers after deleting a row
    }

    // Add event listener for showAddProductFormButton
    document.getElementById("showAddProductFormButton").addEventListener("click", toggleAddProductForm);

    // Add event listener for add button
    document.getElementById("addButton").addEventListener("click", addProduct);

    // Event delegation for delete buttons
    document.getElementById("productTableBody").addEventListener("click", function(event) {
        var target = event.target;

        // Check if the clicked element is a delete button
        if (target.classList.contains("delete")) {
            var row = target.parentNode.parentNode;
            removeProduct(row);
        }
    });

    // Event delegation for edit buttons
    document.getElementById("productTableBody").addEventListener("click", function(event) {
        var target = event.target;

        // Check if the clicked element is an edit button
        if (target.classList.contains("edit")) {
            var row = target.parentNode.parentNode;
            editProduct(row);
        }
    });


    
});
