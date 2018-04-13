
package AbstractEnemy;

import java.awt.Image;


/**
 *
 * @author Daniel
 */
public interface Enemy {
    
    public void init(Image image, int x , int y, int l ,boolean b);
    
    public void setLife(int l);
    public void setX(int x);
    public void setY(int y);
    public void setBoss(boolean b);
    
    public void setImage(Image i);
  
    
    
    
    
    
    
    
    
    public int getX();
    public int getY();
    public int getLife();
    public boolean isBoss();
   
    public Image getImage();
    
    
    
    
    
    
}
