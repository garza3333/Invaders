
package Objects;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Daniel
 */
public class Bullet{
    private final Image bullet; 
    private int posX;
    private int posY;
    private final Canvas canvas;
    
    /**
     * Constructor de la clase Bullet, asigna valor al atributo canvas del objeto
     * @param canvas canvas en el que se dibuja
     */
    public Bullet(Canvas canvas){
        this.canvas = canvas;
        this.bullet = Toolkit.getDefaultToolkit().getImage("Images/bullet2.jpg");
        
    }
    /**
     * Retorna la posicion en x de la bala
     * @return 
     */
    public int getX(){
        return this.posX;
    }
    /**
     * retorna la posicion en y de la bala
     * @return 
     */
    public int getY(){
        return this.posY;
    }
    /**
     * retorna la imagen del atributo de image de la bala
     * @return 
     */
    public Image getImage(){
        return this.bullet;
    }
    /**
     * Asigna un nuevo valor al atributo posX de la bala
     * @param x 
     */
    public void setX(int x){
        this.posX = x;
    }
    /**
     * Asigna un nuevo valor al atributo posY de la bala
     * @param y 
     */
    public void setY(int y){
        this.posY += y;
    }
    /**
     * Metodo que dibuja la imagen de la bala en el canvas
     * @param g 
     */
    public void draw(Graphics2D g){
        g.drawImage(this.getImage(),this.posX,this.posY,this.canvas);
    }
    /**
     * Activa los metodos setX y setY para cambiar los valores de los atributos 
     * posX y posY de la bala
     * @param x
     * @param y 
     */
    public void update(int x , int y){
        this.setX(x);
        this.setY(y);
        
        
    }

}
