<%@ page import="java.io.*, java.net.*" %>
<% 
                try{
                    int character;
                    char charact;
                    String texto="";
                    texto=request.getParameter("value");
                    String user = request.getParameter("user");
                    String type = request.getParameter("type");
                    String room = request.getParameter("room");
                    Socket socket = new Socket("127.0.0.1", 9999);
                    DataInputStream inSocket = new DataInputStream(socket.getInputStream());
                    DataOutputStream outSocket = new DataOutputStream(socket.getOutputStream());
                    String str ="";
                    String gText ="";
                    if(texto.compareTo("refresh") == 0){
                        str = "Web:"+texto+":"+type+":"+room;
                    }
                    else{
                        str="Web:Msg"+":"+user+":"+texto+":"+room;
                    }
                    outSocket.writeUTF(str);
                    gText=inSocket.readUTF();
                    String[] receive = gText.split(":");
                    if(type.compareTo("salas") == 0){
                        for(int i = 0; i<receive.length;i++){
                            String[] data = receive[i].split("#");
                            out.println("<li id='"+data[0]+"' onclick ='conversation(this.id)'>"+data[1] + "</li>");
                        }
                    }
                    else{
                        for(int i = 0; i<receive.length;i++){
                            out.println("<li>"+receive[i] + "</li>");
                        }
                    }
                    
                    //out.println(gText);
                    socket.close();
                }catch(java.net.ConnectException e){
                    out.println("asda "+e);

                }
        %>

        