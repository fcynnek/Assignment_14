function sendMessage() {
    // var channelId = document.getElementById("channelId").value
    var messageBox = document.getElementById("messageInput")
    var message = {
        // "channelId": channelId,
        "message": messageBox.value,
        "user": sessionStorage.getItem("username")
    }
    console.log(JSON.stringify(message))
    fetch('http://localhost:8080/messages', {
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
// setInterval(function () {
//     $('#messages').load('http://localhost:8080/messages')
// }, 500)
