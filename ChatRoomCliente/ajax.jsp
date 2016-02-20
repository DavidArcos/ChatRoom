<%@ page import="java.io.*, java.net.*" %>
<% 
                try{
                    int character;
                    char charact;
                    String texto="";
                    texto=request.getParameter("value");
                    String user = request.getParameter("user");
                    String type = request.getParameter("type");
                    Socket socket = new Socket("ARCOS-PC", 9999);
                    DataInputStream inSocket = new DataInputStream(socket.getInputStream());
                    DataOutputStream outSocket = new DataOutputStream(socket.getOutputStream());
                    String str ="";
                    String gText ="";
                    if(texto.compareTo("refresh") == 0){
                        str = "Web:"+texto+":"+type;
                    }
                    else{
                        str="Web:Msg"+":"+user+":"+texto;
                    }
                    outSocket.writeUTF(str);
                    gText=inSocket.readUTF();
                    String[] receive = gText.split(":");
                    for(int i = 0; i<receive.length;i++){
                        out.println("<li>"+receive[i] + "</li>");
                    }
                    //out.println(gText);
                    socket.close();
                }catch(java.net.ConnectException e){
                    out.println("asda "+e);

                }
        %>

        