/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryHilera;

import AbstractHilera.AbstractHilera;
import AbstractHilera.HileraB;
import java.awt.Canvas;
import java.awt.Graphics2D;

/**
 *
 * @author curso
 */
public class FactoryHileraB implements AbstractFactoryHilera{
   

    @Override
    public void init() {
  
    }

    @Override
    public AbstractHilera makeRow() {
        HileraB b = new HileraB();
        b.init();
        return b;
    }


    
}
