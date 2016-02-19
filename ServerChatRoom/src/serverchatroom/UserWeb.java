/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchatroom;

import java.util.ArrayList;

/**
 *
 * @author Arcos
 */
public class UserWeb {
    String nameUser;
    ArrayList<String> miSalas;
    
    public UserWeb(String nameUser){
        this.nameUser=nameUser;
        this.miSalas=new ArrayList<>();
    }
    
    public String getNameUser(){
        return this.nameUser;
    }
    public void setSala(String sala){
        this.miSalas.add(sala);
    }
    public ArrayList<String> getMiSalas(){
        return miSalas;
    }
}
