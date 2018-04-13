
package AbstractHileras;

import java.awt.Canvas;
import java.awt.Graphics2D;
import structures.AbstractList;

/**
 *
 * @author curso
 */
public interface AbstractHilera {
    public void init(int s);
    
    public void setPosX(int x);
    public void setPosY(int y);
    public AbstractList getList();

    
    public void destroy(int i);
    
    public void destroyAll();
    public String getType();
    
    public void changeBoss();
    
    public void center(int i);
    
    public void draw(Canvas c , Graphics2D g);
   
    
    
    public void down();
    
    
    
   
    
}
