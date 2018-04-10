/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractHilera;

import AbstractEnemy.Enemy;
import FactoryEnemies.FactoryBasic;
import Frames.Manager;
import Objects.Bullet;
import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import structures.LinkedList;
import structures.Node;

/**
 *
 * @author Daniel
 */
public class ShipE implements AbstractHilera{
    private int x,y;
    private LinkedList l;
    private FactoryBasic fb;
    private boolean flag,flagMove;
    private Manager g;
    private Image image;


    @Override
    public void init() {
        setPosX(250);
        setPosY(0);
        this.fb = new FactoryBasic();
        this.l = new LinkedList();
        int cont = 0;
        this.image = Toolkit.getDefaultToolkit().getImage("Images/ShipE.png");
        g = new Manager();
        
        flag = true;
        flagMove = true;
        int pos = 0;
        while(cont < 10){
            
            Enemy e = fb.createEnemy(image,x+pos, 0, 1, false, 3,cont);
            
            Node ship = new Node(e);
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
        Node temp = this.l.getHead();
        
        while(temp!=null){
            
            g.drawImage(temp.getValue().getImage(),temp.getValue().getX(),temp.getValue().getY(),c);
            
            temp = temp.getNext();
            
              
        }
        
    }


    @Override
    public void down() {
        
//         Bullet b = g.getPlayFrame().getCanvas().getMainShip().getBullet();
         
         
        if(flagMove && l.getTail().getValue().getX()<=750){
            if(l.getTail().getValue().getX()== 750){
            flagMove = false;
            Node temp  = l.getHead();
            y += 20;
            while(temp!= null){

                temp.getValue().setY(y);
                temp.getValue().update(temp.getValue().getX(), y);
                
                
               
    
                
                temp = temp.getNext();
                
                }     
        }
            Node temp = l.getHead();
            while(temp!=null){

                   temp.getValue().setX(temp.getValue().getX()+2);
                   temp.getValue().update(temp.getValue().getX()+2, temp.getValue().getY());
              
                                 
                   temp = temp.getNext();
            }
        }else if(!flagMove && l.getHead().getValue().getX()>=10){
            
            if(l.getHead().getValue().getX()== 10){
            flagMove = true;
            
            
            
                    
            Node temp  = l.getHead();
            y += 20;
            while(temp!= null){

                temp.getValue().setY(y);
                temp.getValue().update(temp.getValue().getX(), y);
         
                        
                temp = temp.getNext();
                }
            }
            
            Node temp = l.getHead();
            while(temp!=null){

                temp.getValue().setX(temp.getValue().getX()-2);
                temp.getValue().update(temp.getValue().getX()-2, temp.getValue().getY());
                
                
                
                 
                temp = temp.getNext();
            }
        }
//        this.update(b);

        }

    @Override
    public void update(Bullet b) {
        Node temp = l.getHead();
        while(temp!=null){
            if(b.getR().intersects(temp.getValue().getPosColition())){
                System.out.println(temp.getValue().getID());
            }
        }
        
        
    }

    
    
    
   public class Moviment extends Thread{
       @Override
       public void run(){
           while(true){
           down();
           try {
               Moviment.sleep(10);
           } catch (InterruptedException ex) {
               Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
           }}
       }
   }

    
     
     
    
}

