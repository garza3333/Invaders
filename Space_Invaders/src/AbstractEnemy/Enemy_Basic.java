/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractEnemy;

import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author Daniel
 */
public class Enemy_Basic implements Enemy{
    private  Image image;
    private int posX,posY,speed,life,id;
    private boolean boss;
    private Rectangle posColition;
    
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
        this.posColition = new Rectangle(x,y,x+32,y+32);
        
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

    @Override
    public void setPosColition(Rectangle r) {
        this.posColition = r;
    }

    @Override
    public Rectangle getPosColition() {
        return this.posColition;
    }

    @Override
    public void update(int x, int y) {
        this.posColition = new Rectangle(x,y,x+32,y+32);
    }
    

    
}
