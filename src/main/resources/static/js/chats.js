// var channelId = document.getElementById("channelId").value
var messageBox = document.getElementById("messageInput")
var message = {
    // "channelId": channelId,
    "message": messageBox.value,
    "user": sessionStorage.getItem("username")
}
function sendMessage() {
    console.log(JSON.stringify(message))
    fetch('http://localhost:8080/channels/' + channelId, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(message)
    })
        .then((response) => {
            console.log(response)
            // return response.json()
        })
        .then((responseJson) => {
            console.log(responseJson)
        })
}
setInterval(function () {
    (message).load('http://localhost:8080/channels/' + channelId)
    .then((response) => response.json())
    .then((data) => {
        console.log(data);
    })
    .catch((error) => {
        console.error(error);
    });
}, 500);
