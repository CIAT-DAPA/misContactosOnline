/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function pillaCorreos (){
    var correo1 = "";
    var correo2 = "";
    correo1 = document.getElementById('correo1').value;
    correo2 = document.getElementById('correo2').value;
    //var correos = [correo1, correo2];

    //alert(corrreo1);
    document.crearcon.action=rutajs+"/crearcon?correo1="+correo1+"&correo2"+correo2;
    document.crearcon.submit();       
}
