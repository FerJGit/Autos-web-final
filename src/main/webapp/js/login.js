const validarLogin = () => {
    let user = document.querySelector("#login-inputUser");
    let pass = document.querySelector("#login-inputPass");
    if (user.value === "codo" && pass.value === "g15codo") {
        alert(`Bienvenido usuario ${user.value} !!`);
        location.href = "../index.html";
    }else{
        alert("Usuario no autorizado");
        user.value = "";
        pass.value = "";
    }
};
