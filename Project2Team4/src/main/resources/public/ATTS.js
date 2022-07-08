let baseUrl = "http://localhost:8040";

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
