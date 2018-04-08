/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractHilera;

import AbstractEnemy.Enemy;
import FactoryEnemies.FactoryBasic;
import java.awt.Canvas;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import structures.LinkedList;
import structures.Ship;

/**
 *
 * @author curso
 */
public class HileraB implements AbstractHilera{
    private int x,y;
    private LinkedList l;
    private FactoryBasic fb;
    private boolean flag;


    @Override
    public void init() {
        setPosX(0);
        setPosY(0);
        this.fb = new FactoryBasic();
        this.l = new LinkedList();
        int cont = 0;
        int pos = 250;
        flag = true;
        while(cont < 8){
            
            Enemy e = fb.createEnemy(pos, 0, 1, false, 3,cont);
            Ship ship = new Ship(e);
            l.add(ship);
            
            cont+=1;
            
        }
        if(flag){
            flag = false;
            Moviment m = new Moviment();
            m.start();
        }
        
        
    }

    @Override
    public void setPosX(int x) {
        this.x = x;
    }

    @Override
    public void setPosY(int y) {
        this.y = y;
    }
    public LinkedList getList(){
        return l;
    }

    @Override
    public void draw(Canvas c , Graphics2D g) {
        Ship temp = this.l.getHead();
        int  cont = 0;
        while(temp!=null){
            g.drawImage(temp.getValue().getImage(),temp.getValue().getX()+cont,y,c);
            cont+= 40;
            temp = temp.getNext();
            
              
        }
        
    }



//    @Override
//    public void setCanvas(Canvas c) {
//        this.c = c;
//    }
//
//    @Override
//    public void setGraphics(Graphics2D g) {
//        this.g = g;
//    }

    @Override
    public void update() {
        this.y+=1;
    }
    
    
   public class Moviment extends Thread{
       @Override
       public void run(){
           while(true){
           update();
           try {
               Moviment.sleep(10);
           } catch (InterruptedException ex) {
               Logger.getLogger(HileraB.class.getName()).log(Level.SEVERE, null, ex);
           }}
       }
   }

    
     
     
    
}
