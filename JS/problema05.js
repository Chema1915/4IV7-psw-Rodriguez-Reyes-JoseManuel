
function calcular(){

    
    var estudiante= formulario.estudiantes.value;
    var es= parseInt(estudiante);
    var hom= formulario.hombre.value;
    var h=parseInt(hom);
    var muj= formulario.mujer.value;
    var m=parseInt(muj);
    var porcentajeh =(h*100)/es
    var porcentajem=(m*100)/es
    document.formulario.ph.value=porcentajeh +"%"
    document.formulario.pm.value=porcentajem +"%"


   

   
}

function borrar(){

    document.formulario.estudiantes.value="";
    document.formulario.hombre.value="";
    document.formulario.mujer.value="";
    document.formulario.pm.value="";
    document.formulario.ph.value="";

}