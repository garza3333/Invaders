
package FactoryHilera;

import AbstractHileras.ShipA;
import AbstractHileras.Basic;
import AbstractHileras.ShipC;
import AbstractHileras.ShipB;
import AbstractHileras.ShipD;
import AbstractHileras.ShipE;
import AbstractHileras.AbstractHilera;

/**
 *
 * @author Daniel
 */
public class FactoryHilera implements AbstractFactoryHilera{
   

    @Override
    public void init() {
  
    }

    @Override
    public AbstractHilera makeRow(int h) {
        switch(h){
            case 1:
                Basic basic = new Basic();
                basic.init();
                return basic;                
                
            
            case 2:
                ShipA a = new ShipA();
                a.init();
                return a;                
              
         
            case 3:
                ShipB b = new ShipB();
                b.init();
                return b;                
           
            case 4:
                ShipC c = new ShipC();
                c.init();
                return c;
                
           
            case 5:
                ShipD d = new ShipD();
                d.init();
                return d;                
                
           
            case 6:
                ShipE e = new ShipE();
                e.init();
                return e;                
             
        }

        return null;
    }   
}
