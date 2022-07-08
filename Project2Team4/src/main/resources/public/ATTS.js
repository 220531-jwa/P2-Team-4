let baseUrl = "http://localhost:8010";

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
        window.location.assign("customerhomepage.html");
    })
    .catch((error) =>
    {
        console.log(error);
    });
}

async function adminlogin()
{
    console.log("admin login button pressed");

    let aUname = document.getElementById('aUname').value;

    let aPass = document.getElementById('aPass').value;

    let admin = {
        userUserName : aUname,
        userPassword : aPass
    }

    let adminJson = JSON.stringify(admin);

    console.log(adminJson);

    let res = await fetch
                    (
                    `${baseUrl}/adminlogin`,
                    {
                        method : 'POST',
                        header : {'Content-Type' : 'application/json'},
                        body : adminJson
                    });
    let resJson = await res.json()
    .then((resp) => {
        window.location.assign("adminhomepage.html");
    })
    .catch((error) => 
    {
        console.log(error);
    });
}