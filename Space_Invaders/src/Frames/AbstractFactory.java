/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.awt.Image;
import java.awt.Toolkit;
import structures.*;

/**
 *
 * @author Curso
 */
public class AbstractFactory {
    public AbstractFactory(){
        
    }
    public Object makeRowShips(int type){
            return this.makeRS(type);
    }
    
    
    
    
    
    private Object makeRS(int type){
        
        switch(type){
            //Basic
            case 0:
                Basic b = new Basic();
                return b;
                
            //ShipA
            case 1:
                ShipA a = new ShipA();
                return a;
            //ShipB    
            case 2:
                ShipB bb = new ShipB();
                return bb;
            
            //ShipC
            case 3:
            
                ShipC c = new ShipC();
                return c;
                
            //ShipD
            case 4:
            
                ShipD d = new ShipD();
                return d;
            //ShipE
            case 5:
            
                ShipE e = new ShipE(); 
                return e;
                
            default:
                return null;
            
        }
    }
    
    public static class Basic{
        private final LinkedList list;
        protected  Image ship; 

        public Basic(){
            this.setImageShip("Images/basic.png");
            list = new LinkedList();
            
            for(int i = 1; i<8 ; i++){
                Ship s = new Ship(i);
                list.add(s);            
            }
        
        
        } 
        public Image getImageShip(){
            return this.ship;
        }
        public void setImageShip(String i){
            this.ship = Toolkit.getDefaultToolkit().getImage(i);
        }
        public LinkedList getList(){
            return this.list;
        }
    }
    
    public static class ShipA extends Basic{
        
        private final LinkedList list;
        
        public ShipA(){
            this.setImageShip("Images/shipA.png");
            
            list = new LinkedList();
                for(int i = 1; i<8 ; i++){
                    Ship s = new Ship(i);
                    list.add(s);
                }            
        }

        
    }
    
    public static class ShipB extends Basic{
        
        private final DoublyLinkedList list;
        
        public ShipB(){
            this.setImageShip("Images/shipB.png");
            list = new DoublyLinkedList();
                for(int i = 1; i<8 ; i++){
                    Ship s = new Ship(i);
                    list.add(s);
                }            
        }
        @Override
        public DoublyLinkedList getList(){
            return this.list;
        }
        
    }

    public static class ShipC extends Basic{
        
        private final CircularList list;
        
        public ShipC(){
            this.setImageShip("Images/shipC.png");
            list = new CircularList();
                for(int i = 1; i<8 ; i++){
                    Ship s = new Ship(i);
                    list.add(s);
                }            
        }
        @Override
        public CircularList getList(){
            return this.list;
        }        
        
    }

    public static class ShipD extends Basic{
        
        private final LinkedList list;
        
        public ShipD(){
            this.setImageShip("Images/shipD.png");
            list = new LinkedList();
                for(int i = 1; i<8 ; i++){
                    Ship s = new Ship(i);
                    list.add(s);
                }            
        }
   
       
        
    }

    public static class ShipE extends Basic{
        
        private final DoublyCircularList list;
        
        public ShipE(){
            this.setImageShip("Images/shipE.png");
            list = new DoublyCircularList();
                for(int i = 1; i<8 ; i++){
                    Ship s = new Ship(i);
                    list.add(s);
                }            
        }
        @Override
        public DoublyCircularList getList(){
            return this.list;
        }        
        
    }
    
    
}
