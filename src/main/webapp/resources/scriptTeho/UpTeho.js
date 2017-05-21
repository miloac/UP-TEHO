/**
 * 
 * @author Jefferson David Castañeda Carreño
 */
jQuery(document).ready(function(){
        
    jQuery(".selectButton").click(function(){
        var objectId = jQuery(this).attr("id");
        var rowIndexe = objectId.substr(0,38).substr(37,38);
        var estado = objectId.substr(39,40);
        var newId = objectId.substr(0,39);
        if (estado==="d"){
            jQuery(this).attr("id",newId+"a");
            jQuery(this).css({"background-color":"#A9E2F3","box-shadow":"2px 3px 3px #BDBDBD"});
            forButton(this,"-","des-Seleccionar");
            if (rowIndexe%2===0){
                jQuery(this).parent().parent().parent().removeClass("rowUnSelectedClass1");
            }else{
                jQuery(this).parent().parent().parent().removeClass("rowUnSelectedClass2");
            }
            jQuery(this).parent().parent().parent().addClass("rowSelectedClass");
        }else{
            jQuery(this).attr("id",newId+"d");
            jQuery(this).css({"background-color":"gainsboro","box-shadow":"0px 0px 0px #BDBDBD"});
            forButton(this,"+","Seleccionar");
            jQuery(this).parent().parent().parent().removeClass("rowSelectedClass");
            if (rowIndexe%2===0){
                jQuery(this).parent().parent().parent().addClass("rowUnSelectedClass1");
            }else{
                jQuery(this).parent().parent().parent().addClass("rowUnSelectedClass2");
            }
        }
    });
});

//javascript

/**
 * 
 * @param string string mensaje para mostrar
 * @returns none
 */
function alertaError(string){
    alert(string);
}

function forButton(boton,valor,titulo){
    boton.innerHTML = valor;
    boton.title = titulo;
}

function setOtherSelects(rInd){
    var elements = document.getElementsByTagName("select");
    for (i=0; i<elements.length;i++){
        if(i!=rInd){
            elements[i].selectedIndex="0";
        }
    }
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