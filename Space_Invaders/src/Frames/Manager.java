/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import javax.swing.JFrame;

/**
 *
 * @author curso
 */
public class Manager {
    
    public Manager(){
            
    }
    
    
    
    public void show(String n){
        switch(n){
            case "main":
                MainFrame m = new MainFrame();         
                break;
                
                
            case "data":  
                DataFrame d = new DataFrame();
                break;
            
            case "start":
                UsserFrame u = new UsserFrame();
                break;
            
            case "play":
                PlayFrame p = new PlayFrame();
                break;
                
                
        }
                
                    
                    
                
    }
    
}
