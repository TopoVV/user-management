document.addEventListener('DOMContentLoaded', () => {
    let form = document.forms['create-user-form'];
    form.addEventListener('submit', e => {
        e.preventDefault();
        let formData = new FormData(form);


        let request = {
            birthDate: {},
            address: {}
        }
        formData.forEach((value, key) => {
            if (key.includes('birth')) {
                request.birthDate[key] = value;
            } else if (key === 'country' || key === 'city' || key === 'street' || key === 'houseNo') {
                request.address[key] = value;
            } else {
                request[key] = value
            }
        });

        console.log(request);
        fetch(form.action, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(request)
        }).then(response => {
            console.log(response);
        });
    })
})