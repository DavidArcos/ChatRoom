<%@ page import="java.io.*, java.net.*" %>
<% 
                try{
                    int character;
                    char charact;
                    String room="";
                    room=request.getParameter("room");
                    String user = request.getParameter("user");
                    Socket socket = new Socket("ARCOS-PC", 9999);
                    DataInputStream inSocket = new DataInputStream(socket.getInputStream());
                    DataOutputStream outSocket = new DataOutputStream(socket.getOutputStream());
                    String str ="";
                    String gText ="";
                    str = "Web:createRoom"+":"+user+":"+room;
                    outSocket.writeUTF(str);
                    gText=inSocket.readUTF();
                    String[] receive = gText.split(":");
                    for(int i = 0; i<receive.length;i++){
                        out.println("<li>"+receive[i] + "</li>");
                    }
                    
                    socket.close();
                }catch(java.net.ConnectException e){
                    out.println("asda "+e);

                }
        %>
