/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchatroom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arcos
 */
public class ServerChatRoom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String conversation="", instring="";
            String[] cmd = {"createRoom","sendMesagge"};
            ArrayList<Sala> salas = new ArrayList<>();
            LinkedList<Socket> escritorio = new LinkedList<>();
            LinkedList<UserWeb> web = new LinkedList<>();
            ArrayList<String> usuarios = new ArrayList<>();
            ServerSocket server = new ServerSocket(9999);
            while (true){
                        System.out.println("Servidor corriendo...");
                        String[] msg = {};
                        Socket client = server.accept();
                        DataInputStream in = new DataInputStream(client.getInputStream());
                        DataOutputStream out = new DataOutputStream(client.getOutputStream());
                        String received = in.readUTF();
                        msg = received.split(":");
                        if(msg[0].compareTo("Web") == 0){
                            switch(msg[1]){
                                case "Login":
                                    System.out.println("Conexion desde la Web");
                                    boolean exits = false;
                                    for (int i = 0; i < web.size(); i++) {
                                        if(msg[2].compareTo(web.get(i).getNameUser()) == 0 ){
                                            exits = true;
                                        }
                                    }
                                    if(!exits){
                                        web.add(new UserWeb(msg[2]));
                                        usuarios.add(msg[2]);
                                        out.writeUTF("accept");
                                        
                                        String sl="";
                                        for (int i = 0; i <usuarios.size(); i++) {
                                               sl+=usuarios.get(i)+":";
                                        }
                                        for (int i = 0; i < escritorio.size(); i++) {
                                            DataOutputStream o = new DataOutputStream(escritorio.get(i).getOutputStream());
                                            o.writeUTF("ListUsers:"+sl);
                                        }      
                                    }else{
                                        out.writeUTF("deny");
                                    }
                                break;
                                case "refresh":
                                    String sls="";
                                    switch(msg[2]){
                                        case "salas":
                                            for (int i = 0; i <salas.size(); i++) {
                                                sls+=salas.get(i).nameRoom+":";
                                            }
                                            out.writeUTF(sls);
                                            
                                            
                                        break;
                                        case "usuarios":
                                            for (int i = 0; i <usuarios.size(); i++) {
                                               sls+=usuarios.get(i)+":";
                                            }
                                            out.writeUTF(sls);
                                            
                                        break;
                                        
                                        case "messages":
                                            out.writeUTF(conversation);
                                            break;
                                        
                                    }
                                    
                                    
                                    
                                break;
                                case "createRoom":
                                    System.out.println("sala creada");
                                    
                                    Sala s = new Sala(msg[2], msg[3]);
                                    salas.add(s);
                                    for (int i = 0; i < web.size(); i++) {
                                        if(msg[2].compareTo(web.get(i).nameUser)==0){
                                            web.get(i).setSala(msg[3]);
                                        }
                                    }
                                    
                                    String sl="";
                                    for (int i = 0; i <salas.size(); i++) {
                                       sl+=salas.get(i).nameRoom+":";
                                    }
                                    out.writeUTF(sl);
                                    for (int i = 0; i < escritorio.size(); i++) {
                                        DataOutputStream o = new DataOutputStream(escritorio.get(i).getOutputStream());
                                        o.writeUTF("ListSalas:"+sl);
                                    }
                                    
                                    break;
                                case "Msg":
                                    instring = msg[2] +"> " +msg[3];
                                    conversation = conversation +"<br>"+instring;
                                    out.writeUTF(conversation);
                                    break;
                                 
                            }
                        }else{
                            System.out.println("Conexion desde el Escritorio");
                            usuarios.add(msg[1]);
                            escritorio.add(client);
                            String sl="";
                            for (int i = 0; i <usuarios.size(); i++) {
                                   sl+=usuarios.get(i)+":";
                            }
                            for (int i = 0; i < escritorio.size(); i++) {
                                DataOutputStream o = new DataOutputStream(escritorio.get(i).getOutputStream());
                                o.writeUTF("ListUsers:"+sl);
                            }
                            
                            String sls="";
                            for (int i = 0; i <salas.size(); i++) {
                               sls+=salas.get(i).nameRoom+":";
                            }
                            out.writeUTF("ListSalas:"+sls);
                            
                            Servicio s = new Servicio(msg[1],client, escritorio,salas);
                            s.start();
                        }
                        System.out.println("Salas: " +salas);
                        System.out.println("Usuarios: " +usuarios);
                }
        } catch (IOException ex) {
            Logger.getLogger(ServerChatRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
