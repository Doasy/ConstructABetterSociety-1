function extracted(userInput) {
    var placeCity = userInput.split(", ");

    $.ajax({
        url: "http://localhost:8080/places/search/findByNameEquals",
        dataType: "json",
        data: {
            name: placeCity[0]
        }
    }).then(function (placeOutput) {
        console.log(placeOutput);
        $.ajax({
            url: "http://localhost:8080/comments/search/findByPlace",
            dataType: "json",
            data: {
                place: placeOutput.name
            }
        }).then(function (commentOutput) {
            if (commentOutput._embedded.comments.length === 0) {
                document.getElementById("show-comments").disabled = true;
            }else{
                setComments(commentOutput);
            }
            document.getElementById("container-js").style.visibility = 'hidden';
            activateCommentShowerButton();
        });
    });
}

function setComments(commentOutput) {
    commentOutput['_embedded']['comments'].forEach(function (comment) {
        var nickname = getUserNickname(comment);
        document.getElementById('container-js').innerHTML +=
            '<div id="container-comments" class="container-comments">\n' +
            '    <div id="user" class="container-user">\n' +
            '        <img id = "report" src="../img/report.png" height=2% width=2%>\n'+
            '        <h3 id="user-name">' + nickname + '</h3>\n' +
            '    </div>\n' +
            '    <div id="rating" class="container-rating">\n' +
            '        <fieldset class="rating">\n' +
            '            <input onclick="rankCalculator(&quot;'+nickname+'&quot;, 5);" type="radio" id="star5" name="rating" value="5"/><label class="full" for="star5"\n' +
            '                                                                           title="Awesome - 5 stars"></label>\n' +
            '            <input onclick="rankCalculator(&quot;'+nickname+'&quot;, 4);" type="radio" id="star4" name="rating" value="4"/><label class="full" for="star4"\n' +
            '                                                                           title="Pretty good - 4 stars"></label>\n' +
            '            <input onclick="rankCalculator(&quot;'+nickname+'&quot;, 3);" type="radio" id="star3" name="rating" value="3"/><label class="full" for="star3"\n' +
            '                                                                           title="Meh - 3 stars"></label>\n' +
            '            <input onclick="rankCalculator(&quot;'+nickname+'&quot;, 2);" type="radio" id="star2" name="rating" value="2"/><label class="full" for="star2"\n' +
            '                                                                           title="Kinda bad - 2 stars"></label>\n' +
            '            <input onclick="rankCalculator(&quot;'+nickname+'&quot;, 1);" type="radio" id="star1" name="rating" value="1"/><label class="full" for="star1"\n' +
            '                                                                           title="Sucks big time - 1 star"></label>\n' +
            '        </fieldset>\n' +
            '    </div>\n' +

            '    <div id="comment">\n' +
            '        <p>' + comment.description + '</p>\n' +
            '    </div>\n' +
            '</div>';
    });
}

function getUserNickname(comment){
    return typeof comment.user === "string" ? comment["user"].split('/')[2] : comment["user"]["uri"].split('/')[2];
}

function getParameterByName(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}

extracted(getParameterByName('place'));

function activateCommentShowerButton(){
    $("#show-comments").on("click", function() {
        document.getElementById("container-js").style.visibility = 'visible' ;
        coinsAccumulator("Isomorfisme", -1);
        document.getElementById("show-comments").disabled = true;
    });
}
