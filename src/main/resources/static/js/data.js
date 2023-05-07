let data = [{ id: "1", year: "1751", country: "UNITED KINGDOM", total: "1", solidFuel: "1751", liquidFuel: "2552", gasFuel: "2552", cement: "0", gasFlaring: "0", perCapita: "0", bunkerfuels: "0" }];



// Define a function to display user data in a table
function displayData() {
    let tableData = document.getElementById("emissionsTableContent");
    tableData.innerHTML = "";
    for (let i = 0; i < data.length; i++) {
        let row = `<tr>
                <td>${data[i].year}</td>
                <td>${data[i].country}</td>
                <td>${data[i].total}</td>
                <td>${data[i].solidFuel}</td>
                <td>${data[i].liquidFuel}</td>
                <td>${data[i].gasFuel}</td>
                <td>${data[i].cement}</td>
                <td>${data[i].gasFlaring}</td>
                <td>${data[i].perCapita}</td>
                <td>${data[i].bunkerfuels}</td>
              </tr>`;
        tableData.innerHTML += row;
    }
}


displayData();