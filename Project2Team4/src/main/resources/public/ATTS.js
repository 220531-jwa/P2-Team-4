
let baseUrl = "http://localhost:8080";
//let baseUrl = "ec2-35-173-193-218.compute-1.amazonaws.com:8080";

buyButton.addEventListener('click', () => {

    let buyButton = document.getElementById("buyButton");
    buy();
    buyButton.style.visibility = 'hidden';
    let box = document.getElementById('box');
    box.style.visibility = 'visible';
    },false);



async function login() {
    console.log("login button pressed");

    let cUname = document.getElementById('cUname').value;

    let cPass = document.getElementById('cPass').value;

    let cUser = {
        userUserName : cUname,
        userPassword : cPass
    }

    let customerJson = JSON.stringify(cUser);

    console.log(customerJson);

    let res = await fetch (
                    `${baseUrl}/userlogin`,
                    {
                        method : 'POST',
                        header : {'Content-type': 'application/json'},
                        body : customerJson
                    }
    );

    let resJson = await res.json()

    .then((resp) => {
        console.log(resp);

        if(resp.admin)
        {
            window.location.assign("adminhomepage.html");
        }else {
            window.location.assign("homePage.html");
        }
       
    })
    .catch((error) =>
    {
        console.log(error);
    });
}


//document.getElementById("createRequest").addEventListener("click", () => {}, false);

const welcome = document.getElementById("welcome-message");
const reimbursement = document.getElementById("reimbursement");
const topRow = document.getElementById("table-top-row");
const typeOfEmployee = window.sessionStorage.getItem('type');


async function getTickets(){
        
    let locations = ["Cairo","London","Sydney","Kyoto"];
    let airlines = ["JetBlue","Spirit","Dalta","United","AirFrance","Jet Airways","Air Canada","Qatar Airways","Air China","Korean Air","British Airways","Swiss","AirAlgeria",];

    let searchId = JSON.stringify(window.sessionStorage.getItem('id'));

    let res = await fetch(
        `${baseUrl}/userlogin/tickets`,
        {
            method: 'GET',
            header: {'Content-Type': 'application/json'}, 
        }
    );

    let resJSON = res.json()
    .then((resp) => {
        for(let i = 0; i < resp.length; i++){
            let newRow = document.createElement('tr');

            let col1 = document.createElement('td');
            col1.innerText = resp[i].id;
            newRow.appendChild(col1);
        

            let col2 = document.createElement('td');
            col2.innerText = resp[i].customer_id;
            newRow.appendChild(col2);

            let col3 = document.createElement('td');
            // col2.innerText = resp[i].flight_id;
            col3.textContent = airlines[parseInt(resp[i].flight_id, 10) - 1]
             newRow.appendChild(col3);

            let col4 = document.createElement('td');

            console.log(locations[parseInt(resp[i].destination_id)]);
           // col4.innerText = resp[i].destination_id;
           col4.textContent = locations[parseInt(resp[i].destination_id, 10) - 1]
            newRow.appendChild(col4);

            let col5 = document.createElement('td');
          //  col5.innerText = resp[i].origin_id;
          col5.textContent = locations[parseInt(resp[i].origin_id, 10) - 1]
            newRow.appendChild(col5);

            let col6 = document.createElement('td');
            col6.innerText = resp[i].price;
            newRow.appendChild(col6);

            let col7 = document.createElement('td');
            let buyButton = document.createElement('button');
            buyButton.innerText = "Buy";
            buyButton.classList.add('btn');
            buyButton.classList.add('btn-primary');
            buyButton.addEventListener('click', (event) => 
            {
                buy(event.target.parentElement.parentElement.childNodes[0].innerText, event);
                buyButton.style.visibility = 'hidden';
            },false);
            
            col7.appendChild(buyButton);

            newRow.appendChild(col7);
            

             document.getElementById('requests').appendChild(newRow);
        }
        console.log(resp);
    })
}


async function buy(ticketId, event)
{
    console.log("Buy button pressed");

    let data = {
        id : ticketId
    }

    console.log(data);

    let dataJSON = JSON.stringify(data);

    let res = await fetch (
        `${baseUrl}/userlogin`,
        {
            method : 'PUT',
            header : {'Content-type': 'application/json'},
            body : dataJSON
        }
    );

    let resJson = await res.json()

    .then((resp) => {
        console.log(resp);
        event.target.parentElement.parentElement.childNodes[2].innerText = resp.customer_id;

    })
    .catch((error) =>
    {
        console.log(error);
    });
}

async function updateFlightDescription()
{
    console.log("Updated flight description");

    let fId = document.getElementById('flightId').value;
    let fDesc = document.getElementById('flightDescription').value;

    let flightData = {
        flightId : fId,
        flightDescription : fDesc
    }

    console.log(flightData);

    let flightJSON = JSON.stringify(flightData);

    let res = await fetch (
        `${baseUrl}/userlogin/adminupdatedescription`,
        {
            method : 'PUT',
            header : {'Content-type' : 'application/json'},
            body : flightJSON
        }
    );

    let resJson = await res.json()
    .then((resp) => {
        console.log(resp);
        window.location.assign("adminhomepage.html");
    })
    .catch((error) =>{
        console.log(error);
    });
    
}

async function cancelTicket()
{
    console.log("Ticket cancelled");

    let tId = document.getElementById('ticketId').value;

    let ticket = {
        id : tId
    }

    console.log(ticket);

    let ticketJSON = JSON.stringify(ticket);

    let res = await fetch (
            `${baseUrl}/userlogin/cancelticket`,
            {
                method : 'DELETE',
                header : {'Content-type' : 'application/json'},
                body : ticketJSON
            }
    );
    
    let resJson = await res.json()
    .then((resp) => {
        console.log(resp);
        window.location.assign("homePage.html");
    })
    .catch((error) =>{
        console.log(error);
    });

}


// ==================

async function setDiscountAtFlight()
{
    console.log("Updated price");

    let tId = document.getElementById('tId').value;
    let flightDisc = document.getElementById('newprice').value;

    let flightData = {
        flight_id : tId,
        price : flightDisc
    }

    console.log(flightData);

    let flightJSON = JSON.stringify(flightData);

    let res = await fetch (
       // `${baseUrl}/userlogin/adminupdateprice`,
         `${baseUrl}/userlogin/tickets`,
        {
            method : 'PUT',
            header : {'Content-type' : 'application/json'},
            body : flightJSON
        }
    );

    let resJson = await res.json()
    .then((resp) => {
        console.log(resp);
        window.location.assign("adminhomepage.html");
    })
    .catch((error) =>{
        console.log(error);
    });
    
}
