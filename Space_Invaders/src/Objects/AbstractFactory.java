
package Objects;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import structures.*;

/**
 *
 * @author Curso
 */
public class AbstractFactory {
//    private static Canvas canvas;
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
    
    public static class Basic extends Thread{
        private final LinkedList list;
        private Graphics2D graphics;
        private Canvas canvas;
        protected  Image ship; 
        int posX,posY;
        
        public Basic(){
            
            posX = 0;
            posY = 0;
            setImageShip("Images/basic.png");
            
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
        public void setGC(Graphics2D g,Canvas c){
            this.canvas = c;
            this.graphics =g;
        }
      
        public void draw(Graphics2D g){
            int espacio = 0;
            
            Ship temp = list.getHead();
     
            while(temp != null){
                System.out.println("drawBasic");
                g.drawImage(ship,posX+espacio,posY,canvas);
                
                
                espacio+=40;
                temp = temp.getNext();
            }
        }
        
        @Override
        public void run(){
            System.out.println("Basic");
            while(!this.list.isEmpty() && posY != 500){
                System.out.println("checkout");
                this.draw(graphics);
                posY += 1;
                
                try {
                    Basic.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AbstractFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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
