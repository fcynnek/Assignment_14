var messageBox = document.getElementById("messageInput");

function sendMessage() {
    var channelId = document.getElementById("channelId").value; // Retrieve the latest channelId value
    var message = {
        "message": messageBox.value,
        "user": sessionStorage.getItem("username")
    };

    console.log(JSON.stringify(message));

    fetch('http://localhost:8080/channels/' + channelId, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(message)
    })
    .then((response) => {
        console.log(response);
        // return response.json();
    })
    .then((responseJson) => {
        console.log(responseJson);
    })
    .catch((error) => {
        console.error(error);
    });

    messageBox.value = ""; // Clear the message input field
}

document.getElementById("sendMessage").addEventListener("click", sendMessage);

setInterval(function () {
    var channelId = document.getElementById("channelId").value; // Retrieve the latest channelId value

    fetch('http://localhost:8080/channels/' + channelId)
    .then((response) => response.json())
    .then((data) => {
        console.log(data);
        // Process the received data, update the message container, etc.
    })
    .catch((error) => {
        console.error(error);
    });
}, 500);
