
package FactoryHilera;

import AbstractHileras.AbstractHilera;


/**
 *
 * @author Daniel
 */
public interface AbstractFactoryHilera {
    
    
    /**
     * Crea un objeto entre los 6 tipos diferentes dependiendo del parametro "h"
     * y le asigna un valor "s" al atributo speed de la hilera creada
     * @param h numero que identifica el  tipo de hilera a crear
     * @param s velocidad con la que el thread se va a ejecutar
     * @return 
     */
    public AbstractHilera makeRow(int h,int s);
    

    
  
    
}
