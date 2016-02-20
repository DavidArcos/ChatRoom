function send_message() {
    var valor = document.getElementById("message-to-send").value;

    var user = document.getElementById("user").value;
    var xmlhttp=new XMLHttpRequest();
                
    xmlhttp.onreadystatechange=function(){
      if(xmlhttp.status==404){
          document.getElementById("messages").innerHTML="Page not found";
      }
      if (xmlhttp.readyState==4 && xmlhttp.status==200){
          document.getElementById("messages").innerHTML=xmlhttp.responseText;
      }
    };
    xmlhttp.open("GET","ajax.jsp?value="+valor+"&user="+user,true);
    xmlhttp.send();

}
            
function refreshType (campo) {
    var valor = "refresh";
    var xmlhttp=new XMLHttpRequest();
    var user = document.getElementById("user").value;            
    xmlhttp.onreadystatechange=function(){
      if(xmlhttp.status==404){

          document.getElementById(campo).innerHTML="Page not found";
      }
      if (xmlhttp.readyState==4 && xmlhttp.status==200){
          document.getElementById(campo).innerHTML=xmlhttp.responseText;
      }
    };
    xmlhttp.open("GET","ajax.jsp?value="+valor+"&user="+user+"&type="+campo,true);
    xmlhttp.send();
}

function refresh () {
  var mensajes = "messages"
  refreshType(mensajes);
  var salas = "salas";
  refreshType(salas);
  var usuarios = "usuarios"
  refreshType(usuarios);
}

function createRoom () {
    var room = prompt("Nombre de la sala");
    var user = document.getElementById("user").value;
    var xmlhttp=new XMLHttpRequest();
                
    xmlhttp.onreadystatechange=function(){
      if(xmlhttp.status==404){
          document.getElementById("salas").innerHTML="Page not found";
      }
      if (xmlhttp.readyState==4 && xmlhttp.status==200){
          document.getElementById("salas").innerHTML=xmlhttp.responseText;
      }
    };
    xmlhttp.open("GET","createRoom.jsp?room="+room+"&user="+user,true);
    xmlhttp.send();



}