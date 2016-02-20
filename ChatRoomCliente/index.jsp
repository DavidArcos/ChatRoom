<%-- 
    Document   : start
    Created on : 25-ene-2012, 13:31:18
    Author     : jclopezpimentel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN</title>
    
    
    <link rel="stylesheet" href="css/reset.css">

    <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

        <link rel="stylesheet" href="css/style.css">
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="js/index.js"></script>
    </head>

    <body>
<div class="pen-title">
  <h1><b>ChatRoom Login</b></h1>
</div>
<div class="container">
  <div class="card">
  </div>
  <div class="card">
    <h1 class="title">Login</h1>
    <form name="input" action="forma.jsp" method="POST" onsubmit="return validateLogin()">
      <div class="input-container">
        <input type="text" id="Username" name="Username" required="required"/>
        <label for="Username">Username</label>
        <div class="bar"></div>
      </div>
      <div class="button-container">
        <button type="submit" ><span>Login</span></button>
      </div>
    </form>
  </div>
  
</div>
    

    
    
    
  </body>

</html>
