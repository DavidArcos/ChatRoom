$('.toggle').on('click', function() {
  $('.container').stop().addClass('active');
});

$('.close').on('click', function() {
  $('.container').stop().removeClass('active');
});



function validateLogin () {
    var user = document.getElementById("Username").value;
    var xmlhttp=new XMLHttpRequest();
                
    xmlhttp.onreadystatechange=function(){
      if(xmlhttp.status==404){
      		return false;
      }
      if (xmlhttp.readyState==4 && xmlhttp.status==200){
      	  if(xmlhttp.responseText == "accept"){
      	  		return true;
      	  }
      	  else{
      	  	return false;
      	  }
      }
    };
    xmlhttp.open("GET","validateLogin.jsp?user="+user,true);
    xmlhttp.send();
}