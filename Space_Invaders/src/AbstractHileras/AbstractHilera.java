
package AbstractHileras;

import java.awt.Canvas;
import java.awt.Graphics2D;
import structures.AbstractList;

/**
 *
 * @author curso
 */
public interface AbstractHilera {
    
    /**
     * Otorga valor al atributo speed de la hilera
     * @param s valor de la velocidad
     */
    public void init(int s);
    /**
     * Asigna valor al atributo x de la hilera
     * @param x 
     */
    public void setPosX(int x);
    /**
     * Asigna valor al atributo y de la hilera
     * @param y 
     */
    public void setPosY(int y);

    /**
    * Retotorna la posicion general de la hilera para saber si ha tocado el borde
    * de la pantalla
    * @return atributo de posicion y de la hilera
    */
    public int getPosY();
     /**
     * Retorna el atributo list de la hilera
     * @return lista enlazada
     */
    public AbstractList getList();

    /**
     * Activa el metodo delete del atributo list de la hilera
     * @param i indice a ser eliminado en la lista
     */
    public void destroy(int i);
    /**
     * Activa el metodo deleteAll del atributo list, que convierte el head en null
     */
    public void destroyAll();
    /**
     * Retorna un string con el nombre del tipo de hilera
     * @return 
     */
    public String getType();
    /**
     * Crea un indice aleatorio entre 0 y el len de la lista, lo busca y le
     * asigna true al atributo boss del objeto dentro del nodo
     */
    public void changeBoss();
    /**
     * Acorta las posiciones en x de los enemigos para que la hilera se una
     * cuando se elimina un enemigo
     * @param i 
     */
    
    public void center(int i);
    /**
     * Dibuja cada objeto Enemy dentro del atributo list de la hilera
     * @param c canvas en el cual dibujar
     * @param g objeto encargado de dibujar
     */
    public void draw(Canvas c , Graphics2D g);
   
    
    /**
     * Realiza el movimiento vertical y horizontal de todos los enemigos dentro 
     * del atributo list 
     */
    public void down();
    
    
    
   
    
}
