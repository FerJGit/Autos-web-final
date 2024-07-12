var numberOfItemsToShow = 9;

// obtener datos de la API y mostrarlos
function fetchAPIData() {
    let script = document.createElement('script');
    script.src = 'https://www.carqueryapi.com/api/0.3/?callback=displayData&cmd=getMakes&sold_in_us=1';
    document.body.appendChild(script);
}

// datos obtenidos de la API
function displayData(data) {
    var apiDataContainer = document.getElementById('api-data');
    apiDataContainer.innerHTML = '';

    data.Makes.slice(0, numberOfItemsToShow).forEach(make => {
        let itemElement = document.createElement('div');
        itemElement.className = 'api-item';
        itemElement.innerHTML = `
            <h4>${make.make_display}</h4>
            <p>País : ${make.make_country}</p>
            <br>
        `;
        apiDataContainer.appendChild(itemElement);
    });
}
document.addEventListener('DOMContentLoaded', fetchAPIData);

// Setea la cantidad de items a mostrar de la API
const setQItems = () => {
    numberOfItemsToShow = document.getElementById("api_citems").value;
    fetchAPIData();
}

