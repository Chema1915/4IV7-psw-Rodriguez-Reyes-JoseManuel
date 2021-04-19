
function calcular(){

    
    var parcial1= document.formulario.primer.value;
    var p1 = parseFloat(parcial1);
    var parcial2= document.formulario.segundo.value;
    var p2 = parseFloat(parcial2);
    var parcial3 = document.formulario.tercer.value;
    var p3 =parseFloat(parcial3);
    var parciales = ((p1+p2+p3)*5.5)/30
    var examenf= document.formulario.examen.value;
    var ex= parseFloat(examenf);
    var tr= document.formulario.trabajo.value;
    var t= parseFloat(tr);
    var examenes= (ex*3.0)/10
    var trabajos= (tr*1.5)/10
    var calificacion= parciales+examenes+trabajos;



   

    document.formulario.cal.value=calificacion;
}

function borrar(){

    document.formulario.primer.value="";
    document.formulario.segundo.value="";
    document.formulario.tercer.value="";
    document.formulario.examen.value="";
    document.formulario.trabajo.value="";
    document.formulario.cal.value="";
}