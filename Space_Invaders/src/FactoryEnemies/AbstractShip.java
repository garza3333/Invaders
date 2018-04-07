/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryEnemies;

import AbstractEnemy.Enemy;
import java.awt.Image;

/**
 *
 * @author curso
 */
public interface AbstractShip {
    
    public Enemy createEnemy( int x, int y, int l, boolean b, int s,int id);
    
}
