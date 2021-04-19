function calcular(){
    var n1 = formulario.p1.value;
    var n2 = formulario.p2.value;

    if(n1 === n2){
        var res=n1*n2;
    }
    else if(n1>n2){
        var res= n1-n2;
    }
    else  if(n1<n2){
        var res= parseFloat(n1) + parseFloat(n2);
    }

    formulario.ph.value = res;

}

function borrar(){
    formulario.ph.value = '';
    formulario.p1.value='';
    formulario.p2.value='';

}