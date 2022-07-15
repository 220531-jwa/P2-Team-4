// LOCAL HOST
let baseUrl = "http://localhost:8030";

// ADD EVENT LISTENER
buyButton.addEventListener('click', () => {

    let buyButton = document.getElementById("buyButton");
    buy();
    buyButton.style.visibility = 'hidden';
    let box = document.getElementById('box');
    box.style.visibility = 'visible';
}, false);

// CUSTOMER LOGIN
async function customerlogin() {
    console.log("customer login button pressed");
    // let JSVariable = document.getElementById('HTML ID').value;
    let username = document.getElementById('cu').value;
    let pass = document.getElementById('cp').value;

    let customer = {
        // JAVA : JAVASCRIPT
        username: username,
        pass: pass
    }

    let customerJson = JSON.stringify(cUser);

    console.log(customerJson);

    let res = await fetch(
        `${baseUrl}/customerlogin`,
        {
            method: 'POST',
            header: { 'Content-type': 'application/json' },
            body: customerJson
        }
    );

    let resJson = await res.json()

        .then((resp) => {
            console.log(resp);
            if (resp.admin) {
                window.location.assign("adminhomepage.html");
            } else {
                window.location.assign("customerhomepage.html");
            }
        })

        .catch((error) => {
            console.log(error);
        });
}

// ADMIN LOGIN
async function customerlogin() {
    console.log("customer login button pressed");
    // let JSVariable = document.getElementById('HTML ID').value;
    let username = document.getElementById('cu').value;
    let pass = document.getElementById('cp').value;

    let customer = {
        // JAVA : JAVASCRIPT
        username: username,
        pass: pass
    }

    let customerJson = JSON.stringify(cUser);

    console.log(customerJson);

    let res = await fetch(
        `${baseUrl}/customerlogin`,
        {
            method: 'POST',
            header: { 'Content-type': 'application/json' },
            body: customerJson
        }
    );

    let resJson = await res.json()

        .then((resp) => {
            console.log(resp);
            if (resp.admin) {
                window.location.assign("adminhomepage.html");
            } else {
                window.location.assign("customerhomepage.html");
            }
        })

        .catch((error) => {
            console.log(error);
        });
}


// BUY TICKET
async function buy() {
    console.log("Buy button pressed");

    let data = {
        id: 1
    }

    console.log(data);

    let dataJSON = JSON.stringify(data);

    let res = await fetch(
        `${baseUrl}/userlogin`,
        {
            method: 'PUT',
            header: { 'Content-type': 'application/json' },
            body: dataJSON
        }
    );

    let resJson = await res.json()

        .then((resp) => {
            console.log(resp);
        })
        .catch((error) => {
            console.log(error);
        });
}


// UPDATE FLIGHT DESCRIPTION
async function updateFlightDescription() {
    console.log("Updated flight description");
    // let JSVariable = document.getElementById('HTML ID').value;
    let fId = document.getElementById('flightId').value;
    let fDesc = document.getElementById('flightDescription').value;

    let flightData = {
        // JAVA : JAVASCRIPT
        id: fid,
        description: fdescription
    }

    console.log(flightData);

    // JSON STRINGIFY OBJECTS
    let flightJSON = JSON.stringify(flightData);

    // FETCH is asynchronous
    // Fetch returns promises
    let res = await fetch(
        //`${baseUrl}/userlogin/adminupdatedescription`,
        `${baseUrl}/flight_location/${fId}`
        {
            method: 'PUT',
            header: { 'Content-type': 'application/json' },
            body: flightJSON
        }
    );

    let resJson = await res.json()
        .then((resp) => {
            console.log(resp);
            window.location.assign("adminhomepage.html");
        })
        .catch((error) => {
            console.log(error);
        });
}

// ADMIN CAN VIEW ALL TICKETS
async function getAllTickets() {
    console.log("Got ALl Tickets");
    let id = document.getElementById('id').value;
    let customer_id = document.getElementById('customer_id').value;
    let flight_id = document.getElementById('flight_id').value;
    let origin_id = document.getElementById('origin_id').value;
    let destination_id = document.getElementById('destination_id').value;
    let price = document.getElementById('price').value;

    let TicketData = {
        id: id,
        customer_id: customer_id,
        flight_id: flight_id,
        origin_id: origin_id,
        destination_id: destination_id,
        price: price
    }

    console.log(TicketData);

    let ticketJSON = JSON.stringify(TicketData);

    let res = await fetch(
        `${baseUrl}/userlogin/viewalltickets`,
        {
            method: 'PUT',
            header: { 'Content-type': 'application/json' },
            body: flightJSON
        }
    );

    let resJson = await res.json()
        .then((resp) => {
            console.log(resp);
            window.location.assign("adminhomepage.html");
        })
        .catch((error) => {
            console.log(error);
        });
}