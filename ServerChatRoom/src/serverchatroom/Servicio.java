/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchatroom;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Arcos
 */
public class Servicio extends Thread{
        private Socket socket;
        private DataInputStream in;
        private DataOutputStream out;
        //Lista de los usuarios conectados al servidor
        private LinkedList<Socket> usuarios = new LinkedList<Socket>();
        ArrayList<Sala> salas;
        String usr;
        ArrayList<String> miSalas;
        public Servicio(String usr,Socket soc,LinkedList<Socket> users,ArrayList<Sala> salas) throws IOException{
            socket = soc;
            this.usr=usr;
            this.salas=salas;
            this.usuarios=users;
            this.miSalas=new ArrayList<>();
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
           
        }
        public void run(){               
                try {
                    //Inicializamos los canales de comunicacion y mandamos un mensaje de bienvenida

                    //Ciclo infinito para escuchar por mensajes del cliente
                    while(true){
                       String recibido = in.readUTF();
                       //Cuando se recibe un mensaje se envia a todos los usuarios conectados 
                        //                           out = new DataOutputStream(usuarios.get(i).getOutputStream());
                       String[] msg = recibido.split(":");
                       switch(msg[0]){
                           case "createRoom":
                                System.out.println("sala creada");
                                miSalas.add(msg[1]);
                                Sala s = new Sala(usr, msg[1]);
                                salas.add(s);
                                String sls="";
                                for (int i = 0; i <salas.size(); i++) {
                                   sls+=salas.get(i).nameRoom+":";
                                }
                                for (int i = 0; i < usuarios.size(); i++) {
                                    out = new DataOutputStream(usuarios.get(i).getOutputStream());
                                    out.writeUTF("ListSalas:"+sls);
                                }
                           break;
                           case "sendMesagge":
                               for (int i = 0; i < salas.size(); i++) {
                                   
                               }
                           break;
                       }
                       
                       
                            
                       
                       
                                            
                    }
                } catch (IOException e) {
                    //Si ocurre un excepcion lo mas seguro es que sea por que el cliente se desconecto asi que lo quitamos de la lista de conectados
                    for (int i = 0; i < usuarios.size(); i++) {
                        if(usuarios.get(i) == socket){
                            usuarios.remove(i);
                            break;
                        } 
                }
                
            }
        }
        
        public void createRoom(String roomName){
            Sala room = new Sala("user", roomName);
            salas.add(room);
            
        }
        
        
    }
