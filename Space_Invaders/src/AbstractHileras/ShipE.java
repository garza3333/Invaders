
package AbstractHileras;

import AbstractEnemy.Enemy;
import FactoryEnemies.FactoryBasic;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

import structures.DoublyCircularList;

import structures.Node;

/**
 *
 * @author Daniel
 */
public class ShipE implements AbstractHilera{
    private int x,y;
    private DoublyCircularList l;
    private FactoryBasic fb;
    private boolean flag,flagMove;
    private int speed;
    private Image image,imageBoss;
    private String type;
    @Override
    public void init(int s) {
        this.speed = s;
        setPosX(250);
        setPosY(0);
        this.fb = new FactoryBasic();
        this.l = new DoublyCircularList();
        int cont = 0;
        this.image = Toolkit.getDefaultToolkit().getImage("Images/shipE.png");
        this.imageBoss = Toolkit.getDefaultToolkit().getImage("Images/boss.png");
        this.type = "Type E";
        flag = true;
        flagMove = true;
        int pos = 0;
        
        
        while(cont < 11){
            
            if(cont == 5){
                Enemy e = fb.createEnemy(imageBoss, x+pos, 0, 5, true);
                Node ship = new Node(e);
                l.add(ship);
                cont+=1;
                pos+=40;
                        
            }            
            
            
            Enemy e = fb.createEnemy(image,x+pos, 0, 1, false);
            
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
    
    @Override
    public DoublyCircularList getList(){
        return l;
    }

    @Override
    public void draw(Canvas c , Graphics2D g) {
        Node temp = this.l.getHead();
        int cont = 0;
        while(cont!=l.getSize()){
            
            g.drawImage(temp.getValue().getImage(),temp.getValue().getX(),temp.getValue().getY(),c);
            
            temp = temp.getNext();
            cont++;
            
              
        }
        
    }


    @Override
    public void down() {
        
         
         
        if(flagMove && l.getTail().getValue().getX()<=750){
            if(l.getTail().getValue().getX()== 750){
            flagMove = false;
            Node temp  = l.getHead();
            y += 20;
            int cont = 0;
            while(cont!= l.getSize()){

                temp.getValue().setY(y);
                
               
                temp = temp.getNext();
                cont++;
                
                }     
        }
            int cont = 0;
            Node temp = l.getHead();
            while(cont!=l.getSize()){

                   temp.getValue().setX(temp.getValue().getX()+2);
                   
              
                                 
                   temp = temp.getNext();
                   cont++;
            }
        }else if(!flagMove && l.getHead().getValue().getX()>=10){
            
            if(l.getHead().getValue().getX()== 10){
            flagMove = true;
            
            
            
                    
            Node temp  = l.getHead();
            y += 20;
            int cont = 0;
            while(cont!= l.getSize()){

                temp.getValue().setY(y);
                     
                temp = temp.getNext();
                cont++;
                }
            }
            
            int cont = 0;
            Node temp = l.getHead();
            while(cont!=l.getSize()){

                temp.getValue().setX(temp.getValue().getX()-2);
                      
                temp = temp.getNext();
                cont++;
            }
        }


        }
    
    @Override
    public void changeBoss(){
        int randomNum = ThreadLocalRandom.current().nextInt(0,l.getSize());
        int cont = 0;
        
        Node temp = l.getHead();
        while(cont<l.getSize()){
            if(cont == randomNum){
                temp.getValue().setBoss(true);
                
                break;
            }
            temp = temp.getNext();
            cont++;
        }
    }

    public ShipD.BubbleList bubleSort(ShipD.BubbleList list){
        return list;
        
        
    }

    @Override
    public void destroy(int i) {
            this.l.delete(i);
    }

    @Override
    public void center(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void destroyAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


   //Actualiza los valores de las posiciones de cada objeto del atributo lista
   public class Moviment extends Thread{
       @Override
       public void run(){
           while(true){
           down();
           if(speed == 0){
           try {
               Moviment.sleep(10);
           } catch (InterruptedException ex) {
               Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
            }
           }else if(speed == 1){
               try {
                   Moviment.sleep(6);
               } catch (InterruptedException ex) {
                   Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
               }
           }else if(speed >= 2){
               try {
                   Moviment.sleep(4);
               } catch (InterruptedException ex) {
                   Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
               }
           }else if(speed >= 6){
               try {
                   Moviment.sleep(2);
               } catch (InterruptedException ex) {
                   Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           }
       }
   }

    
     
     
    
}

