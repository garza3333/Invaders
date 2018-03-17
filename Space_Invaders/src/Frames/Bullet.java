/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

/**
 *
 * @author Curso
 */
public class Bullet{
    private final Image bullet; 
    private int posX;
    private int posY;
    public Bullet(){
        
        this.posY = 510;
        this.bullet = Toolkit.getDefaultToolkit().getImage("Images/bullet.png");
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

 

    

}
