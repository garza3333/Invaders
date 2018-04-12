
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
import structures.CircularList;

import structures.Node;

/**
 *
 * @author Daniel
 */
public class ShipD implements AbstractHilera{
    private int x,y;
    private CircularList l;
    private FactoryBasic fb;
    private boolean flag,flagMove;
    
    private Image image,imageBoss;
    private String type;
    @Override
    public void init() {
        setPosX(250);
        setPosY(0);
        this.fb = new FactoryBasic();
        this.l = new CircularList();
        int cont = 0;
        this.image = Toolkit.getDefaultToolkit().getImage("Images/shipD.png");
        this.imageBoss = Toolkit.getDefaultToolkit().getImage("Images/boss.png");
        this.type = "Type D";
        flag = true;
        flagMove = true;
        int pos = 0;
        
        
        while(cont < 11){
            
            if(cont == 5){
                Enemy e = fb.createEnemy(imageBoss, x+pos, 0, 5, true, 3, cont);
                Node ship = new Node(e);
                l.add(ship);
                cont+=1;
                pos+=40;
                        
            }            
            
            
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
    
    @Override
    public CircularList getList(){
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

    public BubbleList bubleSort(BubbleList list){
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
   public class BubbleList{
       
       private int size;
       private BubbleNode head,tail;
       public BubbleList(){
           this.head = this.tail = null;
           this.size = 0;
           
       }
       public boolean isEmpty(){
           return this.head == null;
       }
       public int getSize(){
           return this.size;
       }
       public BubbleNode getHead(){
           return this.head;
       }
       public BubbleNode getTail(){
           return this.tail;
       }
       public void add(int n){
           if(isEmpty()){
               this.head = new BubbleNode(n);
           }else{
               BubbleNode temp = this.getTail();
               BubbleNode nuevo = new BubbleNode(n);
               temp.setNext(nuevo);
               this.tail = nuevo;
           }
           size++;
       }
       
       
       public class BubbleNode{
           private BubbleNode next,previous;
           private int value;
           public BubbleNode(int v){
               this.next = this.previous = null;
               this.value = v;
           }
           public void setNext(BubbleNode n){
               this.next = n;
           }
           public BubbleNode getNext(){
               return this.next;
           }
           public void setPrevious(BubbleNode n){
               this.previous = n;
           }
           public BubbleNode getPrevious(){
               return this.previous;
           }
           public int getValue(){
               return this.value;
           }
           public void setValue(int v){
               this.value = v;
           }
           
       }
   }

    
     
     
    
}

