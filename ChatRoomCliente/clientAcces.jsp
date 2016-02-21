<%-- 
    Document   : clientAcces
    Created on : 17-ene-2012, 0:22:20
    Author     : jclopezpimentel
--%>

<%@ page import="java.io.*, java.net.*" %>
<HTML>
    <HEAD>
        <TITLE>Creating Client/Server Applications</TITLE>
        <script>
            function send_message() {
                /*var valor = document.getElementById("mensaje").value;
                var xmlhttp=new XMLHttpRequest();
                            
                xmlhttp.onreadystatechange=function(){
                  if(xmlhttp.status==404){
                      document.getElementById("text").value="Page not found";
                  }
                  if (xmlhttp.readyState==4 && xmlhttp.status==200){
                      document.getElementById("text").value=xmlhttp.responseText;
                  }
                };
                xmlhttp.open("GET","ajax.jsp?value="+valor,true);
                xmlhttp.send();*/
                alert("asdasd");
            }
        </script>
    </HEAD>

    <BODY>
        <H1>Creating Client/Server Applications</H1>
        <%  String texto, gText="";
            if(request.getParameter("userN")==null){
                session.setAttribute("suserN", session.getAttribute("suserN"));
            }else{
            
                String userN= request.getParameter("userN");
                session.setAttribute("suserN", userN);
            }
            
            if(request.getParameter("text")== null){
                session.setAttribute("textA", "");
        %>
            <%@ include file="forma.jsp" %>
        <%    }else{
                try{
                    int character;
                    char charact;
                    //session.setAttribute("suserN", session.getAttribute("suserN"));
                    texto=request.getParameter("text");
                    Socket socket = new Socket("172.16.34.47", 8766);

                    InputStream inSocket = socket.getInputStream();
                    OutputStream outSocket = socket.getOutputStream();
                    
                    String str = session.getAttribute("suserN") + ":" + texto + "\n";
                    byte buffer[] = str.getBytes();
                    outSocket.write(buffer);

                    while ((character = inSocket.read()) != -1) {
                        charact = (char) character;
                        gText=gText + String.valueOf(charact);                        
                    }
                    session.setAttribute("textA",gText);
        %>
                    <%@ include file="forma.jsp" %>
        <%        

                    socket.close();
                }catch(java.net.ConnectException e){
        %>
		
            You must first start the server application 
            (ServerSockWhile.java) at the command prompt.
        <%
                }
            }
        %>
    </BODY>
</HTML>