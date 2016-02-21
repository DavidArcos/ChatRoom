<%@ page import="java.io.*, java.net.*" %>
<% 
                try{
                    int character;
                    char charact;
                    String user = request.getParameter("user");
                    Socket socket = new Socket("127.0.0.1", 9999);
                    DataInputStream inSocket = new DataInputStream(socket.getInputStream());
                    DataOutputStream outSocket = new DataOutputStream(socket.getOutputStream());
                    String str ="Web:Login:"+user;
                    String gText ="";
                    outSocket.writeUTF(str);
                    gText=inSocket.readUTF();
                    out.println(gText);
                    socket.close();
                }catch(java.net.ConnectException e){
                    out.println("asda "+e);

                }
        %>

                    
                    