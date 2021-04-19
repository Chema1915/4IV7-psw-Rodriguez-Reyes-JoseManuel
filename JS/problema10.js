function calcular(){
    var t= formulario.t.value;
    var s= formulario.s.value;

    if (t<=1 && t>0) {
        var ut= s*0.05; 
        formulario.ph.value = '$'+ ut.toFixed(2);
       
        document.querySelector('#n').textContent = 'Tu utilidad mensual es del 5%';
    }
    else if (t>=2 && t<5){
         var ut= s*0.07; 
        formulario.ph.value = '$'+ut.toFixed(2);
        document.querySelector('#n').textContent = 'Tu utilidad mensual es del 7%'
    } 
    else if (t>=5 && t<10){
        var ut= s*0.15; 
        formulario.ph.value = '$'+ut.toFixed(2);
        document.querySelector('#n').textContent = 'Tu utilidad mensual es del 15%'
    } 
    else if (t>=10){
        var ut= s*0.20; 
        formulario.ph.value = '$'+ut.toFixed(2);
        document.querySelector('#n').textContent = 'Tu utilidad mensual es del 20%'
    }
    else if (t==0){
        
        alert('No se ingreso el tiempo en la empresa');
        
    }
   
   
}
function borrar(){
    document.querySelector('#n').textContent = 'Tu utilidad mensual es de:';
    formulario.s.value='';
    formulario.t.value='';
    formulario.ph.value='';
}