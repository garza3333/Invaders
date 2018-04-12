
package AbstractEnemy;

import java.awt.Image;


/**
 *
 * @author Daniel
 */
public class Enemy_Basic implements Enemy{
    private  Image image;
    private int posX,posY,speed,life,id;
    private boolean boss;
  
    
    public Enemy_Basic(){
        
    }

    @Override
    public void init( Image image ,int x, int y, int l, boolean b, int s, int id) {
        setX(x);
        setY(y);
        setLife(l);
        setSpeed(s);
        setBoss(b);
        setImage(image);
       
        
    }
    
    
    
    /// SETS

    @Override
    public void setLife(int l) {
        this.life = l;
    }

    @Override
    public void setX(int x) {
        this.posX = x;
    }

    @Override
    public void setY(int y) {
        this.posY = y;
    }

    @Override
    public void setBoss(boolean b) {
        this.boss = b;
    }

    @Override
    public void setSpeed(int s) {
        this.speed = s;
    }

    @Override
    public void setImage(Image i) {
        this.image = i;
    }
    
    
    
    
/// GETS
    @Override
    public int getX() {
        return this.posX;
    }

    @Override
    public int getY() {
        return this.posY;
    }

    @Override
    public int getLife() {
        return this.life;
    }

    @Override
    public boolean isBoss() {
        return this.boss == true;
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public Image getImage() {
        return this.image;
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public int getID() {
        return this.id;
    }   
}
