
package Objects;

import AbstractHileras.*;

import Frames.Manager;
import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    /**
     * Constructor de la clase MainShip , asigna valores a los atributos de 
     * canvas y de graphics del objeto MainShip
     * @param canvas canvas del objeto
     * @param g objeto para dibujar
     */
    public MainShip(Canvas  canvas, Manager g){
        ship =  Toolkit.getDefaultToolkit().getImage("Images/spaceship64bits.png");
        this.shipX = 400; //790 limite derecho //400 pos nave
        this.shipY = 500; // limite de naves enemigas //500 en y
        this.component = canvas;
        this.b = new Bullet(component);
        this.manager = g;
        
        
    }
    /**
     * Retorna la imagen de la nave principal
     * @return ship
     */
    public Image getImage(){
        return this.ship;
    }
    /**
     * Retorna la posicion en "x" de la nave principal
     * @return 
     */
    public int getX(){
        return this.shipX;
    }
    /**
     * retorna la posicion en "y" de la nave principal
     * @return 
     */
    public int getY(){
        return this.shipY;
    }
    /**
     * Retorna el objeto bala contenido en el objeto MainShip
     * @return 
     */
    public Bullet getBullet(){
        return this.b;
    }
    
    /**
     * Metodo que dibuja la imagen de la nave principal en el canvas
     * y a la vez activa el metodo dibujar del objeto bala
     * @param g objeto encargado de dibujar 
     */
    
    public void draw(Graphics2D g){
        g.drawImage(this.getImage(),this.getX(),this.getY(),this.component);
        if(shoot){
        b.draw(g);
        }
        
    }
    
    /**
     * metodo que modifica las posiciones de la nave principal y verifica 
     * limites para que no se salga de la pantalla
     */
    
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

    
    /**
     * Se activa cuando la tecla es presionada de manera rapida
     * @param e 
     */
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    /**
     * Metodo que se activa cuando la tecla es presionada 
     * dependiendo de la tecla ya sea left,right o space, cambia el flag a true
     * de esa tecla para que el metodo update lo tome y modifique la posicion
     * de la nave
     * @param e 
     */
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
    
    /**
     * Metodo que se activa cuando la tecla es soltada
     * dependiendo de la tecla ya sea left,right o space, cambia el flag a false
     * de esa tecla para que el metodo update lo tome y modifique la posicion
     * de la nave
     * @param e 
     */

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
    
    
  //Clase que permite la actualizacion de la posiciones del objeto bala
         class Shoot extends Thread{
             

             /**
              * Metodo heredado de la clase thread que inicia el proceso
              * constantemente actualiza las posiciones del objeto bala
              * y activa los flags para que esta sea dibujada en el draw del MainShip
              * Tambien verifica constantemente que tipo de hilera se esta reproduciendo 
              * actualmente para tomar decisiones a la hora de colisionar 
              */
             @Override
             public void run(){
                boolean verdad = true;

                b.update(shipX+8,shipY);
                
                shoot = true;
                flagS = true;
               
                    

                while(b.getY() != 0){
                    int cont = 0;
                    
                    AbstractHilera hilera = manager.getPlayFrame().getCanvas().getCurrentHilera();
                    Node temp = manager.getPlayFrame().getCanvas().getCurrentHilera().getList().getHead();
                    
                    
                    if(hilera.getClass() == Basic.class || hilera.getClass() == ShipA.class || hilera.getClass() == ShipB.class){
                        
                        
                        
                        while(temp!=null && verdad){
                            if(b.getX()<temp.getValue().getX()+32 && b.getX()+16>temp.getValue().getX()
                              && b.getY()<temp.getValue().getY()+32 && b.getY()+16 > temp.getValue().getY()){
                                verdad = false;
                                
                                manager.getPlayFrame().plusScorePlayer(hilera.getList().findI(cont).getLife()*10);
                                if(temp.getValue().getLife() == 1)
                                {                                
                                    if(temp.getValue().isBoss()){
                                    
                                        

                                    hilera.destroyAll();
                                    

                                    manager.getPlayFrame().getCanvas().updateHilera(hilera);

                                        
                                    break;
                                    }else{
                                       hilera.destroy(cont); 
                                       break;
                                    }
                                }
                                else{
                                
                                temp.getValue().setLife(temp.getValue().getLife()-1);

                                break;}
                                
                                
                            }
                            temp = temp.getNext();
                            cont++;
                        }
                        
                        
                    }else if(hilera.getClass() == ShipD.class){
                        int ind = 0;
                        while(ind!=manager.getPlayFrame().getCanvas().getCurrentHilera().getList().getSize()&&verdad){
                            
                            
                            if(b.getX()<temp.getValue().getX()+32 && b.getX()+16>temp.getValue().getX()
                              && b.getY()<temp.getValue().getY()+32 && b.getY()+16 > temp.getValue().getY()){
                                
                                verdad = false;
                                flagS = false;
                                shoot = false;
                                manager.getPlayFrame().plusScorePlayer(hilera.getList().findI(cont).getLife()*10);
                                
                                if(temp.getValue().getLife() == 1){
                                if(temp.getValue().isBoss()){
                                    

                                    hilera.destroy(cont);

                                    hilera.changeBoss();                                    

                                        
                                    break;
                                    }else{
                                    hilera.destroy(cont);
                                }
                                }
                                else{                                
                                
                                temp.getValue().setLife(temp.getValue().getLife()-1);

                                break;}
                                

                            }
                            temp = temp.getNext();
                            cont++;
                            ind++;
                        }                          
                        
                        
                        
                        
                    }
                    
                    
                    else if(hilera.getClass() == ShipE.class){
                        
                        int ind = 0;
                        while(ind!=manager.getPlayFrame().getCanvas().getCurrentHilera().getList().getSize() && verdad){
                            if(b.getX()<temp.getValue().getX()+32 && b.getX()+16>temp.getValue().getX()
                              && b.getY()<temp.getValue().getY()+32 && b.getY()+16 > temp.getValue().getY()){
                                verdad = false;
                                
                                manager.getPlayFrame().plusScorePlayer(hilera.getList().findI(cont).getLife()*10);
                                
                                if(temp.getValue().getLife() == 1){
                                if(temp.getValue().isBoss()){
                                    

                                    hilera.destroy(cont);

                                    hilera.changeBoss();                                    

                                        
                                    break;
                                    }else{
                                    hilera.destroy(cont);
                                }
                                }
                                else{                                
                                
                                temp.getValue().setLife(temp.getValue().getLife()-1);

                                break;}
                                

                            }
                            temp = temp.getNext();
                            cont++;
                            ind++;
                        }                        
                    }else if(hilera.getClass() == ShipC.class){
                        
                        
                        int ind = 0;
                        while(ind!=manager.getPlayFrame().getCanvas().getCurrentHilera().getList().getSize() && verdad){
                            if(b.getX()<temp.getValue().getX()+32 && b.getX()+16>temp.getValue().getX()
                              && b.getY()<temp.getValue().getY()+32 && b.getY()+16 > temp.getValue().getY()){
                                
                                verdad = false;
                                
                                manager.getPlayFrame().plusScorePlayer(hilera.getList().findI(cont).getLife()*10);
                                
                                if(temp.getValue().getLife() == 1){
                                if(temp.getValue().isBoss()){
                                    

                                    hilera.destroy(cont);
                                   
                                    hilera.changeBoss();
                                                          

                                        
                                    break;
                                    }else{
                                    hilera.destroy(cont);
                                }
                                }
                                else{                                
                                
                                temp.getValue().setLife(temp.getValue().getLife()-1);

                                break;}
                                

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
