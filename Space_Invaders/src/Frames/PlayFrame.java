/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;


import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class PlayFrame{
    private final Image spaceground = Toolkit.getDefaultToolkit().getImage("Images/stars.png");
    private final Image Icono = Toolkit.getDefaultToolkit().getImage("Images/startup.png");
    private final JFrame v = new JFrame();
  
    private Font fontTitle;
    
    
    
    public PlayFrame(){
 try {
        fontTitle = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/District.ttf"));
        
        
        } 
        catch(Exception e) 
        {
            fontTitle = null;
        }
        
        v.setTitle("Space Invaders");
//        v.setFont(fontTitle);
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
        fondo.setBackground(Color.WHITE);
        fondo.add(canvas);
        
        
        
        JLabel space = new JLabel(new ImageIcon(spaceground));
        
        
        v.add(fondo,BorderLayout.WEST);
        v.add(controlPanel,BorderLayout.EAST);
        v.repaint();
        v.setVisible(true);
        
    }
    
    private class myCanvas extends JComponent{
        private final Image Icono = Toolkit.getDefaultToolkit().getImage("Images/spaceship.png");
        private  int shipX = 200;  //384 limite derecho //200 pos nave
        private final int shipY = 250; // limite de naves enemigas //500 en y
        private boolean flag = false;
        private Bullet b;
        public myCanvas(){
        
        setPreferredSize(new Dimension(800,1000));
        addKeyListener(new Key());
        setFocusable(true);
        setVisible(true);
        }
        @Override
        public void paint(Graphics g){
            
            super.paint(g);
            if(flag){
                System.out.println("paint1");
            g.drawImage(Icono,this.getX(),this.getY(),this);
            g.drawImage(b.getImage(),b.getX()+7,b.getY(),this);
            }else{
                System.out.println("paint2");
                g.drawImage(Icono,this.getX(),this.getY(),this);
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
                        System.out.println("derecha");
                        if(getX() <= 379){
                        setX(5);}
                        repaint();
                        
                        break;
                    case KeyEvent.VK_LEFT:
                        System.out.println("izquierda");
                        if(getX() >= 6){
                        setX(-5);}
                        revalidate();
                        repaint(); 
                        break;
                    case KeyEvent.VK_SPACE:
                        Shoot s = new Shoot();
                        s.start();
                      
                         

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
                System.out.println("space");
                Bullet x = new Bullet();
                b = x;
                b.setX(getX());
                flag = true;
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
         
    }

   
    
    

   
}
