
document.addEventListener('DOMContentLoaded', function () {
  document.getElementById('createChannel').addEventListener('click', function (event) {
    event.preventDefault()
    var channelName = prompt("Enter channel name: ")
    if (channelName) {
      var form = document.createElement('form')
      form.method = 'POST'
      form.action = '/createChannel'

      var input = document.createElement('input')
      input.type = 'hidden'
      input.name = 'channelName'
      input.value = channelName

      form.appendChild(input)
      document.body.appendChild(form)
      form.submit()

    }
  })
})

function updateChannelsList(channel) {
  var channelsContainer = document.getElementById('channelsContainer')
  var link = document.createElement('a')
  link.href = '/channel/' + channel.channelId
  link.innerText = channel.channelName
  channelsContainer.appendChild(link)

}


// function createChannel() {
//   document.addEventListener('DOMContentLoaded', function () {
//     document.getElementById('createChannel').addEventListener('click', function (event) {
//       event.preventDefault()
//       var channelName = prompt("Enter channel name: ")
//       if (channelName) {
//         var xhr = new XMLHttpRequest()
//         xhr.open('POST', '/createChannel', true)
//         xhr.setRequestHeader('Content-Type', 'application/json')
//         xhr.onload = function () {
//           if (xhr.status === 200) {
//             var channel = JSON.parse(xhr.responseText)
//             updateChannelsList(channel)
//           } else {
//             alert('Failed to create channel. Please try again.')
//           }
//         }
//         xhr.send(JSON.stringify({ channelName: channelName }))
//       }
//     })
//   })
// }
