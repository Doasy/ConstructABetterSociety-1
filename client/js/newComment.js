document.getElementById("new-comment-button").onclick = function() {myFunction()};

function myFunction() {
    document.getElementById("text").innerHTML =
        '<textarea id="comment-text" rows="4"></textarea>' +
        '<a id="send-comment" href="#" class="btn btn-dark btn-lg js-scroll-trigger">Send</a>'
}