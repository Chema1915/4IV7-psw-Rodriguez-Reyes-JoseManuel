function problema2(){
    var p2_x1 = document.querySelector('#p2-x1').value;
    var p2_x2 = document.querySelector('#p2-x2').value;
    var p2_x3 = document.querySelector('#p2-x3').value;
    var p2_x4 = document.querySelector('#p2-x4').value;
    var p2_x5 = document.querySelector('#p2-x5').value;


    var p2_y1 = document.querySelector('#p2-y1').value;
    var p2_y2 = document.querySelector('#p2-y2').value;
    var p2_y3 = document.querySelector('#p2-y3').value;
    var p2_y4 = document.querySelector('#p2-y4').value;
    var p2_y5 = document.querySelector('#p2-y5').value;
    
    /* Para encontrar el minimo producto escalar entre dos vectores tenemos que realizar las operaciones correspondientes que son:
    maximo valor de un vector por el minimo valor del otro vector
    */
   var v1=[p2_x1, p2_x2, p2_x3, p2_x4, p2_x5];
   var v2=[p2_y1, p2_y2, p2_y3, p2_y4, p2_y5];
   // ordernar los vectores 
   v1 = v1.sort(function(a,b){
       return b-a;
   });

   v2 = v2.sort(function(a,b){
       return b-a;
   });

   v2 = v2.reverse();

   var p2_producto = 0;

   for(var i= 0; i< v1.length; i++){
       p2_producto += v1[i]*v2[i];

   }

   document.querySelector('#p2-output').textContent = 'Producto escalar minimo: '+p2_producto;
}



function problema1(){
    var p1_input = document.querySelector('#p1-input').value;

    var p1_array = p1_input.split(' ').reverse();
    var p1_res = '';

    p1_array.forEach(function (palabra, i){
        if(i !=0 || i != p1_array.length) p1_res += ' ';
        p1_res += palabra;

    });
    document.querySelector('#p1-output').textContent = p1_res;


}
function problema3(){
    var p3_input = document.querySelector('#p3_input').value;

   
        var p3_array1= p3_input.split(',');
    
    var a = p3_array1[0].split('');
    var b = p3_array1[1].split('');

    

    var array_a = Array.from(new Set(a));
    var array_b = Array.from(new Set(b));
    
    
    if(array_a.length > array_b.length ){
    document.querySelector('#p3-output').textContent = 'La Palabra mas Larga es: '+  p3_array1[0]+ ' con '+ array_a.length  +' letras unicas.'+ array_a
    }
    else if(array_a.length == array_b.length){
        document.querySelector('#p3-output').textContent = 'Las Dos palabras tienen la misma cantidad de letras unicas.'   

    }
    else if(array_a.length < array_b.length){
        document.querySelector('#p3-output').textContent = 'La Palabra mas Larga es: '+  p3_array1[1]+ ' con '+ array_b.length +' letras unicas.'+ array_b
    }
    
     


    }

