
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="java.io.*, java.net.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css1/reset.css">
        <title>JSP Page</title>
    <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>

    <link rel="stylesheet" href="css1/style.css">

    
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<script src='http://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.0/handlebars.min.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/list.js/1.1.1/list.min.js'></script>
<link rel="stylesheet" href="//fonts.googleapis.com/icon?family=Material+Icons">
<link href='http://fonts.googleapis.com/css?family=Roboto:400,300,300italic,500,400italic,700,700italic' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="//storage.googleapis.com/code.getmdl.io/1.0.1/material.teal-red.min.css" />
<script src="//storage.googleapis.com/code.getmdl.io/1.0.1/material.min.js"></script>


        <script src="js1/index.js"></script>
        <script src="js1/chat.js"></script>
    </head>
    <body onload="setInterval('refresh()',2000);" >
<div class = "options">
  <button class="mdl-button mdl-button--raised mdl-button--colored" onclick="createRoom()">Nueva sala</button>
  </div>
</div>
<div class="container clearfix">

        <div class="people-list" id="people-list">
          <div class="room">
            <p>Salas</p>
            <ul class="list" id="salas">
            </ul>
          </div>
          <div class="user">
            <p>Usuarios</p>
            <ul class="list" id="usuarios">
            </ul>
          </div>

        </div>
    
    <div class="chat">
      <div class="chat-header clearfix">
        
        <div class="chat-about">
          <div class="chat-with">HOT LINE</div>
          <div class="chat-num-messages"><%=request.getParameter("Username")%></div>
        </div>
        <i class="fa fa-star"></i>
      </div> <!-- end chat-header -->
      
      <div class="chat-history">
        <ul id = "messages">  
        </ul>
        
      </div> <!-- end chat-history -->
      <input type="hidden" id="user" name="user" value = '<%=request.getParameter("Username")%>'/>
      <div class="chat-message clearfix">
        <textarea name="message-to-send" id="message-to-send" placeholder ="Type your message" rows="3"></textarea>
        <td><button onclick="send_message()">Enviar</button></td>

      </div> <!-- end chat-message -->
      
    </div> <!-- end chat -->
    
  </div>
        
          
      </body>
</html>