
$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/load-data"
    }).then(function (data) {
        console.log(data);
    });
});