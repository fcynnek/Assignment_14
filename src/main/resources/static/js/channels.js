// document.addEventListener('DOMContentLoaded', function() {
//     document.getElementById('createChannel').addEventListener('click', function() {
//         window.location.href = '/createChannel';
//     })
// })

// function createChannel() {
//     document.getElementById('createChannel').addEventListener('click', function() {
//         var channelName = prompt("Enter channel name: ")
//         if (channelName) {
//             var channel = {channelName: channelName}
//         }
//     })
// }

document.addEventListener('DOMContentLoaded', function() {
    var createChannelButton = document.getElementById('createChannel')
    createChannelButton.addEventListener('click', function(event) {
      event.preventDefault()
      var channelName = prompt('Enter the channel name:')
      if (channelName) {
        var channel = { channelName: channelName }
        console.log(channel)
      }
    })
  })
  