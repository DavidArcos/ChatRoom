/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchatroom;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arcos
 */
public class Sala{
    String usr;
    String nameRoom;
    String mensaje;
    String conversation;
    
    
    public Sala(String usr,String nameRoom){
        
        this.usr=usr;
        this.nameRoom=nameRoom;
        this.conversation="";
        this.mensaje="";
    }
    
    
    public String getConversation(){
        return conversation;
    }
    public void setConversation(String con){
        conversation+="<br>"+con;
    }
    public void sendMesagge(String msj){
    }
    
    @Override
    public String toString(){
        return nameRoom;
    }
}
