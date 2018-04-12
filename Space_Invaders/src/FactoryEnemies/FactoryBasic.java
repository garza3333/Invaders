
package FactoryEnemies;

import AbstractEnemy.Enemy_Basic;
import AbstractEnemy.Enemy;
import java.awt.Image;

/**
 *
 * @author Daniel
 */
public class FactoryBasic implements AbstractShip{

    @Override
    public Enemy createEnemy(Image i, int x, int y, int l, boolean b, int s,int id){
        Enemy_Basic e = new Enemy_Basic();
        e.init(i, x, y, l, b, s,id);
        return e;
    }
    
}
