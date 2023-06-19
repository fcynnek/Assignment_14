var messageIcon = document.querySelector('.fa-message-smile')
var submitIcon = document.querySelector('.fa-paper-plane')
var messageInput = document.querySelector('.message-input')
var user = sessionStorage.getItem('user')

if (user === null) {
    alert('Please input a username')
} 

document.getElementById('submit').addEventListener('click', function() {
    var username = document.getElementById('username').value
    if (username === '') {
        alert('Please input a username')
    } else {
        sessionStorage.setItem('user', username)
        window.location.href = '/channels'
    }
})
