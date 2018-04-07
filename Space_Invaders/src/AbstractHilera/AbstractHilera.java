/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractHilera;

import java.awt.Canvas;
import java.awt.Graphics2D;

/**
 *
 * @author curso
 */
public interface AbstractHilera {
    public void init();
    
    public void setPosX(int x);
    public void setPosY(int y);
//    public void setCanvas(Canvas c);
//    public void setGraphics(Graphics2D g);
    
    public void draw(Canvas c , Graphics2D g);
    public void update();
    
    
    
   
    
}
