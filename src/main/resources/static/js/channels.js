// document.addEventListener('DOMContentLoaded', function() {
//     document.getElementById('createChannel').addEventListener('click', function() {
//         window.location.href = '/createChannel';
//     })
// })

// function createChannel() {
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
        // var xhr = new XMLHttpRequest()
        // xhr.open('POST', '/createChannel', true)
        // xhr.setRequestHeader('Content-Type', 'application/json')
        // xhr.onload = function () {
        //   if (xhr.status === 200) {
        //     var channel = JSON.parse(xhr.responseText)
        //     window.location.href = '/channel/' + channel.channelId
        //   } else {
        //     alert('Failed to create channel. Please try again.')
        //   }
        // }
        // xhr.send(JSON.stringify({ channelName: channelName }))
      }
    })
  })
// }
