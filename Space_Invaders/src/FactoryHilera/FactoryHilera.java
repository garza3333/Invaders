
package FactoryHilera;

import AbstractHileras.ShipA;
import AbstractHileras.Basic;
import AbstractHileras.ShipC;
import AbstractHileras.ShipB;
import AbstractHileras.ShipD;
import AbstractHileras.ShipE;
import AbstractHileras.AbstractHilera;
import Frames.Manager;

/**
 *
 * @author Daniel
 */
public class FactoryHilera implements AbstractFactoryHilera{
 
    public FactoryHilera(){
        
    }
    @Override
    public AbstractHilera makeRow(int h,int s) {
        switch(h){
            case 1:
                Basic basic = new Basic();
                
                basic.init(s);
                
                return basic;                
                
            
            case 2:
                ShipA a = new ShipA();
              
                a.init(s);
                
                return a;                
              
         
            case 3:
                ShipB b = new ShipB();
                
                b.init(s);
                
                return b;                
           
            case 4:
                ShipC c = new ShipC();
                c.init(s);
               
                return c;
                
           
            case 5:
                ShipD d = new ShipD();
                d.init(s);
                
                return d;                
                
           
            case 6:
                ShipE e = new ShipE();
                e.init(s);
                
                return e;                
             
        }

        return null;
    }   
}
