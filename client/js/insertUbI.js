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