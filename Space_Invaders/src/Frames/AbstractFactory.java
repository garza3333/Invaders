/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import structures.*;

/**
 *
 * @author Curso
 */
public class AbstractFactory {
    public AbstractFactory(){
        
    }
    public Object makeRowShips(String type){
            return this.makeRS(type);
    }
    
    
    
    
    
    private Object makeRS(String type){
        
        switch(type){
            case "Basic":
                LinkedList l = new LinkedList();
                for(int i = 0; i<9 ; i++){
                    Ship s = new Ship(i);
                    l.add(s);
                }
                return l;
                
            case "ShipA":
             LinkedList ll = new LinkedList();
                for(int i = 0; i<9 ; i++){
                    Ship s = new Ship(i);
                    ll.add(s);
                }           
                return ll;
                
            case "ShipB":
             DoublyLinkedList ld = new DoublyLinkedList();
                for(int i = 0; i<9 ; i++){
                    Ship s = new Ship(i);
                    ld.add(s); }              
                return ld;
                
            case "ShipC":
            
             CircularList cl = new CircularList();
                for(int i = 0; i<9 ; i++){
                    Ship s = new Ship(i);
                    cl.add(s); }              
                return cl;
                
            case "ShipD":
            
             LinkedList lll = new LinkedList();
                for(int i = 0; i<9 ; i++){
                    Ship s = new Ship(i);
                    lll.add(s); } 
                
                return lll;
                
            case "ShipE":
            
             DoublyCircularList dc = new DoublyCircularList();
                for(int i = 0; i<9 ; i++){
                    Ship s = new Ship(i);
                    dc.add(s); } 
                
                return dc;
                
            default:
                return null;
            
        }
    } 
    
}
