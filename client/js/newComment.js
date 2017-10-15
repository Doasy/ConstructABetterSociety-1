document.getElementById("new-comment-button").onclick = function() {myFunction()};

function myFunction() {
    document.getElementById("text").innerHTML =
        '<textarea id="comment-text" rows="4"></textarea>' +
        '<a id="send-comment" class="btn btn-dark btn-lg js-scroll-trigger" data-toggle="modal" data-target="#myModal">Send</a>'+
        '<div class="modal fade" id="myModal" role="dialog">' +
            '<div class="modal-dialog modal-sm">' +
                '<div class="modal-content">' +
                    '<div class="modal-header">' +
                        '<button type="button" class="close" data-dismiss="modal">&times;</button>' +
                        '<h4 class="modal-title">Comment done!</h4>' +
                    '</div>' +
                    '<div class="modal-body">' +
                        '<p>You\'ve earned 1 coin!!!</p>' +
                    '</div>' +
                '<div class="modal-footer">' +
                '   <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>' +
                '</div>' +
                '</div>' +
            '</div>' +
        '</div>';
    commentSaveRoutine();
}

function commentSaveRoutine(){
    $("#send-comment").on("click", function() {
        var comment = document.getElementById("comment-text").value;
        var placeName = getParameterByName('place').split(', ')[0];
        coinsAccumulator("Isomorfisme", 1);
        saveComment(comment, "Isomorfisme", placeName);
        updatePage(comment, "Isomorfisme");
    });
}

function saveComment(comment, nickname, placeName) {
    $.ajax({
        url: "http://localhost:8080/places/search/findByNameEquals",
        dataType: "json",
        data: {
            name: placeName
        }
    }).then(function (place) {
        $.ajax({
            url: "http://localhost:8080/users/search/findByNickname",
            dataType: "json",
            data: {
                nickname: nickname
            }
        }).then(function (user) {
            commentJObj = {
                        "place": place.uri,
                        "user": user.uri,
                        "type": "review",
                        "description": comment
            };
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "http://localhost:8080/comments/",
                data: JSON.stringify(commentJObj),
                dataType: "json",
                cache: false,
                timeout: 600000,
                success: function () {
                    console.log("saved comment");
                }
            });
        });
    });
}

function updatePage (comment, nickname){
    document.getElementById('container-js').innerHTML +=
        '<div id="container-comments" class="container-comments">\n' +
        '<div id="user" class="container-user">\n' +
        '        <h3 id="user-name">' + nickname + '</h3>\n' +
        '    </div>\n' +
        '    <div id="rating" class="container-rating">\n' +
        '        <fieldset class="rating">\n' +
        '            <input onclick="rankCalculator(&quot;\'+nickname+\'&quot;, 5);" type="radio" id="star5" name="rating" value="5"/><label class="full" for="star5"\n' +
        '                                                                           title="Awesome - 5 stars"></label>\n' +
        '            <input onclick="rankCalculator(&quot;\'+nickname+\'&quot;, 4);" type="radio" id="star4" name="rating" value="4"/><label class="full" for="star4"\n' +
        '                                                                           title="Pretty good - 4 stars"></label>\n' +
        '            <input onclick="rankCalculator(&quot;\'+nickname+\'&quot;, 3);" type="radio" id="star3" name="rating" value="3"/><label class="full" for="star3"\n' +
        '                                                                           title="Meh - 3 stars"></label>\n' +
        '            <input onclick="rankCalculator(&quot;\'+nickname+\'&quot;, 2);" type="radio" id="star2" name="rating" value="2"/><label class="full" for="star2"\n' +
        '                                                                           title="Kinda bad - 2 stars"></label>\n' +
        '            <input onclick="rankCalculator(&quot;\'+nickname+\'&quot;, 1);" type="radio" id="star1" name="rating" value="1"/><label class="full" for="star1"\n' +
        '                                                                           title="Sucks big time - 1 star"></label>\n' +
        '        </fieldset>\n' +
        '    </div>\n' +
        '    <div id="comment">\n' +
        '        <p>' + comment + '</p>\n' +
        '    </div>\n' +
        '</div>';
}