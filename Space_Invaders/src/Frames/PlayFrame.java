
package Frames;



import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import structures.*;
import Frames.AbstractFactory.*;

/**
 *
 * @author Daniel
 */
public class PlayFrame{

    private final Image Icono = Toolkit.getDefaultToolkit().getImage("Images/startup.png");
    private final JFrame v = new JFrame();
    private Color bg;
    private Font fontTitle;
    
    
    
    public PlayFrame(){
        this.bg = new Color(120,120,114);
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
        
        
        
        myCanvas canvas = new myCanvas();

        
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

        fondo.setPreferredSize(new Dimension(800,1000));
        fondo.setBackground(this.bg);
 
        fondo.add(canvas);
        
        
        
        

        
        
        v.add(fondo,BorderLayout.WEST);
        v.add(controlPanel,BorderLayout.EAST);
        v.repaint();
        
        v.setVisible(true);
        
    }
    
    private class myCanvas extends JComponent{
        private final Image Icono = Toolkit.getDefaultToolkit().getImage("Images/spaceship64bits.png");
        
        private  int shipX = 200;  //384 limite derecho //200 pos nave
        private final int shipY = 250; // limite de naves enemigas //500 en y
        private int flag = -2;
        private Bullet b;
        
        private Basic rowBasic;
        private ShipA rowA;
        private ShipB rowB;
        private ShipC rowC;
        private ShipD rowD;
        private ShipE rowE;
        
        public myCanvas(){
        
            setPreferredSize(new Dimension(800,1000));
//            setBounds(0,0,800,100);

            addKeyListener(new Key());
            
            setFocusable(true);
            
            setVisible(true);
//            setOpaque(true);
        }
        @Override
        public void paint(Graphics g){
            int espacio = 0;
            super.paint(g);
            switch(flag){
                
                case -1:
                
                    g.drawImage(Icono,this.getX(),this.getY(),this);
                    g.drawImage(b.getImage(),b.getX()+7,b.getY(),this);
                    break;
                
                case -2:
                    g.drawImage(Icono,this.getX(),this.getY(),this);
                    
                    break;
                
                case 0:
                    g.drawImage(Icono,this.getX(),this.getY(),this);
//                    g.drawImage(b.getImage(),b.getX()+7,b.getY(),this);
                    Ship temp = rowBasic.getList().getHead();
                    while(temp!= null){
                        g.drawImage(rowBasic.getImageShip(),espacio,0,this);
                        espacio+=40;
                        temp = temp.getNext();
                    }espacio = 0;
                    break;
            }
            
           
           
            
            
        }
        
        @Override
        public int getX(){
            return this.shipX;
        }
        @Override
        public int getY(){
            return this.shipY;
        }
        public void setX(int x){
            this.shipX += x;
        }
        
        
        
        
         class Key implements KeyListener{
            

            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_RIGHT:
                       Thread r;
                       r = new Thread( () ->{
                           if(getX() <= 379){
                               setX(5);}
                           repaint();
                       });
                        r.start();
                        break;
                    
                        
                       
                    case KeyEvent.VK_LEFT:
                       Thread l;
                       l = new Thread(() ->{
                        if(getX() >= 6){
                        setX(-5);}
                        revalidate();
                        repaint(); });
                       l.start();
                        break;
                    case KeyEvent.VK_SPACE:
                        Shoot s = new Shoot();
                        s.start();
                        Start start = new Start();
                        start.start();
                     
                        break;
                        
                    default:
                        break;
                }}

            @Override
            public void keyReleased(KeyEvent e) {
                
            }


         }
         class Shoot extends Thread{
             @Override
             public void run(){
                
                Bullet x = new Bullet();
                b = x;
                b.setX(getX());
                flag = -1;
                while(b.getY() != b.getposY2()){
                    b.setY(-5);
                    repaint();
                    try {
                        Shoot.sleep(20);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PlayFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    revalidate();
                    repaint();
                                                      
                    }
             }
         }
         
    
    
    public class Start extends Thread{
        private final AbstractFactory factory;;

        
        
        
        public Start(){
            this.factory = new AbstractFactory();
            
        }
    @Override
    public void run(){
        rowBasic = (Basic) factory.makeRowShips(0);
        flag = 0;
//        int randomNum = ThreadLocalRandom.current().nextInt(0, 7);
//        switch(randomNum){
//            case 0:
//                rowBasic = (Basic) factory.makeRowShips(randomNum);
//                flag = 0;
//
//                break;
//            case 1:
//                rowA = (ShipA) factory.makeRowShips(randomNum);
//                flag = 1;
//                break;
//            case 2:
//                rowB = (ShipB) factory.makeRowShips(randomNum);
//                flag = 2;
//                break;
//            case 3:
//                rowC = (ShipC) factory.makeRowShips(randomNum);
//                flag = 3;
//                break;
//            case 4:
//                rowD = (ShipD) factory.makeRowShips(randomNum);
//                flag = 4;
//                break;
//            case 5:
//                rowE = (ShipE) factory.makeRowShips(randomNum);
//                flag = 5;
//                break;
//        }
        
        
        
         
            }
        }
    
    }

   
    
    

   
}
