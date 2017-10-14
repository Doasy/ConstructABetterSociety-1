document.getElementById("new-comment-button").onclick = function() {myFunction()};

function myFunction() {
    document.getElementById("text").innerHTML =
        '<textarea rows="4"></textarea>' +
        '<a id="new-comment-button" href="#" class="btn btn-dark btn-lg js-scroll-trigger">Send</a>'
}