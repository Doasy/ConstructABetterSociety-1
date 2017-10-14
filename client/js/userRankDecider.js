
function rankCalculator(nickname, punctuation) {
    $.ajax({
        url: "http://localhost:8080/users/search/findByNickname",
        dataType: "json",
        data: {
            name: nickname
        }
    }).then(function(user) {
        console.log(user);
        if(user.numberOfTimesRated === 0){
            user.rank = punctuation;
        }else{
            user.rank = ((user.rank*user.numberOfTimesRated) + punctuation) / (user.numberOfTimesRated + 1);
        }
        $.ajax({

        });
    });
}
