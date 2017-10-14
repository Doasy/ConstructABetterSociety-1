


$('#Submit').on("click", function() {
    var userInput = document.getElementById("search").value;
    var placeCity = userInput.split(", ");
    $.ajax({
        url: "http://localhost:8080/places/search/findByNameEquals",
        dataType: "json",
        data: {
            name: placeCity[0]
        }
    }).then(function(placeOutput) {
        console.log(placeOutput);
        $.ajax({
            url: "http://localhost:8080/comments/search/findByPlace",
            dataType: "json",
            data: {
                place: placeOutput.name
            }
        }).then(function (commentOutput) {
            console.log(commentOutput);
        });
    });
});