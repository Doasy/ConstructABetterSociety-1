


$('#Submit').on("click", function() {
    var userInput = document.getElementById("search").value;
    var placeCity = userInput.split(", ");
    $.ajax({
        url: "http://localhost:8080/places/search/findByNameEquals",
        dataType: "json",
        data: {
            name: placeCity[0]
        }
    }).then(function(apiOutput) {
        console.log(apiOutput);
    });
});