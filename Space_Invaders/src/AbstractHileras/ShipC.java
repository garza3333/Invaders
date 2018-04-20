
package AbstractHileras;

import AbstractEnemy.Enemy;
import FactoryEnemies.FactoryBasic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import structures.CircularList;
import structures.Node;

/**
 *
 * @author Daniel
 */
public class ShipC implements AbstractHilera{
    private int x,y;
    private CircularList l;
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
        this.l = new CircularList();
        int cont = 0;
        this.image = Toolkit.getDefaultToolkit().getImage("Images/shipC.png");
        this.imageBoss = Toolkit.getDefaultToolkit().getImage("Images/boss.png");
        this.type = "Type C";
        
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
    public CircularList getList(){
        return l;
    }

    @Override
    public void draw(Canvas c , Graphics2D g) {
        int cont = 0;
        Node temp = this.l.getHead();
        
        while(cont != l.getSize()){
            
            g.setFont(new Font("Helvetica",Font.BOLD,10));
            g.setColor(Color.WHITE);
            g.drawString(Integer.toString(temp.getValue().getLife()), (temp.getValue().getX()+12), (temp.getValue().getY()-10));
            
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
            while(cont != l.getSize()){

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
        
        
        
        int cont = 0;
        
        int randomNum = ThreadLocalRandom.current().nextInt(0,l.getSize()+1);
        

        
        Node temp = l.getHead();
        
        while(cont<l.getSize()){
            if(cont == randomNum){
                temp.getValue().setImage(imageBoss);
                temp.getValue().setBoss(true);
                temp.getValue().setLife(5);
                break;
            }
            temp = temp.getNext();
            cont++;
        }
    }

    @Override
    public void destroy(int i) {
            this.l.delete(i);
    }

    @Override
    public void center(int i) {
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void destroyAll() {
    }

    @Override
    public int getPosY() {
        return this.y;
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
           }else if(speed >= 6){
               try {
                   Moviment.sleep(2);
               } catch (InterruptedException ex) {
                   Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
               }
           }else if(speed >= 2){
               try {
                   Moviment.sleep(6);
               } catch (InterruptedException ex) {
                   Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           }
       }
   }

    
     
     
    
}

