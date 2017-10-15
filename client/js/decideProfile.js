
$.ajax({
    url: "http://localhost:8080/users/search/findByNickname",
    dataType: "json",
    data: {
        nickname: "Isomorfisme"
    }
}).then(function (user) {
    $('#nickname').append(user.id);
    $('#name').append(user.name+" "+user.surname);
    $('#email').append(user.email);
    $('#rate').append(user.rate);
    $('#votedTimes').append(user.numberOfTimesRated);
    $('#coins').append(user.coins);
});