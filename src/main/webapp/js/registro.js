// Obtención, validación y muestra de datos del registro
const ValidarMostrar = () => {
    const nombre = document.querySelector("#nombre");
    const apellido = document.querySelector("#apellido");
    const mail = document.querySelector("#mail");
    const psw = document.querySelector("#psw");
    const psw2 = document.querySelector("#psw2");
    const fechaNac = document.querySelector("#fechaNac");
    const pais = document.querySelector("#pais");   
    const dni = document.querySelector("#dni");
    const telefono = document.querySelector("#telefono");

    // Validaciones
    if (!validarCampo(nombre)) return;
    if (!validarCampo(apellido)) return;
    if (!validarCampo(mail)) return;
    if (!validarCampo(psw)) return;

    if (psw2.value !== psw.value) {
        alert("La confirmación de contraseña debe ser igual a la contraseña");
        psw2.focus();
        return false;
    }

    if (!validarCampo(fechaNac)) return;

    if (pais.value == 0){
        alert("Debe seleccionar el País");
        pais.focus();
        return false;
    }

    if (!validarCampo(dni)) return;
    if (!validarCampo(telefono)) return;

    // Armo cadena con los datos registrados y los muestro en un Alert
    muestroRegistroConAlert();

    // Blanqueo todos los campos para un próximo ingreso
    blanqueoCampos();

}

const validarCampo = (campo) => {
    if (campo.value == "") {
        alert("Debe completar " + campo.placeholder);
        campo.focus();
        return false;
    }
    return true;
};

const muestroRegistroConAlert = () => {
    let cadena = "";
    cadena += "Nombre: " + nombre.value + "\n";
    cadena += "Apellido: " + apellido.value + "\n";
    cadena += "Email: " + mail.value + "\n";
    cadena += "Contraseña: " + psw.value + "\n";
    cadena += "Confirmación de Contraseña: " + psw2.value + "\n";
    // Formateo la fecha a dd/mm/yyyy
    const resFecha = fechaNac.value.split("-").reverse().join("/");
    cadena += "Fecha Nacimiento: " + resFecha + "\n";
    // Tomo el value y el texto del país elegido
    cadena += "País: " + pais.value + " - " + pais.options[pais.selectedIndex].text + "\n";
    cadena += "DNI: " + dni.value + "\n";
    cadena += "Teléfono: " + telefono.value + "\n";
    cadena += "Acepta términos y condiciones: " + (document.querySelector("#check").checked ? "SI" : "NO") + "\n";
    alert(" --- DATOS REGISTRADOS --- \n" + cadena);
};

const blanqueoCampos = () =>{
    nombre.value = "";
    apellido.value = "";
    mail.value = "";
    psw.value = "";
    psw2.value = "";
    fechaNac.value = "";
    pais.selectedIndex = 0;
    dni.value = "";
    telefono.value = "";
};
