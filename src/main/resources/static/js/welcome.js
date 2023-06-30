var messageIcon = document.querySelector('.fa-message-smile')
var submitIcon = document.querySelector('.fa-paper-plane')
var messageInput = document.querySelector('.message-input')
var user = sessionStorage.getItem('user')

if (user === null) {
    alert('Please input a username')
} 

document.getElementById('submit').addEventListener('click', function() {
    var user = document.getElementById('user').value
    if (user === '') {
        alert('Please input a username')
    } else {
        sessionStorage.setItem('user', user)
        window.location.href = '/channels'
    }
})
