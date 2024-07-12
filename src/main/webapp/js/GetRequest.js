console.log("Entro a GetRequest");
document.addEventListener("DOMContentLoaded", function() {

  const autoSection = document.getElementById("autos");
  //const autos = [];

  function loadAutoList() {
    console.log("Entro a loadAutoList");
    fetch("/autos-web-final/cars?action=getAll")
      .then(response => response.json())
      .then(data => {
        console.log("data : " + data);
        data.forEach(auto =>{
          //autos.push(auto);
          autoSection.innerHTML += `
            <tr>
              <td>${auto.id}</td>
              <td>${auto.marca}</td>
              <td>${auto.modelo}</td>
              <td>${auto.version}</td>
              <td>${auto.anio}</td>
              <td>${auto.chasis}</td>
              <td>${auto.motor}</td>
              <td>${auto.color}</td>
            </tr>
          `
        });
      });
  }
  loadAutoList();
});
