
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;




/**
 *
 * @author Daniel
 */
public final class MainFrame extends Manager{
    
    private static final JFrame v = new JFrame();

    private final Image Icono = Toolkit.getDefaultToolkit().getImage("Images/startup.png");
    private final Image back = Toolkit.getDefaultToolkit().getImage("Images/background.jpg");
    
    private final Color fg = new Color(0,0,0);
    private final Color bg = new Color(255,172,117);
    private final Color titleC = new Color(0,0,0);
    private Font fontTitle,fontButton;
    private final Manager manager;
    
    /**
     * Constructor de la clase MainFrame y asigna valor al parametro manager
     * que es el objeto que administra todas las ventanas
     * @param g 
     */
    public MainFrame(Manager g){
        
        try 
        {
        fontTitle = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/District.ttf"));
        fontButton = Font.createFont(Font.TRUETYPE_FONT,new File("Fonts/virgo.ttf"));
        
        } 
        catch(Exception e) 
        {
            fontTitle = null;
        }
        this.manager = g;
        v.setTitle("Space Invaders");
        v.setFont(fontTitle);
        
        
        v.setResizable(false);
        v.setUndecorated(true);
        v.setIconImage(this.Icono);
        v.setSize(1000,550);
        v.setLocationRelativeTo(null);
        v.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4,BLACK));
        
        
        
        JLabel background = new JLabel(new ImageIcon(back));

        
        JLabel title = new JLabel("Space Invaders");
        title.setFont(this.fontTitle.deriveFont(Font.PLAIN,45));
        title.setForeground(titleC);

        title.setBounds(360,15,400,100);
        
        background.add(title);
        
        
        JLabel icon = new JLabel();
        icon.setIcon(new ImageIcon(("Images/astronave1.png")));

        icon.setBounds(550, 200, 250, 250);

        background.add(icon);

        
        
        
      JButton play= new JButton("Play");
      
      play.setForeground(fg);
      play.setBackground(bg);
      play.setFont(this.fontButton.deriveFont(Font.PLAIN,25));

      play.setBounds(0,115,400,80);
              
      play.setMaximumSize(new Dimension(300,100));
      play.setFocusPainted(false);
      play.setCursor(new Cursor(Cursor.HAND_CURSOR));
      play.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, BLACK));
      play.addActionListener(new Start());
      
      background.add(play);

      
      JButton data= new JButton("Data");
      
      data.setForeground(fg);
      data.setBackground(bg);
      data.setFont(this.fontButton.deriveFont(Font.PLAIN,25));

      data.setBounds(0,275,400,80);
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
      exit.setFont(this.fontButton.deriveFont(Font.PLAIN,25));

      exit.setBounds(0,425,400,80);
      exit.setMaximumSize(new Dimension(300,100));
      exit.setFocusPainted(false);
      exit.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
      exit.addActionListener(new Exit());
      exit.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, BLACK));
      background.add(exit);
      background.add(Box.createRigidArea(new Dimension(100,50)));
      background.add(exit);
      
      v.add(background);
      
      v.setVisible(true);
        
        
        
        
        
    }
       

    //Accion cerrar juego

     class Exit implements ActionListener
    {
         /**
          * Metodo que scierra el programa
          * @param e 
          */
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            System.exit(0);
        }

    }
     //Accion ventana de datos
     class Data implements ActionListener{

         /**
          * Metodo que llama a la ventana de datos
          * @param e 
          */
        @Override
        public void actionPerformed(ActionEvent e) {
           v.dispose();
           manager.show("data");
        }
        
    }
    //Accion ventana de usuario
     class Start implements ActionListener {

         /**
          * Metodo que llama a la ventana de usuario
          * @param e 
          */
        @Override
        public void actionPerformed(ActionEvent e) {
            v.dispose();
            manager.show("start");
            
        }
    
}

}
    
    
    

