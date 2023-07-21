// document.addEventListener('DOMContentLoaded', function () {
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

    // fetch(`/channel/${channelId}?message=${message.message}&user=${message.user}`, {
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

  // function pollMessages() {
  //   $('#messageArea').load(window.location.href + ' #messageArea');
  // }
  function pollMessages() {
    fetch(window.location.href)
      .then(response => response.text())
      .then(html => {
        const parser = new DOMParser();
        const doc = parser.parseFromString(html, 'text/html');
        const updatedMessageContainer = doc.getElementById('messageContainer');
        messageContainer.innerHTML = updatedMessageContainer.innerHTML;
      })
      .catch(error => {
        console.error('Error fetching messages:', error);
      });
  }
  

  pollMessages();
  setInterval(pollMessages, 5000);
// });
