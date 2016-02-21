<%@ page import="java.io.*, java.net.*" %>
<% 
                try{
                    int character;
                    char charact;
                    String room="";
                    room=request.getParameter("room");
                    String user = request.getParameter("user");
                    Socket socket = new Socket("127.0.0.1", 9999);
                    DataInputStream inSocket = new DataInputStream(socket.getInputStream());
                    DataOutputStream outSocket = new DataOutputStream(socket.getOutputStream());
                    String str ="";
                    String gText ="";
                    str = "Web:createRoom"+":"+user+":"+room;
                    outSocket.writeUTF(str);
                    gText=inSocket.readUTF();
                    String[] receive = gText.split(":");
                    for(int i = 0; i<receive.length;i++){
                        String[] data = receive[i].split("#");
                        out.println("<li id='"+data[0]+"' onclick ='conversation(this.id)'>"+data[1] + "</li>");
                    }
                    
                    socket.close();
                }catch(java.net.ConnectException e){
                    out.println("asda "+e);

                }
        %>
