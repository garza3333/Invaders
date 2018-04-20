
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
import structures.DoublyLinkedList;

import structures.Node;

/**
 *
 * @author Daniel
 */
public class ShipB implements AbstractHilera{
    private int x,y;
    private DoublyLinkedList l;
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
        this.l = new DoublyLinkedList();
        int cont = 0;
        this.image = Toolkit.getDefaultToolkit().getImage("Images/shipB.png");
        this.imageBoss = Toolkit.getDefaultToolkit().getImage("Images/boss.png");
        
        this.type = "Type B";
        flag = true;
        flagMove = true;
        int pos = 0;
        while(cont < 11){
            
            Enemy e = fb.createEnemy(image ,x+pos, 0, 1, false);
            
            Node ship = new Node(e);
            l.add(ship);
            
            cont+=1;
            pos+=40;
        }
        if(flag){
            flag = false;
            Moviment m = new Moviment();
            ChangeBoss cb = new ChangeBoss();
            m.start();
            cb.start();
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
    public DoublyLinkedList getList(){
        return l;
    }

    @Override
    public void draw(Canvas c , Graphics2D g) {
        Node temp = this.l.getHead();

        while(temp!=null){
            if(temp.getValue().isBoss()){
                
            
                g.setFont(new Font("Helvetica",Font.BOLD,10));
                g.setColor(Color.WHITE);
                g.drawString(Integer.toString(temp.getValue().getLife()), (temp.getValue().getX()+12), (temp.getValue().getY()-10));
            
                g.drawImage(imageBoss,temp.getValue().getX(),temp.getValue().getY(),c);
                
            }else{
                
            
            g.setFont(new Font("Helvetica",Font.BOLD,10));
            g.setColor(Color.WHITE);
            g.drawString(Integer.toString(temp.getValue().getLife()), (temp.getValue().getX()+12), (temp.getValue().getY()-10));
            
            g.drawImage(temp.getValue().getImage(),temp.getValue().getX(),temp.getValue().getY(),c);
            
            }
            temp = temp.getNext();
              
        }
        
    }


    @Override
    public void down() {
        

         
         
        if(flagMove && l.getTail().getValue().getX()<=750){
            if(l.getTail().getValue().getX()== 750){
            flagMove = false;
            Node temp  = l.getHead();
            y += 20;
            while(temp!= null){

                temp.getValue().setY(y);
                
                
                
               
    
                
                temp = temp.getNext();
                
                }     
        }
            Node temp = l.getHead();
            while(temp!=null){
                

                temp.getValue().setX(temp.getValue().getX()+2);
                
              
                                 
                   temp = temp.getNext();
            }
        }else if(!flagMove && l.getHead().getValue().getX()>=10){
            
            if(l.getHead().getValue().getX()== 10){
            flagMove = true;
            
            
            
                    
            Node temp  = l.getHead();
            y += 20;
            while(temp!= null){

                temp.getValue().setY(y);
               
         
                        
                temp = temp.getNext();
                }
            }
            
            Node temp = l.getHead();
            while(temp!=null){

                temp.getValue().setX(temp.getValue().getX()-2);
               
                
                
                
                 
                temp = temp.getNext();
            }
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
        l.deleteAll();
    }

    @Override
    public void changeBoss() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPosY() {
        return this.y;
    }
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
                   Moviment.sleep(4);
               } catch (InterruptedException ex) {
                   Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           }
       }
   }
   //Clase encargada de estar cambiando el jefe constantemente
   public class ChangeBoss extends Thread{
        private int randomNum,previous;
    
    @Override
    public void run(){
        boolean verdad = true;

        randomNum = ThreadLocalRandom.current().nextInt(0,l.getSize());
        previous = randomNum;
        while(verdad){

        Node temp = l.getHead();
        int cont = 0;
        while(temp!=null){
             
            randomNum = verifica(ThreadLocalRandom.current().nextInt(0,l.getSize()));
        
            
            if(cont != randomNum){
                temp.getValue().setBoss(false);   
                temp.getValue().setLife(1);
                temp = temp.getNext();
                cont++;
            }else{
            temp.getValue().setBoss(true);
            temp.getValue().setLife(5);
            temp = temp.getNext();
            cont = 0;
            }
                    if(l.getSize() == 1){
           verdad = false;
        }
            
        }
            try {
                ChangeBoss.sleep(350);
            } catch (InterruptedException ex) {
                Logger.getLogger(ShipB.class.getName()).log(Level.SEVERE, null, ex);
            }        
        
        
        }     
    }
    /**
     * verifica que el numero random siempre sea diferente
     * @param n
     * @return 
     */
    public int verifica(int n){
        if(n == previous){
           
            return verifica(ThreadLocalRandom.current().nextInt(0,l.getSize()));
        }else{
            return n;
        }
    }

   }
     
    
}

