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
    
    
    
    
    /**
     * Retorna el atroibuto size de la lista
     * 
     * @return valor entero
     */
    public int getSize();
    /**Retorna un true si el head de la lista es null
     * 
     * @return boolean
     */
    public boolean isEmpty();
    /**
     * Añade un nuevo nodo a la lista enlazada
     * @param n nodo a enlazar
     */
    public void add(Node n);
    /**
     * Elimina un Nodo de la lista enlazada , buscandolo con el indice "n"
     * @param n indice para buscar el nodo en la lista
     */
    public void delete(int n);
    /**
     * Hace que el nodo head de la lista enlazada apunte a nulo
     */
    public void deleteAll();
    /**
     * Retorna el nodo que esta referenciado como cabeza de la lista
     * @return nodo head de la lista
     */
    public Node getHead();
    /**
     * Retorna el nodo que esta referenciado como cola de la lista
     * @return nodo tail de la lista
     */
    public Node getTail();
    /**
     * Metodo que busca un nodo dentro de la lista dependiendo del indice "i"
     * y retorna el valor dentro del nodo que es de tipo Enemy
     * @param i indice a buscar en la lista
     * @return 
     */
    public Enemy findI(int i);
    
    
    
    
}
