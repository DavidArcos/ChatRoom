/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatroom;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author Arcos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML TextField txtMesagge;
    @FXML TextArea txtChat;
    @FXML ComboBox<String> comboChatUser;
    @FXML ListView<String> listUsers,listChatRoom;
    
    
    User usr;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         usr = new User();
         usr.start();
            
            
    }
    public void UnirseSala(){}
    
    public void CrearSala(){
        try {
            String sala = JOptionPane.showInputDialog("Nombre de Sala");
            usr.CrearSala(sala);
            comboChatUser.getItems().add(sala);
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void EnviarMsj(){
        String sl = comboChatUser.getSelectionModel().getSelectedItem();
        usr.sendMesagge(sl+":User:"+txtMesagge.getText());
    }
    
    
    public void ElegirSala(){
    }
    
    
    
    public class User extends Thread{
        String ipServer = "ARCOS-PC";
        int port = 9999;
        Socket user;
        private DataInputStream in;
        private DataOutputStream out;
        
        boolean life = true;
        
        public User(){
            try {
                user = new Socket(ipServer, port);                

                out = new DataOutputStream(user.getOutputStream());
                in = new DataInputStream(user.getInputStream());
                out.writeUTF("Desktop:arcos");
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        public void run(){
                try{
                while(true){
                    String server = in.readUTF();
                    String[] svr = server.split(":");
                    switch(svr[0]){
                        case "ListSalas":
                            Platform.runLater(new Runnable() {
                                @Override public void run() {
                                    listChatRoom.getItems().removeAll(listChatRoom.getItems());
                                    for (int i = 1; i < svr.length; i++) {
                                        listChatRoom.getItems().add(svr[i]);
                                    }
                                }
                            });
                            
                        break;
                        case "ListUsers":
                            Platform.runLater(new Runnable() {
                                @Override public void run() {
                                    listUsers.getItems().removeAll(listUsers.getItems());
                                    for (int i = 1; i < svr.length; i++) {
                                        listUsers.getItems().add(svr[i]);
                                    }
                                }
                            });
                            
                        break;
                    }
                }
                }catch(Exception e){
                }
            
        }
        
        public void UnirseSala(){
            String a  = listUsers.getSelectionModel().getSelectedItem();
            int option  = JOptionPane.showConfirmDialog(null, "Desea Unirse a la Sala: " +a);
            if(option == 0){
            }else{
            }
        }
    
        public void CrearSala(String sala) throws IOException{
            
            if(sala!=null){
                out.writeUTF("createRoom:"+sala);   
            }
        }
        
        public void sendMesagge(String msg){
            try {
                out.writeUTF("sendMesagge:"+msg);
            } catch (IOException e) {
            }
        }
        
    }
}
