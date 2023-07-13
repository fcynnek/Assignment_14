document.addEventListener('DOMContentLoaded', function () {
  const sendMessageForm = document.getElementById('sendMessageForm');
  const messageInput = document.getElementById('messageInput');
  const messageContainer = document.getElementById('messageArea');
  const channelId = document.getElementById('channelId').value;

  function sendMessage() {
    const message = {
      channelId: channelId,
      message: messageInput.value,
      user: sessionStorage.getItem('username')
    };
    messageInput.value = '';

    fetch(`/channel/${channelId}`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(message)
    })
      .then(response => response.json())
      .then(data => {
        console.log(data);
      })
      .catch(error => {
        console.error(error);
      });
  }

  if (sendMessageForm) {
    sendMessageForm.addEventListener('submit', function (event) {
      event.preventDefault();
      sendMessage();
    });
  }

  function pollMessages() {
    $('#messageArea').load(window.location.href + ' #messageArea');
  }

  pollMessages();
  setInterval(pollMessages, 5000);
});
