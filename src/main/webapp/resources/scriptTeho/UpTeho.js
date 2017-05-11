/**
 * 
 * @author Jefferson David Castañeda Carreño
 */

//javascript
/**
 * 
 * @param {type} obj
 * @returns {undefined}
 */

/**
 * 
 * @param {type} string mensaje para mostrar
 * @returns none
 */
function alertaError(string){
    alert(string);
}

function verifyThisButton(obj){
    var id = obj.id;
    var subs = id.substr(id.length-1, id.length);
    if (subs=="d" ){
        obj.id = "a";
        obj.style.backgroundColor = "skyblue";
        obj.style.boxShadow = "0px 0px 15px skyblue";
        }
    else{
        obj.id = "d";
        obj.style.textShadow="0px 2px 2px white";
        obj.style.backgroundColor= "gainsboro";
        obj.style.boxShadow = "0px 0px 0px black";
    }
    cargar();
    
}

function changeColor(ob){
    ob.style.color="red";
}

function habilitar(ob){
    ob.disabled=false;
}

function inhabilitar(ob){
    ob.disabled=true;
}

function cargar(){
    var lf = document.getElementById("lightframe");
    lf.style.visibility="visible";
    lf.style.zIndex = "1";
    document.getElementById("loading").style.visibility= "visible";
    document.getElementById("loading").style.zIndex = "1";
}

function ocultar(){
    var lf = document.getElementById("lightframe");
    lf.style.visibility="hidden";
    lf.style.zIndex = "-1";
    document.getElementById("loading").style.visibility= "hidden";
    document.getElementById("loading").style.zIndex = "-1";
}

function mostrarIframe(but, obj){
   var lf = document.getElementById("lightframe");
   var butt = document.getElementById(but);
   var objeto =  document.getElementById(obj);
   lf.style.visibility="visible";
   lf.style.zIndex = "1";
   butt.style.visibility="visible";
   butt.style.zIndex = "1";
   objeto.style.visibility="visible";
   objeto.style.zIndex = "1";
    
}

function cerrarIframe(obj,but){
   var lf = document.getElementById("lightframe");
   var butt = document.getElementById(but);
   var objeto =  document.getElementById(obj);
   lf.style.visibility="hidden";
   lf.style.zIndex = "-1";
   objeto.style.visibility="hidden";
   objeto.style.zIndex = "-1";
   butt.style.visibility="hidden";
   butt.style.zIndex = "-1";
}
