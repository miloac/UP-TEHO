/**
 * 
 * @author Jefferson David Castañeda Carreño
 */
jQuery(document).ready(function(){
        
    jQuery(".selectButton").click(function(){
        var object = jQuery(this).attr("id");
        var subsub = object.substr(0,27).substr(26,27);
        var sub = object.substr(28,29);
        if (sub==="d"){
            if (subsub%2===0){
                jQuery(this).parent().parent().parent().removeClass("rowSelectedClass1");
                jQuery(this).parent().parent().parent().addClass("rowUnSelectedClass1");
            }else{
                jQuery(this).parent().parent().parent().removeClass("rowSelectedClass2");
                jQuery(this).parent().parent().parent().addClass("rowUnSelectedClass2");
            }
        }else{
            if (subsub%2===0){
                jQuery(this).parent().parent().parent().removeClass("rowUnSelectedClass1");
                jQuery(this).parent().parent().parent().addClass("rowSelectedClass1");
            }else{
                jQuery(this).parent().parent().parent().removeClass("rowUnSelectedClass2");
                jQuery(this).parent().parent().parent().addClass("rowSelectedClass2");
            }
        }
    });
});

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

function clickedOff(rowIndex){
    var p2 = "tabla_registro:checkboxDT:"+rowIndex+":a";
    var obj = parent.document.getElementById(p2);
    obj.click();
}

function verifyThis(obj){
    var id = obj.id;
    var sub = id.substr(0,28);
    var subs = id.substr(28,29);
    if (subs==="d" ){
        obj.id =sub+"a";
        obj.style.backgroundColor = "skyblue";
        obj.style.boxShadow = "0px 0px 15px skyblue";
        }
    else{
        obj.id =sub+"d";
        obj.style.textShadow="0px 2px 2px white";
        obj.style.backgroundColor= "gainsboro";
        obj.style.boxShadow = "0px 0px 0px black";
    }
    cargar();  
}

function cargar(){
    var lf = document.getElementById("lightframe");
    lf.style.visibility="visible";
    lf.style.zIndex = "1";
    document.getElementById("anim_load").style.visibility= "visible";
    document.getElementById("anim_load").style.zIndex = "1";
}

function ocultar(){

    var lf = document.getElementById("lightframe");
    lf.style.visibility="hidden";
    lf.style.zIndex = "-1";
    document.getElementById("anim_load").style.visibility= "hidden";
    document.getElementById("anim_load").style.zIndex = "-1";
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