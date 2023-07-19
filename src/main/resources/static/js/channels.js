document.addEventListener('DOMContentLoaded', function () {
  var addChannelButton = document.getElementById('addChannelButton');
  var channelsContainer = document.getElementById('channelsContainer');

  addChannelButton.addEventListener('click', function () {
    var channelName = prompt("Enter channel name:");
    if (channelName) {
      sessionStorage.setItem('newChannelName', channelName); // Store the channel name in session storage
      createChannel(channelName);
    }
  });

  function createChannel(channelName) {
    // Send a request to the backend to create a new channel
    fetch('/channels', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({ channelName: channelName })
    })
      .then(response => response.json())
      .then(channel => {
        // After successfully creating the channel, update the UI
        var channelId = channel.channelId;
        var newChannelElement = document.createElement('div');
        var newChannelLink = document.createElement('a');
        newChannelLink.textContent = channelName;
        newChannelLink.href = '/channels/' + channelId;
        newChannelLink.addEventListener('click', function () {
          sessionStorage.setItem('channelId', channelId);
        });
        newChannelElement.appendChild(newChannelLink);
        channelsContainer.prepend(newChannelElement);
      })
      .catch(error => console.error('Error creating channel:', error));
  }

});
