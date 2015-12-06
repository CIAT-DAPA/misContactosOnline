/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function buscarNombre (){
    var busqueda = document.getElementById('nombrebuscar').value;
    document.search.action=rutajs+"/buscarContacto?nombrebuscar="+busqueda;
    document.search.submit();       
}
