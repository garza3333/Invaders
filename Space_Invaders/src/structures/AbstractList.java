/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import AbstractEnemy.Enemy;

/**
 *
 * @author Daniel
 */
public interface AbstractList {
    
    
    
    
    
    public int getSize();
    public boolean isEmpty();
    public void add(Node n);
    public void delete(int n);
    public void deleteAll();
    public Node getHead();
    public Node getTail();
    public Enemy findI(int i);
    
    
    
    
}
