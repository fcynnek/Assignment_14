document.getElementById('submit').addEventListener('click', function () {
    var username = document.getElementById('username').value
    if (username === '') {
        alert('Please input a username')
    } else {
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "/welcome", true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
                sessionStorage.setItem('username', username)
                
            } else {
                alert('Error occurred');
            }
        };
        var data = JSON.stringify({ username: username });
        xhr.send(data);

    }
})
