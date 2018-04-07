/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryEnemies;

import AbstractEnemy.Basic;
import AbstractEnemy.Enemy;
import FactoryEnemies.AbstractShip;
import java.awt.Image;

/**
 *
 * @author curso
 */
public class FactoryBasic implements AbstractShip{

    @Override
    public Enemy createEnemy( int x, int y, int l, boolean b, int s,int id){
        Basic e = new Basic();
        e.init( x, y, l, b, s,id);
        return e;
    }
    
}
