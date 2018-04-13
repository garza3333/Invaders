
package FactoryHilera;

import AbstractHileras.AbstractHilera;


/**
 *
 * @author Daniel
 */
public interface AbstractFactoryHilera {
    
    public void init();
    
    public AbstractHilera makeRow(int h,int s);
    

    
  
    
}
