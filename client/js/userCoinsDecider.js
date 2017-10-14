
function coinsAccumulator(nickname, coins){
    $.ajax({
        url: "http://localhost:8080/users/search/findByNickname",
        dataType: "json",
        data: {
            nickname: nickname
        }
    }).then(function (user) {
        user.coins = user.coins + coins;
        $.ajax({
            type: "PUT",
            contentType: "application/json",
            url: "http://localhost:8080/users/"+user.id,
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