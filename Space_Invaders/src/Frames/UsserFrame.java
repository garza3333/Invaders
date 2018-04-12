
package Frames;

import java.awt.Color;
import static java.awt.Color.BLACK;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Daniel
 */
public class UsserFrame{
    private final Image Icono = Toolkit.getDefaultToolkit().getImage("Images/startup.png");
    private static final JFrame v = new JFrame();
    private final Color fg = new Color(0,0,0);
    private final Color bg = new Color(255,172,117);
    private final Image back = Toolkit.getDefaultToolkit().getImage("Images/background.jpg");
    private Font fontTitle,fontButton;  
    private Manager manager;
    
    public UsserFrame(Manager g){
        try {
        fontTitle = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/District.ttf"));
        fontButton = Font.createFont(Font.TRUETYPE_FONT,new File("Fonts/virgo.ttf"));
        
        } 
        catch(FontFormatException | IOException e) 
        {
            fontTitle = null;
        }
        
        
        this.manager = g;
        v.setTitle("Usser");
        v.setFont(fontTitle);
        
        
        
        
        v.setResizable(false);
        v.setUndecorated(true);
        v.setIconImage(this.Icono);
        v.setSize(1000,550);
        v.setLocationRelativeTo(null);
        v.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4,BLACK));
        
        
        
        JLabel background = new JLabel(new ImageIcon(back));

        
        JLabel title = new JLabel("Pilot Ship");
        title.setFont(this.fontTitle.deriveFont(Font.PLAIN,45));
        title.setForeground(Color.BLACK);
        title.setBounds(360,30,400,100);
        
        background.add(title);
        
        
        
        
        JLabel icon = new JLabel();
        icon.setIcon(new ImageIcon(("Images/astronave1.png")));
        icon.setBounds(410, 160, 250, 250);
      
        background.add(icon);
        
        JButton menu = new JButton();
        menu.setText("Menu");
        menu.setForeground(fg);
        menu.setBackground(bg);
        menu.setBounds(150,260,200,100);
        menu.setMaximumSize(new Dimension(300,100));
        menu.setFocusPainted(false);
        menu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menu.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, BLACK));
        menu.addActionListener(new Menu());
        
        background.add(menu);
        
        
        
        JButton start = new JButton();
        start.setText("¡Start!");
        start.setForeground(fg);
        start.setBackground(bg);
        start.setBounds(600,260,200,100);
        start.setMaximumSize(new Dimension(300,100));
        start.setFocusPainted(false);
        start.setCursor(new Cursor(Cursor.HAND_CURSOR));
        start.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, BLACK));
        start.addActionListener(new Play());
        
        background.add(start);
        
        JLabel lblName = new JLabel("Pilot Name");
        lblName.setFont(this.fontTitle.deriveFont(Font.PLAIN,20));
        lblName.setForeground(Color.BLACK);
        lblName.setBounds(420,415,300,80);
        
        background.add(lblName);
        
        
        JTextField usserName = new JTextField(12);
        usserName.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, BLACK));
        usserName.setBounds(400,400,150,30);
        
        background.add(usserName);
        
        
        v.add(background);
        v.setVisible(true);
        
        
        
        
        
    }
    
    
        static class Menu extends Manager implements ActionListener{
  
        @Override
        public void actionPerformed(ActionEvent e) {
            
            v.dispose();
            this.show("main");
        }
        
           
       }
        
       static class Play extends Manager implements ActionListener{
           @Override
           public void actionPerformed(ActionEvent e){
               v.dispose();
               this.show("play");
           }
       }

        
    
    
    
    
}
