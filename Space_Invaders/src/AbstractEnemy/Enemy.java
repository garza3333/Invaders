
package AbstractEnemy;

import java.awt.Image;


/**
 *
 * @author Daniel
 */
public interface Enemy {
    
    /**
     * Metodo que asigna los valores a los atributos del objeto Enemy
     * @param image imagen del objeto enemigo
     * @param x posicion x del objeto
     * @param y posicion y del objeto
     * @param l cantidad de vida del objeto
     * @param b bandera para saber si el enemigo es jefe
     */
    public void init(Image image, int x , int y, int l ,boolean b);
    
    /**
     * Asigna valor al atributo life
     * @param l cantidad de vida
     */
    public void setLife(int l);
    
    /**
     * Asigna un valor al atributo x(posicion) del objeto 
     * @param x posicion x
     */
    public void setX(int x);
    /**
     * Asigna valor all atributo y(posicion) del objeto
     * @param y posicion y 
     */
    public void setY(int y);
    
    /**
     * Asigna un valor booleano al atributo boss del objeto
     * @param b valor booleano true -false
     */
    
    public void setBoss(boolean b);
    
    
    /**
     * Asigna la imagen al objeto 
     * @param i immagen a asignar
     */
    public void setImage(Image i);
  
    
    
    
    
    
    
    
    /**
     * Eetorna la posicion en x del objeto
     * @return 
     */
    public int getX();
    /**
     * Retorna la posicion y del objeto
     * @return 
     */
    public int getY();
    /**
     * Retorna el atributo life del objeto
     * @return 
     */
    public int getLife();
    /**
     * Retorna true si el atributo boss del objeto es true
     * @return 
     */
    public boolean isBoss();
   /**
    * Retorna el atributo con la imagen del objeto
    * @return 
    */
    public Image getImage();
    
    
    
    
    
    
}
