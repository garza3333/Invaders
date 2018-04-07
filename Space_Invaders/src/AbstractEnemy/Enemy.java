/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractEnemy;

import java.awt.Image;

/**
 *
 * @author curso
 */
public interface Enemy {
    
    public void init( int x , int y, int l ,boolean b, int s, int id);
    
    public void setLife(int l);
    public void setX(int x);
    public void setY(int y);
    public void setBoss(boolean b);
    public void setSpeed(int s);
    public void setImage(Image i);
    public void setID(int id);
    
    
    
    
    
    public int getX();
    public int getY();
    public int getLife();
    public boolean isBoss();
    public int getSpeed();
    public Image getImage();
    public int getID();
    
    
    
    
}
