
function calcular(){

    
    var comision= document.formulario.ventas.value;
    var r = parseInt(comision);
    var sueldo = document.formulario.cantidad.value;
    var s= parseFloat(sueldo);
    var comt= r*0.10
    
    var total = s + comt;

    document.formulario.sueldoti.value="$"+total;
}

function borrar(){

    document.formulario.cantidad.value="";
    document.formulario.sueldoti.value="";
    document.formulario.ventas.value="";
}