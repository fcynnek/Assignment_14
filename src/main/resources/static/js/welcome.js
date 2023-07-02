var messageIcon = document.querySelector('.fa-message-smile')
var submitIcon = document.querySelector('.fa-paper-plane')
var messageInput = document.querySelector('.message-input')
var username = sessionStorage.getItem('username')

if (username === null) {
    alert('Please input a username')
} 

document.getElementById('submit').addEventListener('click', function() {
    var username = document.getElementById('username').value
    if (username === '') {
        alert('Please input a username')
    } else {
        sessionStorage.setItem('username', username)
        window.location.href = '/channels'
    }
})
