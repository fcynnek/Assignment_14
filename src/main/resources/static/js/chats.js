document.addEventListener('DOMContentLoaded', function () {
    const sendMessageForm = document.getElementById('sendMessageForm');
    const messageInput = document.getElementById('messageInput');
    const messageContainer = document.getElementById('messageContainer');

    const channelId = sessionStorage.getItem('channelId');

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
      
        const message = {
          content: messageInput.value.trim()
        };
      
        fetch(`/channels/${channelId}`, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
          },
          body: JSON.stringify(message)
        })
          .then(response => {
            if (!response.ok) {
              throw new Error(`Failed to retrieve messages. Status: ${response.status} ${response.statusText}`);
            }
            // Check if the response body is empty
            if (response.status === 204) {
              return []; // Return an empty array
            }
            return response.json(); // Read the response body as JSON
          })
          .then(data => {
            console.log(data); // Log the response body
            messageContainer.innerHTML = '';
            data.forEach(message => {
              displayMessage(message.username, message.content);
            });
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
            content: content
          };
      
          fetch(`/channels/${channelId}/sendMessage`, {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(message)
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
    setInterval(pollMessages, 500);
});
