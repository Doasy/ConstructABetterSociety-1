
$(function() {
    $("#search").autocomplete({
        source: function( request, response ) {
            $.ajax({
                url: "http://localhost:8080/places/search/findByNameContains",
                dataType: 'json',
                data : {
                    q: request.term
                },
                success: function( data ) {
                    response($.map(data._embedded.places, function (item) {
                        return {
                            label: item.name + ", " + item.city.name,
                            value: item.name + ", " + item.city.name,
                        }
                    }));
                }
            });
        },
        minLength: 2
    });
});