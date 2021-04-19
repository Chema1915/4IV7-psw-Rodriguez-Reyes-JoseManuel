function calcular(){

    var pago = formulario.phrs.value;
    var hrsTra =formulario.hrs.value;
    var hrsExtra = hrsTra - 40;
    
    if(hrsTra<=40) formulario.ph.value = pago*hrsTra;    
   
    else if(hrsTra>=41){
        if(hrsTra<=48){
             pagoe = (pago*hrsExtra)*2;
             var pagof = (pago*40) + pagoe;
                formulario.ph.value = pagof;
                
        }

        else if (hrsTra>=49){ //99
            var hrsa3= hrsTra - 48; // 99-48=51
            var hrsExtra = hrsTra - 40-hrsa3; // 
            
        
            pagoe = (pago*8*2); //1*8*2=16
            pagoe2 = (pago*hrsa3)*3; // 1*1*3=3
            
             var pagof = (pago*40) + pagoe + pagoe2; // (1*40)+16+3
                formulario.ph.value = '$'+ pagof ;
    
        }
    }
}
    
    



function borrar(){

    formulario.phrs.value="";
    formulario.hrs.value="";
    formulario.ph.value="";

}