
$(document).ready(function() {
    $.ajax({
        url : "http://localhost:8080/places/search/findByNameContains",
        dataType: "json",
        data: { "q" : getParameterByName("place").split(',')[0] }
    }).then(function (data) {
        console.log(data);
        data = data._embedded.places[0];
        $("#place-name").append(data.name);
        $("#city").append(data.city.name);
        $("#description").append(data.description);
        $("#ubication").append("Long:" + data.longitude + " " + "Lat: " + data.latitude);
        $("#place-image").attr("src", "../img/places/" + data.name + ".jpg");
    });
});


function getParameterByName(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}