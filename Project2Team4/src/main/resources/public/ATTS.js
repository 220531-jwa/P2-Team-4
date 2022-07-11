// URL
let baseUrl = "http://localhost:8030";

// LOGIN
async function login() {
    // LOGIN BUTTON
    console.log("login button pressed");
    // CUSTOMER USERNAME
    let cUname = document.getElementById('cUname').value;
    // CUSTOMER PASSWORD
    let cPass = document.getElementById('cPass').value;

    let cUser = {
        userUserName : cUname,
        userPassword : cPass
    }

    let customerJson = JSON.stringify(cUser);

    console.log(customerJson);

    // FETCH METHOD
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
            // ADMIN HOME PAGE
            window.location.assign("adminhomepage.html");
        }else {
            // CUSTOMER HOME PAGE
            window.location.assign("customerhomepage.html");
        }
    })
    // ERROR
    .catch((error) =>
    {
        console.log(error);
    });
}