
package Frames;



//import Objects.AbstractFactory;
import AbstractHilera.HileraB;
import FactoryHilera.FactoryHileraB;
import Objects.*;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import Objects.AbstractFactory.*;
import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

/**
 *
 * @author Daniel
 */
public class PlayFrame{

    private final Image Icono = Toolkit.getDefaultToolkit().getImage("Images/startup.png");
    private final JFrame v = new JFrame();
    private Color bg;
    private Font fontTitle;
    private static myCanvas canvas;
    
    
    
    public PlayFrame(){
        this.bg = new Color(0,0,0);
 try {
        fontTitle = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/District.ttf"));
        
        
        } 
        catch(FontFormatException | IOException e) 
        {
            fontTitle = null;
        }
        
        v.setTitle("Space Invaders");

        v.setResizable(false);
        v.setUndecorated(true);
        v.setIconImage(this.Icono);
        v.setSize(1000,550);
        v.setLocationRelativeTo(null);
        
        v.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4,BLACK));
        
        
        
        canvas = new myCanvas();

        
        JPanel controlPanel = new JPanel(); 
        controlPanel.setLayout(new BoxLayout(controlPanel,BoxLayout.Y_AXIS));
        controlPanel.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4,BLUE));
        controlPanel.setPreferredSize(new Dimension(193,548));
        controlPanel.setBackground(Color.BLACK);
        
        
        
        JLabel lblscore = new JLabel("Score");
        lblscore.setFont(this.fontTitle.deriveFont(Font.PLAIN,20));
        lblscore.setForeground(Color.WHITE);
        lblscore.setBounds(70,10,200,70);
        
        JLabel score = new JLabel("0");
        score.setFont(this.fontTitle.deriveFont(Font.PLAIN,20));
        score.setForeground(Color.WHITE);
        score.setBounds(70,60,200,70);
        
        
        JLabel lblcurrent = new JLabel("current");
        lblcurrent.setFont(this.fontTitle.deriveFont(Font.PLAIN,20));
        lblcurrent.setForeground(Color.WHITE);
        lblcurrent.setBounds(70,120,200,70);
        
        
        JLabel current = new JLabel("0");
        current.setFont(this.fontTitle.deriveFont(Font.PLAIN,20));
        current.setForeground(Color.WHITE);
        current.setBounds(70,120,200,70);
        
        
        JLabel lblNext = new JLabel("Next");
        lblNext.setFont(this.fontTitle.deriveFont(Font.PLAIN,20));
        lblNext.setForeground(Color.WHITE);
        lblNext.setBounds(70,120,200,70);
        
        
        JLabel next = new JLabel("0");
        next.setFont(this.fontTitle.deriveFont(Font.PLAIN,20));
        next.setForeground(Color.WHITE);
        next.setBounds(70,120,200,70);
        
        
        JLabel lblLevel = new JLabel("Level");
        lblLevel.setFont(this.fontTitle.deriveFont(Font.PLAIN,20));
        lblLevel.setForeground(Color.WHITE);
        lblLevel.setBounds(70,120,200,70);
        
        
        JLabel level = new JLabel("0");
        level.setFont(this.fontTitle.deriveFont(Font.PLAIN,20));
        level.setForeground(Color.WHITE);
        level.setBounds(70,120,200,70);
        
        
        controlPanel.add(Box.createRigidArea(new Dimension(50,50)));
        controlPanel.add(lblscore);
        controlPanel.add(score);
        controlPanel.add(Box.createRigidArea(new Dimension(50,50)));
        controlPanel.add(lblcurrent);  
        controlPanel.add(current);
        controlPanel.add(Box.createRigidArea(new Dimension(50,50)));
        controlPanel.add(lblNext);
        controlPanel.add(next);
        controlPanel.add(Box.createRigidArea(new Dimension(50,50)));
        controlPanel.add(lblLevel);
        controlPanel.add(level);
        
        JPanel fondo = new JPanel();

        fondo.setPreferredSize(new Dimension(800,1200));
        fondo.setBackground(this.bg);
 
        fondo.add(canvas);
        
        
        
        

        
        
        v.add(fondo,BorderLayout.WEST);
        v.add(controlPanel,BorderLayout.EAST);
        v.repaint();
        
        v.setVisible(true);
        canvas.start();
        
        
    }
    
    private class myCanvas extends Canvas implements Runnable{
     
       
        
//        private  StartEnemy enemy;
        private FactoryHileraB factoryB;
        HileraB basic;
        private  MainShip mainShip;
        private boolean running;
        private Thread thread;
        private boolean ff;
       
        
        public myCanvas(){
            
        
            setPreferredSize(new Dimension(800,1200));
            this.running = false;

            mainShip = new MainShip(this);
            factoryB = new FactoryHileraB();
            
//            enemy = new StartEnemy();
            ff = true;
            addKeyListener(mainShip);
            setFocusable(true);
            
            setVisible(true);
//            setOpaque(true);
        }

        
        public synchronized void start(){

            if(running){
                return;
            }
            running = true;
            thread = new Thread((Runnable) this);
            thread.start();
            
        }
        public synchronized void stop() throws InterruptedException{
            if(running){
                return;
            }
            running = false;
            thread.join();
        }
        
        @Override
        public void run(){
            
            
            
            this.createBufferStrategy(3);
            BufferStrategy bs = this.getBufferStrategy();
            basic = (HileraB) factoryB.makeRow();
            
            while(running){
                
//                System.out.println("running");
                this.draw(bs);
            }
            
//        public void paint(Graphics g){
////            int espacio = 0;
//            super.paint(g);
      
                
//                case 0:
//                    g.drawImage(Icono,this.getX(),this.getY(),this);
////                    g.drawImage(b.getImage(),b.getX()+7,b.getY(),this);
//                    Ship temp = rowBasic.getList().getHead();
//                    while(temp!= null){
//                        g.drawImage(rowBasic.getImageShip(),espacio,0,this);
//                        espacio+=40;
//                        temp = temp.getNext();
//                    }espacio = 0;
//                    break;
            }
        public void draw(BufferStrategy bs){
            
            do{
                do{
                    Graphics2D g = (Graphics2D) bs.getDrawGraphics();
                    g.setColor(Color.BLACK);
                    g.fillRect(0,0,800,1200);
                    
                    mainShip.draw(g);
                    mainShip.update();
                    basic.draw(this, g);
//                    basic.update();
                    
                    
//                    if(ff){
//                    ff=false;
//                    enemy.update(g,canvas);
//                    enemy.start();
//                    
//                    }
                    
                    g.dispose();
                    
                }while(bs.contentsRestored());
                bs.show();
            }while(bs.contentsLost());
                
        }
        public void update(double delta){
            
        }
                
            
           
           
            
            
        }
        


//    public class StartEnemy extends Thread{
//        
//    
//        private final AbstractFactory factory;;
////        private int high = 0, limit = 500;
//        private Graphics2D g;
//        private Canvas c;
//        private Basic rowBasic;
//
//        private ShipA rowA;
//        private ShipB rowB;
//        private ShipC rowC;
//        private ShipD rowD;
//        private ShipE rowE;
        
        
        
        
//        public StartEnemy(){
//   
//            this.factory = new AbstractFactory();
//            
//        }
//        public void update(Graphics2D g, Canvas canvas){
//            this. c = canvas;
//            this.g = g;
//           
//        }

//    @Override
//    public void run(){
//        System.out.println("StartEnemy");
//    
//  
//       
//        rowBasic = (Basic) factory.makeRowShips(0);
//        rowBasic.setGC(g,c);
//        rowBasic.start();
  

//        int randomNum = ThreadLocalRandom.current().nextInt(0, 7);
//        switch(randomNum){
//            case 0:
//                rowBasic = (Basic) factory.makeRowShips(randomNum);
//
//
//                break;
//            case 1:
//                rowA = (ShipA) factory.makeRowShips(randomNum);
//         
//                break;
//            case 2:
//                rowB = (ShipB) factory.makeRowShips(randomNum);
//             
//                break;
//            case 3:
//                rowC = (ShipC) factory.makeRowShips(randomNum);
//     
//                break;
//            case 4:
//                rowD = (ShipD) factory.makeRowShips(randomNum);
//          
//                break;
//            case 5:
//                rowE = (ShipE) factory.makeRowShips(randomNum);
//               
//                break;
//        }
//            }
//    
//    }

   
    
    

   
}
        
        
        
         
            

