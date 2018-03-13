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
public class MainFrame extends Manager{
    
    private final JFrame v = new JFrame();
//    private Font font;
    private final Image Icono = Toolkit.getDefaultToolkit().getImage("Images/startup.png");
    private final Image back = Toolkit.getDefaultToolkit().getImage("Images/background.jpg");
    private final Color fg = new Color(0,0,0);
    private final Color bg = new Color(255,172,117);
    
    public MainFrame(boolean e){
        v.setTitle("Space Invaders");
        
        v.setResizable(false);
        v.setUndecorated(true);
        v.setIconImage(this.Icono);
        v.setSize(1000,550);
        v.setLocationRelativeTo(null);
        v.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4,BLACK));
        
        
        
        JLabel background = new JLabel(new ImageIcon(back));
        background.setLayout(new BoxLayout(background,BoxLayout.Y_AXIS));
        
        JLabel title = new JLabel("Space Invaders");
//        title.setFont(this.font.deriveFont(Font.PLAIN,80));
        title.setForeground(Color.BLACK);
        title.setAlignmentX(JLabel.CENTER);
        background.add(title);
        
        
        JLabel icon = new JLabel();
        icon.setIcon(new ImageIcon(("Images/astronave.png")));
        icon.setHorizontalAlignment(JLabel.CENTER);
        icon.setAlignmentX(JLabel.CENTER);
        background.add(icon);
        background.add(Box.createRigidArea(new Dimension(100,50)));
        
        
        
      JButton play= new JButton("Play");
      
      play.setForeground(fg);
      play.setBackground(bg);
      play.setAlignmentX(JButton.SOUTH);
      play.setMaximumSize(new Dimension(300,100));
      play.setFocusPainted(false);
      play.setCursor(new Cursor(Cursor.HAND_CURSOR));
      play.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, BLACK));
      background.add(play);
      background.add(Box.createRigidArea(new Dimension(100,70)));
      
      JButton data= new JButton("Data");
      
      data.setForeground(fg);
      data.setBackground(bg);
      data.setAlignmentX(JButton.SOUTH);
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
      exit.setAlignmentX(JButton.SOUTH);
      exit.setMaximumSize(new Dimension(300,100));
      exit.setFocusPainted(false);
      exit.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
      exit.addActionListener(new Exit());
      exit.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, BLACK));
      background.add(exit);
      background.add(Box.createRigidArea(new Dimension(100,50)));
      background.add(exit);
      
      v.add(background);
      v.show(e);
        
        
        
        
        
    }
    static class Exit implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            System.exit(0);
        }

    }
    static class Data implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           DataFrame d = new DataFrame(true);
        }
        
    }
    public void show(boolean c){
        v.setVisible(c);
    }
    
    
    
    
}
