let baseUrl = "http://localhost:8040";

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
            window.location.assign("customerhomepage.html");
        }
       
    })
    .catch((error) =>
    {
        console.log(error);
    });
}

async function buy()
{
    console.log("Buy button pressed");

    let data = {
        id : 1
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
