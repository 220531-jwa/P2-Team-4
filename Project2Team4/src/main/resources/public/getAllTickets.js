let baseUrl = "http://localhost:8080";

//async function selectAllTickets() {


    document.getElementById("createRequest").addEventListener("click", () => {}
    , false);

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
                col4.innerText = resp[i].destination_id;
                newRow.appendChild(col4);

                let col5 = document.createElement('td');
                col5.innerText = resp[i].origin_id;
                newRow.appendChild(col5);

                let col6 = document.createElement('td');
                col6.innerText = resp[i].price;
                newRow.appendChild(col6);

                 document.getElementById('requests').appendChild(newRow);
            }
            console.log(resp);
        })
    }