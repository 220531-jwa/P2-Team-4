let baseUrl = "http://localhost:8080";

let d = document;

async function submit(){
    let flight = {
        id : -1,
        airline : d.getElementById("airline").value,
        arriving : d.getElementById("arriving").value,
        departing : d.getElementById("departing").value
    }

    let flightJson = JSON.stringify(flight);

    let res =  await fetch(
        `${baseUrl}/flight`,
        {
            method: 'POST',
            header: {'Content-Type': 'application/json'},
            body: flightJson
        }
    );

    let resJson = res.json()
    .then(resp => {
        console.log(res);
        window.location.assign('adminhomepage.html');
    })
    .catch(err => {
        console.log(err);
    })
}