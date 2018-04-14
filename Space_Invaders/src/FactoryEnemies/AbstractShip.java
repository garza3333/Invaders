
package FactoryEnemies;

import AbstractEnemy.Enemy;
import java.awt.Image;

/**
 *
 * @author Daniel
 */
public interface AbstractShip {
    /**
     * Crea un objeto Enemy y activa el metodo init del objeto para posteriormente
     * asignar los valores que estan en los parametros al objeto Enemy
     * @param i Imagen del objeto
     * @param x posicion x del objeto
     * @param y posicion y del objeto 
     * @param l cantidad de vida del objeto
     * @param b bandera para diferenciar jefes
     * @return 
     */
    public Enemy createEnemy(Image i, int x, int y, int l, boolean b);
    
}
