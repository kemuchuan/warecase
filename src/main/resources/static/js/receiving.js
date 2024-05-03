// Define the getUrlParameter function
function getUrlParameter(name) {
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(window.location.href);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}

// Execute code when the DOM content is loaded
document.addEventListener("DOMContentLoaded", function() {
    // Use the getUrlParameter function to retrieve the "productName" parameter

    var productName = "ExampleProduct";
    // Display the value of the "productName" parameter
    var productName = getUrlParameter('productName');
    // Display the value of the "productName" parameter
});
// receiving.js



document.addEventListener("DOMContentLoaded", function() {
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
    document.getElementById("productTableBody").addEventListener("click", function(event) {
        var target = event.target;

        // Check if the clicked element is the Repair button
        if (target.classList.contains("repair")) {
            var row = target.parentNode.parentNode;
            copyToRepair(row);
        }
    });
    });

