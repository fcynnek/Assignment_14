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
        fetch(`/channels/${channelId}`)
            .then(response => response.json())
            .then(data => {
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
