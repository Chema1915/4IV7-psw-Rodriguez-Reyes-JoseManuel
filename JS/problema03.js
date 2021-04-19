function calcular(){

    

    var precio = document.formulario.precio.value;
    var p= parseFloat(precio);
    var pf= p*0.85
    
    var total = pf 

    document.formulario.sueldoti.value="$"+total;
}

function borrar(){

    document.formulario.precio.value="";
    document.formulario.sueldoti.value="";
}