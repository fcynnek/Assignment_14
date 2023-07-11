var messageBox = document.querySelector("#messageBox");
var channelId = sessionStorage.getItem('channelId');
var user = sessionStorage.getItem('username');

setInterval(getMessages, 5000);

messageBox.addEventListener('keyup', (e) => {
    if (e.keyCode === 13) {
        let message = {
            "text": messageBox.value,
            "channelId": channelId,
            "user": user,
            "createdDate": new Date()
        };
        let messageText = messageBox.value;
        console.log(`Send message ${messageText}`);
        messageBox.value = '';
        fetch(`/channels/${channelId}/sendMessage`, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json; charset=utf-8'
          },
          body: JSON.stringify(message)
        })
        .then(response => {
            getMessages();
        });
        return false;
    }
});

function getMessages() {
  let messageContainer = document.querySelector(".message-container");
  fetch(`/channels/${channelId}/getMessages`)
      .then(response => (response.json()))
    //   .then(console.log(response))
    .then(response => {
      console.log('Entering first if');
        if (!response.ok) {
          throw new Error('Error fetching messages');
        }
        return response.json();
      })
      .then(data => {
        console.log('Entering second if');
        messageContainer.innerHTML = '';
        data.forEach(message => {
          messageContainer.innerHTML += `<div>
            <span class="timestamp">${message.user.name}: </span>
            <span class="message">${message.text}</span>
          </div>`;
        });
      })
      .catch(error => {
        console.error('Error fetching messages:', error);
      });
}

