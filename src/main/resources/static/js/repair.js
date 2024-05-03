// repair.js

document.addEventListener("DOMContentLoaded", function() {

    console.log("DOMContentLoaded event triggered");

    // Function to parse URL parameters
    function getUrlParameter(name) {
        name = name.replace(/[\[\]]/g, "\\$&");
        var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
            results = regex.exec(window.location.href);
        if (!results) return null;
        if (!results[2]) return '';
        return decodeURIComponent(results[2].replace(/\+/g, " "));
    }


    
    
    // Function to populate fields with URL parameters
    function populateFields() {
        // Get product information from URL parameters
        var productName = getUrlParameter('productName');
        var category = getUrlParameter('category');
        var lorryID = getUrlParameter('lorryID');
        var palletID = getUrlParameter('palletID');
        var staff = getUrlParameter('staff');
        var returnDate = getUrlParameter('returnDate');


    console.log("Product Name:", productName);
    console.log("Category:", category);
    console.log("Lorry ID:", lorryID);
    console.log("Pallet ID:", palletID);
    console.log("Staff:", staff);
    console.log("Return Date:", returnDate);



        // Populate fields with product information
        document.getElementById("productName").value = productName;
        document.getElementById("category").value = category;
        document.getElementById("lorryID").value = lorryID;
        document.getElementById("palletID").value = palletID;
        document.getElementById("staff").value = staff;
        document.getElementById("returnDate").value = returnDate;
        console.log("Populated Product Name:", document.getElementById("productName").value);

    }



    // Call the populateFields function when the page loads
    populateFields();

     // Listen for messages from Receiving page using window.postMessage
  window.addEventListener('message', function(event) {
    if (event.origin !== window.location.origin) {
      return; // Only accept messages from the same origin
    }

    var data = event.data;

    // Get the table body of the Repair page
    var repairTableBody = document.getElementById("productTableBody");

    // Create a new row for the Repair table
    var newRow = repairTableBody.insertRow(repairTableBody.rows.length);

    // Add cells to the new row with the received information
    newRow.innerHTML = "<td>" + (repairTableBody.rows.length) + "</td>" +
                       "<td>" + data.productName + "</td>" +
                       "<td>" + data.category + "</td>" +
                       "<td>" + data.lorryID + "</td>" +
                       "<td>" + data.palletID + "</td>" +
                       "<td>" + data.staff + "</td>" +
                       "<td>" + data.returnDate + "</td>" +
                       "<td><button class='operate-button edit'>Edit</button>" +
                       "<button class='operate-button delete'>Delete</button></td>";
  });
});

