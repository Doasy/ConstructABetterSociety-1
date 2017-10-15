$(function() {
    $("#new-place").autocomplete({
        source: function( request, response ) {
            $.ajax({
                url: "https://maps.googleapis.com/maps/api/geocode/json",
                dataType: 'json',
                data : {
                    address: request.term,
                    region: "es",
                    key: "AIzaSyC5O2J8YmeOjOFGscZw9UJL7VAaPaTFcPI"
                },
                success: function( data ) {
                    response($.map(data.results, function (item) {
                        document.getElementById('lat').value=item.geometry.location.lat;
                        document.getElementById('lon').value=item.geometry.location.lng;
                        return {
                            label: item.formatted_address,
                            value: item.formatted_address
                        }
                    }));
                }
            });
        },
        minLength: 2
    });
});


$(function() {
    $("#city").autocomplete({
        source: function( request, response ) {
            $.ajax({

                url: "http://localhost:8080/cities/search/findByNameContains",
                dataType: 'json',
                data : {
                    name: request.term
                },
                success: function( data ) {
                    response($.map(data._embedded.cities, function (item) {
                        return {
                            label: item.name,
                            value: item.id
                        }
                    }));
                }
            });
        },
        minLength: 2
    });
});

$("#add-button").on("click", function() {
    var dict = { name: document.getElementById('new-place').value,
                latitude: document.getElementById('lat').value,
                longitude: document.getElementById('lon').value,
                city: '/cities/2'};

    coinsAccumulator("Isomorfisme", -100);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "http://localhost:8080/places",
        data: JSON.stringify(dict),
        dataType: "json",
        cache: false,
        timeout: 600000,
        success: function () {
            console.log("Post Done");
        },
        error: function () {
            console.log("Post DEP");
        }
    });
});
