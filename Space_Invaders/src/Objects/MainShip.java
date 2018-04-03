/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



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
    
    public MainShip(Canvas  canvas){
        ship =  Toolkit.getDefaultToolkit().getImage("Images/spaceship64bits.png");
        this.shipX = 400; //790 limite derecho //400 pos nave
        this.shipY = 500; // limite de naves enemigas //500 en y
        this.component = canvas;
        this.b = null;
        
        
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
                shipX += 1;
            }else{
                    shipX = 750;}
        }else if(left && !right ){
            if(getX() != 10){
                shipX -= 1;
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
                 System.out.println("Bullet");
                
                
                b.update(shipX+8,shipY);
                
                shoot = true;
                flagS = true;
               
                    

                
                while(b.getY() != 0){
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
