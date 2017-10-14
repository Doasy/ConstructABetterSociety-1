
function rankCalculator(nickname, punctuation) {
    $.ajax({
        url: "http://localhost:8080/users/search/findByNickname",
        dataType: "json",
        data: {
            nickname: nickname
        }
    }).then(function(user) {
        if(user.numberOfTimesRated === 0){
            user.rate = punctuation;
        }else{
            user.rate = ((user.rate*user.numberOfTimesRated) + punctuation) / (user.numberOfTimesRated + 1);
        }
        user.numberOfTimesRated++;
        console.log(user);
        $.ajax({
            type: "PUT",
            contentType: "application/json",
            url: "http://localhost:8080/users/"+user.id,
            data: JSON.stringify(user),
            dataType: "json",
            cache: false,
            timeout: 600000,
            success: function () {
                console.log("user rateing actu");
            }
        });
    });
}