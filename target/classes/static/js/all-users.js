document.addEventListener('DOMContentLoaded', () => {
    let port = location.port;
    let url = 'http://localhost:' + port + '/user-management/users';

    fetch(url, {
        method: 'GET'
    })
    .then(response => response.json())
    .then(body => {
        let usersList = document.getElementById('user-list');
        let users = body.users;

        users.forEach(user => {
            let userContainer = document.createElement('div');
            userContainer.classList.add('user');

            for (const [key, value] of Object.entries(user)) {
                if (key === 'address') {
                    let addressContainer = document.createElement('div');
                    addressContainer.classList.add('address');
                    for (const [addressKey, addressValue] of Object.entries(user[key])) {
                        addressContainer.append(createElementWith(addressValue));
                    }
                    userContainer.append(addressContainer);
                } else {
                    userContainer.append(createElementWith(value));
                }
            }
            userContainer.append(createDeleteButton(user.userId));
            usersList.append(userContainer);
            usersList.append(document.createElement('hr'));
        });
    });

    function createElementWith(value) {
        let element = document.createElement('div');
        element.classList.add('data');
        element.innerText = value;
        return element;
    }

    function createDeleteButton(userId) {
        let buttonContainer = document.createElement('div');
        let button = document.createElement('button');
        button.innerText = 'Delete';

        button.addEventListener('click', e => {
           let deleteUrl = url + '/' + userId;
           fetch(deleteUrl, {
               method: 'DELETE'
           }).then(response => console.log(response));
        });

        buttonContainer.append(button);
        return buttonContainer;
    }
})