document.addEventListener('DOMContentLoaded', function () {
  var addChannelButton = document.getElementById('addChannelButton');
  var channelsContainer = document.getElementById('channelsContainer');
  var channelIdCounter = sessionStorage.getItem('channelIdCounter') || 1;

  addChannelButton.addEventListener('click', function () {
    var channelName = prompt("Enter channel name:");
    if (channelName) {
      createChannel(channelName);
    }
  });

  function createChannel(channelName) {
    var channelId = channelIdCounter++;
    var newChannelElement = document.createElement('div');
    var newChannelLink = document.createElement('a');
    newChannelLink.textContent = channelName;
    newChannelLink.href = '/channels/' + channelId;
    newChannelLink.addEventListener('click', function () {
      sessionStorage.setItem('channelId', channelId);
    });
    newChannelElement.appendChild(newChannelLink);
    channelsContainer.prepend(newChannelElement);
  }

});
