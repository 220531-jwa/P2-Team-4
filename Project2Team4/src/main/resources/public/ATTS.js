let baseUrl = "http://localhost:8072";

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




// ========== khellil code

document.getElementById("createRequest").addEventListener("click", () => {}, false);

const welcome = document.getElementById("welcome-message");
const reimbursement = document.getElementById("reimbursement");
const topRow = document.getElementById("table-top-row");
const typeOfEmployee = window.sessionStorage.getItem('type');

async function getTickets(){
        
 
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
            col2.innerText = resp[i].flight_id;
            newRow.appendChild(col2);

            let col3 = document.createElement('td');
            col3.innerText = resp[i].customer_id;
            newRow.appendChild(col3);

            let col4 = document.createElement('td');
           // col4.innerText = resp[i].destination_id;
           col4.innertext = getLocation(parseInt(resp[i].destination_id, 10))

            newRow.appendChild(col4);

            let col5 = document.createElement('td');
          //  col5.innerText = resp[i].origin_id;
          col5.innertext = getLocation(parseInt(resp[i].origin_id, 10))

            newRow.appendChild(col5);

            let col6 = document.createElement('td');
            col6.innerText = resp[i].price;
            newRow.appendChild(col6);

          
             document.getElementById('requests').appendChild(newRow);
        }
        console.log(resp);
    })
}

// ========== Done

let locations = ["Cairo","London","Sydney","Kyoto"]

 function getLocation(id){


return locations[id - 1]

 }

// col4.innertext = getLocation(resp[I].destination_id)
// getLocation(parseInt(resp[I].destination_id, 10))

