
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
    
    
    public Bullet(Canvas canvas){
        this.canvas = canvas;
        this.bullet = Toolkit.getDefaultToolkit().getImage("Images/bullet2.jpg");
        
    }
    public int getX(){
        return this.posX;
    }
    public int getY(){
        return this.posY;
    }
    
    public Image getImage(){
        return this.bullet;
    }
    public void setX(int x){
        this.posX = x;
    }
    public void setY(int y){
        this.posY += y;
    }
    
    public void draw(Graphics2D g){
        g.drawImage(this.getImage(),this.posX,this.posY,this.canvas);
    }
    public void update(int x , int y){
        this.posX = x;
        this.posY = y;
        
        
    }

}
