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
    private boolean flag,flagMove;


    @Override
    public void init() {
        setPosX(250);
        setPosY(0);
        this.fb = new FactoryBasic();
        this.l = new LinkedList();
        int cont = 0;
        
        
        flag = true;
        flagMove = true;
        int pos = 0;
        while(cont < 10){
            
            Enemy e = fb.createEnemy(x+pos, 0, 1, false, 3,cont);
            
            Ship ship = new Ship(e);
            l.add(ship);
            
            cont+=1;
            pos+=40;
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
        
        while(temp!=null){
            
            g.drawImage(temp.getValue().getImage(),temp.getValue().getX(),temp.getValue().getY(),c);
            
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
        
        
        if(flagMove && l.getTail().getValue().getX()<=750){
            if(l.getTail().getValue().getX()== 750){
            flagMove = false;
            Ship temp  = l.getHead();
            y += 20;
            while(temp!= null){
                temp.getValue().setY(y);
                temp = temp.getNext();
                }     
        }
            Ship temp = l.getHead();
            while(temp!=null){
                   temp.getValue().setX(temp.getValue().getX()+2);
                   temp = temp.getNext();
            }
        }else if(!flagMove && l.getHead().getValue().getX()>=10){
            
            if(l.getHead().getValue().getX()== 10){
            flagMove = true;
            
            
            
                    
            Ship temp  = l.getHead();
            y += 20;
            while(temp!= null){
                temp.getValue().setY(y);
                temp = temp.getNext();
                }
            }
            
            Ship temp = l.getHead();
            while(temp!=null){
                temp.getValue().setX(temp.getValue().getX()-2);
                temp = temp.getNext();
            }
        }

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
