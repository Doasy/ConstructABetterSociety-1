locations = []
city = "Barcelona"

//TODO: Filter

$.ajax({
    url: "http://localhost:8080/places/search/findByCity",
    data: {
        name: city
    },
    dataType: "json",
}).then(function(placeOutput){

    placeOutput._embedded.places.forEach(function (place) {
        locations.push([place.name, parseFloat(place.latitude) , parseFloat(place.longitude), city]);
    });

    var map = new google.maps.Map(document.getElementById('container-comments'), {
        zoom: 13,
        center: new google.maps.LatLng(locations[0][1], locations[0][2]),
        mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    var infowindow = new google.maps.InfoWindow();

    var marker, i;

    for (i = 0; i < locations.length; i++) {
        marker = new google.maps.Marker({
            position: new google.maps.LatLng(locations[i][1], locations[i][2]),
            map: map
        });

        google.maps.event.addListener(marker, 'click', (function (marker, i) {
            return function () {
                infowindow.setContent(locations[i][0]);
                infowindow.open(map, marker);
                document.getElementById("search").value = locations[i][0] + ", " + locations[i][3];
            }
        })(marker, i));
    }
});


