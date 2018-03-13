/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.awt.Color;
import static java.awt.Color.BLACK;
import java.awt.Cursor;
import java.awt.Dimension;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;




/**
 *
 * @author curso
 */
public final class MainFrame extends Manager{
    
    private static final JFrame v = new JFrame();
//    private Font font;
    private final Image Icono = Toolkit.getDefaultToolkit().getImage("Images/startup.png");
    private final Image back = Toolkit.getDefaultToolkit().getImage("Images/background.jpg");
    private final Color fg = new Color(0,0,0);
    private final Color bg = new Color(255,172,117);
    private Font fontTitle;
    
    public MainFrame(){
        
        try 
        {
        fontTitle = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/District.ttf"));
        
        } 
        catch(Exception e) 
        {
            fontTitle = null;
        }
        v.setTitle("Space Invaders");
        v.setFont(fontTitle);
        
        
//        v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        v.setLayout(new GridLayout());
        
        
        
        v.setResizable(false);
        v.setUndecorated(true);
        v.setIconImage(this.Icono);
        v.setSize(1000,550);
        v.setLocationRelativeTo(null);
        v.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4,BLACK));
        
        
        
        JLabel background = new JLabel(new ImageIcon(back));

        
        JLabel title = new JLabel("Space Invaders");
        title.setFont(this.fontTitle.deriveFont(Font.PLAIN,45));
        title.setForeground(Color.BLACK);

        title.setBounds(450,30,400,100);
        
        background.add(title);
        
        
        JLabel icon = new JLabel();
        icon.setIcon(new ImageIcon(("Images/astronave1.png")));

        icon.setBounds(550, 200, 250, 250);
//        icon.setLocation(350,50);
        background.add(icon);
        background.add(Box.createRigidArea(new Dimension(100,50)));
        
        
        
      JButton play= new JButton("Play");
      
      play.setForeground(fg);
      play.setBackground(bg);

      play.setBounds(100,80,200,100);
              
      play.setMaximumSize(new Dimension(300,100));
      play.setFocusPainted(false);
      play.setCursor(new Cursor(Cursor.HAND_CURSOR));
      play.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, BLACK));
      background.add(play);
      background.add(Box.createRigidArea(new Dimension(100,70)));
      
      JButton data= new JButton("Data");
      
      data.setForeground(fg);
      data.setBackground(bg);

      data.setBounds(100,260,200,100);
      data.setMaximumSize(new Dimension(300,100));
      data.setFocusPainted(false);
      data.setCursor(new Cursor(Cursor.HAND_CURSOR));
      data.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, BLACK));
      data.addActionListener(new Data());
      
      background.add(data);
      background.add(Box.createRigidArea(new Dimension(100,30)));
      
      JButton exit= new JButton("Exit");
      
      exit.setForeground(fg);
      exit.setBackground(bg);

      exit.setBounds(100,420,200,100);
      exit.setMaximumSize(new Dimension(300,100));
      exit.setFocusPainted(false);
      exit.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
      exit.addActionListener(new Exit());
      exit.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, BLACK));
      background.add(exit);
      background.add(Box.createRigidArea(new Dimension(100,50)));
      background.add(exit);
      
      v.add(background);
      
      
//      v.getContentPane().validate();
//      v.repaint();
      
      
      v.setVisible(true);
//      this.moveShip(icon);
        
        
        
        
        
    }
       
//        public void moveShip(JLabel label){
//            Thread t;
//        t = new Thread(() -> {
//            try{
//                while(true){
//                    
//                    for (int i=0; i<10; i++){
//                        label.setLocation((label.getLocationOnScreen().x+1), 0);
//                        Thread.sleep(100);
//                    }
//                    for(int i = 0 ; i<10 ; i++){
//                        label.setLocation((label.getLocationOnScreen().x-17),0);
//                        Thread.sleep(100);
//                    }
//                }
//            }catch(InterruptedException ae){
//                
//            }
//            });
//t.start();
//        }
        

    
    static class Exit implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            System.exit(0);
        }

    }
    static class Data extends Manager implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           v.dispose();
           this.show("data");
        }
        
    }

}
    
    
    

