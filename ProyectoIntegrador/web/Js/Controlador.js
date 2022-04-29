/* FUNCIONES PAGINA PRINCIPAL */
function cargarPagina(id) {
    if (id === "alumno") {
        $(".div_container").load('Registros/RegistroUsuario.jsp .div_formUser');

    }
    if (id === "docente") {
        $(".div_container").load('Registros/RegistroUsuario.jsp .div_formUser2');
    }

}
var estado = false;
function verMenuRegistro(id) {

    if (estado === false) {
        $(".ul_regMenu").show("fast");
        $("#" + id).addClass('selected');
        estado = true;
    } else if (estado === true) {
        $(".ul_regMenu").hide("fast");
        $(".ul_menu li").removeClass('selected');
        estado = false;
    }
}

function cargarPagModulo() {

    $(".div_container").load('Modulos/modulosPrincipal.jsp');
}



/* FUNCIONES REGISTRO USUARIO*/

/* AJAX ENVIO REGISTRO */


function nuevaUsuario() {
    alert("Envio 1 ");
    alert($("#form_persona").serialize());
    $.ajax({
        type: 'post',
        url: $("#form_persona").attr('action'),
        data: $("#form_persona").serialize(),
        success: function (data) {
            alert("Envio");

        }
    });
}

/* AJAX INICIO SESION */

function inicioSesion(PERS_USERNAME, PERS_PASSWORD, modulo) {



    $.post("ControladorPrincipal", {PERS_USERNAME: PERS_USERNAME, PERS_PASSWORD: PERS_PASSWORD, modulo: modulo}, function (data) {

        var d = parseInt(data);

        if (d === 1) {
            window.location.replace("Principal.jsp");
        } else {

            alert("Usuario o Contraseña Incorrecta")
        }

    });
}
