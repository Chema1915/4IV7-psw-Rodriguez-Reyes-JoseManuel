
function calcular() {
    var fechas= formulario.Fecha.value;
    var fechass= fechas.split('-');
     var edad = 2021-fechass[0];
    document.formulario.ph.value= edad+' años';
}
function borrar(){

    formulario.Fecha.value = '';
    formulario.ph.value ='';
}