/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryHilera;

import AbstractHilera.AbstractHilera;
import AbstractHilera.*;

/**
 *
 * @author Daniel
 */
public class FactoryHilera implements AbstractFactoryHilera{
   

    @Override
    public void init() {
  
    }

    @Override
    public AbstractHilera makeRow(String h) {
        switch(h){
            case "Basic":
                Basic basic = new Basic();
                basic.init();
                return basic;                
                
            
            case "ShipA":
                ShipA a = new ShipA();
                a.init();
                return a;                
              
         
            case "ShipB":
                ShipB b = new ShipB();
                b.init();
                return b;                
           
            case "ShipC":
                ShipC c = new ShipC();
                c.init();
                return c;
                
           
            case "ShipD":
                ShipD d = new ShipD();
                d.init();
                return d;                
                
           
            case "ShipE":
                ShipE e = new ShipE();
                e.init();
                return e;                
             
        }

        return null;
    }   
}
