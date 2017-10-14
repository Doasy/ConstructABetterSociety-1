
function coinsAccumulator(nickname, coins){
    $.ajax({
        url: "http://localhost:8080/users/search/findByNickname",
        dataType: "json",
        data: {
            name: nickname
        }
    }).then(function (user) {
        console.log(user);
        user.coins = user.coins + coins;
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/users/",
            data: JSON.stringify(user),
            dataType: "json",
            cache: false,
            timeout: 600000,
            success: function () {
                console.log("user coins actu");
            }
        });
    });
}