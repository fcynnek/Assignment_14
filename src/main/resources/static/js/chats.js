document.addEventListener('DOMContentLoaded', function () {
  const sendMessageForm = document.getElementById('sendMessageForm');
  const messageInput = document.getElementById('messageInput');
  const messageContainer = document.getElementById('messageContainer');

  const channelId = document.getElementById('channelId').value;

  function displayMessage(username, content) {
    const messageElement = document.createElement('div');
    messageElement.classList.add('message');
    messageElement.textContent = `${username}: ${content}`;

    messageContainer.appendChild(messageElement);
  }

  function pollMessages() {
    if (!channelId) {
      console.error('Invalid channelId');
      return;
    }

    fetch(`/channels/${channelId}`)
      .then(response => {
        if (!response.ok) {
          throw new Error(`Failed to retrieve messages. Status: ${response.status} ${response.statusText}`);
        }
        // Check if the response body is empty
        if (response.status === 204) {
          return []; // Return an empty array
        }
        return response.text(); // Read the response body as HTML
      })
      .then(data => {
        messageContainer.innerHTML = data;
      })
      .catch(error => {
        console.error('An error occurred while retrieving messages', error);
      });
  }

  function sendMessage(event) {
    event.preventDefault();
    const content = messageInput.value.trim();
    
    if (content) {
      const message = {
        message: content
      };
      console.log(typeof message)
      const requestBody = JSON.stringify(message);
      
      fetch(`/channels/${channelId}/sendMessage`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: requestBody
      })
      
        .then(response => {
          if (response.ok) {
            messageInput.value = '';
            pollMessages();
          } else {
            console.error('Failed to send message');
          }
        })
        .catch(error => {
          console.error('An error occurred while sending the message', error);
        });
    }
  }
  
  

  if (sendMessageForm) {
    sendMessageForm.addEventListener('submit', sendMessage);
  }

  pollMessages();
  setInterval(pollMessages, 5000);
});
