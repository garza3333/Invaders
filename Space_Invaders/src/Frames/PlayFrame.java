
package Frames;




import AbstractHileras.AbstractHilera;
import FactoryHilera.FactoryHilera;
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

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;

/**
 *
 * @author Daniel
 */
public class PlayFrame{

    private final Image Icono = Toolkit.getDefaultToolkit().getImage("Images/startup.png");
    private final JFrame v = new JFrame();
    private Color bg;
    private Font fontTitle;
    public  final myCanvas canvas;
    private final Manager manager;
    
    private final JLabel current;
    private final JLabel currentImage;
    
    private final JLabel next;
    private final JLabel nextImage;
    
    private final JLabel level;
    private final JLabel score;
    
    
    
    public PlayFrame(Manager g){
        this.bg = new Color(0,0,0);
 try {
        fontTitle = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/District.ttf"));
        
        
        } 
        catch(FontFormatException | IOException e) 
        {
            fontTitle = null;
        }
        
        this.manager = g;
        v.setTitle("Space Invaders");

        v.setResizable(false);
        v.setUndecorated(true);
        v.setIconImage(this.Icono);
        v.setSize(1000,550);
        v.setLocationRelativeTo(null);
        
        v.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4,BLACK));
        
        
        
        

        
        JPanel controlPanel = new JPanel(); 
        controlPanel.setLayout(new BoxLayout(controlPanel,BoxLayout.Y_AXIS));
        controlPanel.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4,BLUE));
        controlPanel.setPreferredSize(new Dimension(193,548));
        controlPanel.setBackground(Color.BLACK);
        
        
        
        JLabel lblscore = new JLabel("Score");
        lblscore.setFont(this.fontTitle.deriveFont(Font.PLAIN,20));
        lblscore.setForeground(Color.WHITE);
        lblscore.setBounds(70,10,200,70);
        
        score = new JLabel("0");
        score.setFont(this.fontTitle.deriveFont(Font.PLAIN,20));
        score.setForeground(Color.WHITE);
        score.setBounds(70,60,200,70);
        
        
        JLabel lblcurrent = new JLabel("current");
        lblcurrent.setFont(this.fontTitle.deriveFont(Font.PLAIN,20));
        lblcurrent.setForeground(Color.WHITE);
        lblcurrent.setBounds(70,120,200,70);
        
        
        current = new JLabel("0");
        current.setFont(this.fontTitle.deriveFont(Font.PLAIN,20));
        current.setForeground(Color.WHITE);
        current.setBounds(70,120,200,70);
        
        currentImage = new JLabel();
        currentImage.setFont(this.fontTitle.deriveFont(Font.PLAIN,20));
        currentImage.setForeground(Color.WHITE);
        currentImage.setBounds(70,120,200,70);
        
        
        JLabel lblNext = new JLabel("Next");
        lblNext.setFont(this.fontTitle.deriveFont(Font.PLAIN,20));
        lblNext.setForeground(Color.WHITE);
        lblNext.setBounds(70,120,200,70);
        
        
        next = new JLabel("0");
        next.setFont(this.fontTitle.deriveFont(Font.PLAIN,20));
        next.setForeground(Color.WHITE);
        next.setBounds(70,120,200,70);
        
        nextImage = new JLabel();
        nextImage.setFont(this.fontTitle.deriveFont(Font.PLAIN,20));
        nextImage.setForeground(Color.WHITE);
        nextImage.setBounds(70,120,200,70);        
        
        
        JLabel lblLevel = new JLabel("Level");
        lblLevel.setFont(this.fontTitle.deriveFont(Font.PLAIN,20));
        lblLevel.setForeground(Color.WHITE);
        lblLevel.setBounds(70,120,200,70);
        
        
        level = new JLabel("0");
        level.setFont(this.fontTitle.deriveFont(Font.PLAIN,20));
        level.setForeground(Color.WHITE);
        level.setBounds(70,120,200,70);
        
        
        controlPanel.add(Box.createRigidArea(new Dimension(50,50)));
        controlPanel.add(lblscore);
        controlPanel.add(score);
        controlPanel.add(Box.createRigidArea(new Dimension(50,50)));
        controlPanel.add(lblcurrent);  
        controlPanel.add(current);
        controlPanel.add(currentImage);
        controlPanel.add(Box.createRigidArea(new Dimension(50,50)));
        controlPanel.add(lblNext);
        controlPanel.add(next);
        controlPanel.add(nextImage);
        controlPanel.add(Box.createRigidArea(new Dimension(50,50)));
        controlPanel.add(lblLevel);
        controlPanel.add(level);
        
        JPanel fondo = new JPanel();

        fondo.setPreferredSize(new Dimension(800,1200));
        fondo.setBackground(this.bg);
        
        
        canvas = new myCanvas();
        fondo.add(canvas);
        
        
        
        

        
        
        v.add(fondo,BorderLayout.WEST);
        v.add(controlPanel,BorderLayout.EAST);
        v.repaint();
        
        v.setVisible(true);
        canvas.start();
        
        
    }
    public myCanvas getCanvas(){
        return this.canvas;
    }
    
    public class myCanvas extends Canvas implements Runnable{
     
        private final FactoryHilera factory;
        AbstractHilera currentHilera,nextHilera;
        private final  MainShip mainShip;
        private boolean running;
        private Thread thread;
        
       
        
        public myCanvas(){
            
            
            this.setPreferredSize(new Dimension(800,1200));
            this.running = false;

            mainShip = new MainShip(this,manager);
            
            
            factory = new FactoryHilera();
            currentHilera = factory.makeRow(1);
            nextHilera = factory.makeRow(ThreadLocalRandom.current().nextInt(1,7));
            
            current.setText(currentHilera.getType());
            currentImage.setIcon(new ImageIcon(currentHilera.getList().getHead().getValue().getImage()));
            next.setText(nextHilera.getType());
            nextImage.setIcon(new ImageIcon(nextHilera.getList().getHead().getValue().getImage()));
            

           
            addKeyListener(mainShip);
            setFocusable(true);
            
            setVisible(true);

        }
        public MainShip getMainShip(){
            return this.mainShip;
        }
        public AbstractHilera getCurrentHilera(){
            return this.currentHilera;
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
            
            
            while(running){
                

                this.draw(bs);
            }
            

            }
        public void draw(BufferStrategy bs){
            
            do{
                do{
                    Graphics2D g = (Graphics2D) bs.getDrawGraphics();
                    g.setColor(Color.BLACK);
                    g.fillRect(0,0,800,1200);
                    
                    mainShip.draw(g);
                    mainShip.update();
                    
                    if(currentHilera.getList().isEmpty()){
           
                        currentHilera = nextHilera;
                        nextHilera = factory.makeRow(ThreadLocalRandom.current().nextInt(1,7));
                        current.setText(currentHilera.getType());
                        currentImage.setIcon(new ImageIcon(currentHilera.getList().getHead().getValue().getImage()));
                        next.setText(nextHilera.getType());
                        nextImage.setIcon(new ImageIcon(nextHilera.getList().getHead().getValue().getImage()));
                        
                    }else{
                    currentHilera.draw(this, g);}
                    
                    
                    
                    g.dispose();
                    
                }while(bs.contentsRestored());
                bs.show();
            }while(bs.contentsLost());
                
        }
        public void update(double delta){
            
        }
                
            
           
           
            
            
        }
        


   
}
        
        
        
         
            

