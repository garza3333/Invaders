
package Frames;


import  java.awt.*;
import static java.awt.Color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Daniel
 */
public final class DataFrame {
    private final Image Icono = Toolkit.getDefaultToolkit().getImage("Images/startup.png");
    private final Image back = Toolkit.getDefaultToolkit().getImage("Images/background.jpg"); 
    private final Color fg = new Color(0,0,0);
    private final Color bg = new Color(255,172,117);
    private static final JFrame v = new JFrame();
    private Font fontPlayers,fontButton;
    private final Manager manager;
    public DataFrame(Manager g){
        
                try 
        {
         fontPlayers = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/District.ttf"));
         fontButton = Font.createFont(Font.TRUETYPE_FONT,new File("Fonts/virgo.ttf"));
        
        } 
        catch(  FontFormatException | IOException e) 
        {
            fontPlayers = null;
        }
//        v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        v.setLayout(new GridLayout());
        this.manager = g;
        v.setResizable(false);
        v.setUndecorated(true);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setIconImage(Icono);
        v.setSize(1000,550);
        v.setLocationRelativeTo(null);
        v.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4,BLACK));

        JLabel dataBack= new JLabel(new ImageIcon(back));




        JButton menu = new JButton("Menu");
        menu.setMaximumSize(new Dimension(100,50));
        menu.setBackground(bg);
        menu.setForeground(fg);
        menu.setFocusPainted(false);
        menu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menu.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, BLACK));


        menu.setBounds(400,400, 200, 90);
        menu.addActionListener(new Funcion());

        JLabel players = new JLabel("Players");
        players.setBackground(bg);
        players.setForeground(fg);
        players.setFont(this.fontPlayers.deriveFont(Font.PLAIN,45));
        players.setBounds(150,50,400,100);
        
        JLabel scores = new JLabel("Scores");
        scores.setBackground(bg);
        scores.setForeground(fg);
        scores.setFont(this.fontPlayers.deriveFont(Font.PLAIN,45));
        scores.setBounds(650,50,400,100);


        v.add(dataBack);
        dataBack.add(players);
        dataBack.add(scores);
        dataBack.add(menu);
        
//        v.getContentPane().validate();
//        v.repaint();
        v.setVisible(true);


    }
      
        static class Funcion extends Manager implements ActionListener{
  
        @Override
        public void actionPerformed(ActionEvent e) {
            
            v.dispose();
            this.show("main");
        }
           
       }
    
    
}
