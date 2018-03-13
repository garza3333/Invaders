/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;


import  java.awt.*;
import static java.awt.Color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author curso
 */
public class DataFrame {
    private final Image Icono = Toolkit.getDefaultToolkit().getImage("Images/startup.png");
    private final Image back = Toolkit.getDefaultToolkit().getImage("Images/background.jpg"); 
    private final Color fg = new Color(0,0,0);
    private final Color bg = new Color(255,172,117);
    private static final JFrame v = new JFrame();
    public DataFrame(boolean e){
        
        v.setResizable(false);
v.setUndecorated(true);
v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
v.setIconImage(Icono);
v.setSize(1000,550);
v.setLocationRelativeTo(null);
v.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4,BLACK));

JLabel dataBack= new JLabel(new ImageIcon(back));

dataBack.setLayout(new BoxLayout(dataBack,BoxLayout.Y_AXIS));


JButton menu = new JButton("Menu");
menu.setMaximumSize(new Dimension(100,50));
menu.setBackground(bg);
menu.setForeground(fg);
menu.setFocusPainted(false);
menu.setCursor(new Cursor(Cursor.HAND_CURSOR));
menu.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, BLACK));

menu.setAlignmentY(JButton.SOUTH);
menu.addActionListener(new Funcion());


v.add(dataBack);
dataBack.add(menu);
v.show(e);

    }
       public void show(boolean c){
        v.setVisible(c);
    }
       
        static class Funcion implements ActionListener{
           
           public void Funcion(){
              
           }

        @Override
        public void actionPerformed(ActionEvent e) {
            v.show(false);
        }
           
       }
    
    
}
