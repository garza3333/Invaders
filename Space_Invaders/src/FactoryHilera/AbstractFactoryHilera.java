/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryHilera;

import AbstractHilera.AbstractHilera;


/**
 *
 * @author Daniel
 */
public interface AbstractFactoryHilera {
    
    public void init();
    
    public AbstractHilera makeRow(String h);
    

    
  
    
}
