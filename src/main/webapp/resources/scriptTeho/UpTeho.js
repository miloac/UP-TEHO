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
    }
    cargar();
    
}

function decore(ob){
    ob.style.textShadow= "0px 0px 16px blue";
    ob.style.textDecoration="underline";
}

function undecore(ob){
    ob.style.textShadow= "0px 0px 5px black";
    ob.style.textDecoration="none";
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
    document.getElementById("loading").style.visibility= "visible";
    document.getElementById("loading").style.zIndex = "1";
}

function ocultar(){
    document.getElementById("loading").style.visibility= "hidden";
    document.getElementById("loading").style.zIndex = "-1";
}