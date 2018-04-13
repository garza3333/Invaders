
package FactoryEnemies;

import AbstractEnemy.Enemy;
import java.awt.Image;

/**
 *
 * @author Daniel
 */
public interface AbstractShip {
    
    public Enemy createEnemy(Image i, int x, int y, int l, boolean b);
    
}
