function calcular(){

    var n1 = formulario.numero1.value;
    var n2 = formulario.numero2.value;
    var n3 = formulario.numero3.value;

var n= [n1,n2,n3];
var nw= [...new Set(n)];
var ns= nw.sort((a,b)=>b-a)

formulario.ph.value = ns[0];
}
function borrar(){
formulario.numero1.value= '';
formulario.numero2.value='';
formulario.numero3.value='';
formulario.ph.value='';


}