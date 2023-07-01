document.addEventListener('DOMContentLoaded', function () {
  function createChannel(event) {
    event.preventDefault();
    var channelName = prompt("Enter channel name: ");
    if (channelName) {
      var form = document.createElement('form');
      form.method = 'POST';
      form.action = '/createChannel';

      var input = document.createElement('input');
      input.type = 'hidden';
      input.name = 'channelName';
      input.value = channelName;

      form.appendChild(input);
      document.body.appendChild(form);
      form.submit();
    }
  }

  var createChannelButton = document.getElementById('createChannel');
  if (createChannelButton) {
    createChannelButton.addEventListener('click', createChannel);
  }

  var noChannelsForm = document.getElementById('noChannelsForm');
  if (noChannelsForm) {
    noChannelsForm.addEventListener('submit', function (event) {
      createChannel(event); // Call the createChannel function
    });
  }
});
