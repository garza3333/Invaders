
package Objects;

import AbstractHileras.*;

import Frames.Manager;
import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import structures.Node;



/**
 *
 * @author Daniel
 */
public class MainShip implements KeyListener {
    private final Image ship;
    int shipX,shipY;
    boolean right,left,space,shoot,flagS;
  
    private Bullet b;
    
    private final Canvas component;
    
    private Manager manager;
    
    public MainShip(Canvas  canvas, Manager g){
        ship =  Toolkit.getDefaultToolkit().getImage("Images/spaceship64bits.png");
        this.shipX = 400; //790 limite derecho //400 pos nave
        this.shipY = 500; // limite de naves enemigas //500 en y
        this.component = canvas;
        this.b = new Bullet(component);
        this.manager = g;
        
        
    }
    public Image getImage(){
        return this.ship;
    }
    public int getX(){
        return this.shipX;
    }
    public int getY(){
        return this.shipY;
    }
    public Bullet getBullet(){
        return this.b;
    }
    
    public void draw(Graphics2D g){
        g.drawImage(this.getImage(),this.getX(),this.getY(),this.component);
        if(shoot){
        b.draw(g);
        }
        
    }
    
    public void update(){
        if(right && !left ){
            if(getX() != 750){
                shipX += 2;
            }else{
                    shipX = 750;}
        }else if(left && !right ){
            if(getX() != 10){
                shipX -= 2;
            }else{
                shipX = 10;}
        }
    
                
        if(space){
        if(b==null){
        b = new Bullet(component);
        }
        if(!flagS){
        Shoot s = new Shoot();
        s.start();}

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
       
            if(KeyEvent.VK_RIGHT == code){
                if(getX() < 700){
                    this.right = true;}}
           
            else if(KeyEvent.VK_LEFT == code){
                if(getX() > 30 ){
                    this.left = true;}}
         
            else if(KeyEvent.VK_SPACE ==  code){
                this.space = true;}
           
     
           
        }
    

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        
            if(KeyEvent.VK_RIGHT == code){
                this.right = false;}
                
            else if(KeyEvent.VK_LEFT == code){
                this.left = false;}
                
            else if (KeyEvent.VK_SPACE == code){
                this.space = false;}
               
    }
    
    
         class Shoot extends Thread{
             

             @Override
             public void run(){
                 
                
                
                b.update(shipX+8,shipY);
                
                shoot = true;
                flagS = true;
               
                    

                while(b.getY() != 0){
                    int cont = 0;
                    
                    AbstractHilera hilera = manager.getPlayFrame().getCanvas().getCurrentHilera();
                    Node temp = manager.getPlayFrame().getCanvas().getCurrentHilera().getList().getHead();
                    
                    
                    if(hilera.getClass() == Basic.class || hilera.getClass() == ShipA.class || hilera.getClass() == ShipB.class){
                        while(temp!=null){
                            if(b.getX()<temp.getValue().getX()+32 && b.getX()+16>temp.getValue().getX()
                              && b.getY()<temp.getValue().getY()+32 && b.getY()+16 > temp.getValue().getY()){
                                System.out.println("colision b B A");
                                hilera.destroy(cont);
                                shoot = false;
                                flagS = false;
                                break;
                                
                                
                            }
                            temp = temp.getNext();
                            cont++;
                        }
                        
                        
                    }else if(hilera.getClass() == ShipC.class || hilera.getClass() == ShipD.class || hilera.getClass() == ShipE.class){
                        
                        int ind = 0;
                        while(ind!=manager.getPlayFrame().getCanvas().getCurrentHilera().getList().getSize()){
                            if(b.getX()<temp.getValue().getX()+32 && b.getX()+16>temp.getValue().getX()
                              && b.getY()<temp.getValue().getY()+32 && b.getY()+16 > temp.getValue().getY()){
                                System.out.println("colision C D E");
                                hilera.destroy(cont);
                                shoot = false;
                                flagS = false;
                                break;
                                
                                
                                
                                
                            }
                            temp = temp.getNext();
                            cont++;
                            ind++;
                        }                        
                    }
                   
                    
                    
                    b.setY(-1);
                    
                    try {
                        Shoot.sleep(1);
                    } catch (InterruptedException ex) {
                        System.out.println(ex.getMessage());
                        }
                                      
                    }
                shoot = false;
                flagS = false;    
                
             }
         }    
    
}
