let baseUrl = "http://localhost:8080"

let locations = ["Cairo","London","Sydney","Kyoto"];

async function getTickets(){
    console.log("inside function")
    let res = await fetch(
        `${baseUrl}/userlogin/tickets/customer`,
        {
            method: 'GET',
            header: {'Content-type' : 'application/json'}
        }
    )

    let resJson = await res.json()
    .then((resp) => {
        for(let i = 0; i < resp.length; i++){
            let newRow = document.createElement('tr');

            let col1 = document.createElement('td');
            col1.textContent = locations[resp[i].destination_id - 1]

            let col2 = document.createElement('td');
            col2.textContent = locations[resp[i].origin_id - 1]

            let col3 = document.createElement('td');
            let col4 = document.createElement('td');
            let col5 = document.createElement('td');
            getAirline(resp[i].flight_id)
            .then((resp) => {
                resp.json()
                .then((data) => {
                    console.log(data);
                    col3.textContent = data.airline
                    let departingTime = "";
                    let arrivingTime = "";
                    if(data.departing[0] < 10){
                        departingTime = departingTime.concat(`0${data.departing[0]}:`);
                    } else{
                        departingTime = departingTime.concat(`${data.departing[0]}:`);
                    }
                    if(data.departing[1] === "0"){
                        departingTime = departingTime.concat('00')
                    } else if(data.departing[1] < 10){
                        departingTime = departingTime.concat(`0${data.departing[1]}`)
                    } else{
                        departingTime = departingTime.concat(data.departing[1])
                    }

                    if(data.arriving[0] < 10){
                        arrivingTime = arrivingTime.concat(`0${data.arriving[0]}:`);
                    } else{
                        arrivingTime = arrivingTime.concat(`${data.arriving[0]}:`);
                    }
                    if(data.arriving[1] === "0"){
                        arrivingTime = arrivingTime.concat('00')
                    } else if(data.arriving[1] < 10){
                        arrivingTime = arrivingTime.concat(`0${data.arriving[1]}`)
                    } else{
                        arrivingTime = arrivinggTime.concat(data.arriving[1])
                    }
                    col4.textContent = departingTime;
                    col5.textContent = arrivingTime;
                })
            })

            newRow.appendChild(col1);
            newRow.appendChild(col2);
            newRow.appendChild(col3);
            newRow.appendChild(col4);
            newRow.appendChild(col5);

            document.getElementById("requests").appendChild(newRow);
        }
    })
}

async function getAirline(flight_id){
    console.log(flight_id)
    let res = await fetch(
            `${baseUrl}/flight/${flight_id}`,
            {
                method: 'GET',
                header: {'Content-type' : 'application/json'}
            }
    ) 
    
    return res;
}
