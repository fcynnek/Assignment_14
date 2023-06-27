function sendMessage() {
    var channelId = document.getElementById("channelId").value
    var messageBox = document.getElementById("messageInput")
    var message = {
        "channelId": channelId,
        "message": messageBox.value,
        "username": sessionStorage.getItem("username")
    }
}