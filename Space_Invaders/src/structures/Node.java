/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

/**
 *
 * @author curso
 */
public class Node {
    Node next,previous;
    int life;
    int id;
    boolean boss;
    public Node(){
        this.next = this.previous = null;
        
    }
    /**
     * Enlaza un nodo a otro
     * @param n nodo a enlazar
     */
    public void setNext(Node n){
        this.next = n;
    }
    /**
     * Retorna el nodo siguiente
     * @return 
     */
    public Node getNext(){
        return this.next;
    }
    /**
     * Retorna el atributo lfe
     * @return 
     */
    public int getLife(){
        return this.life;
    }
    /**
     * Cambia el valor del atributo boss a true
     */
    public void setBoss(){
        this.boss = true;
    }
    /**
     * Retorna el valor del atributo id;
     * @return 
     */
    public int getId(){
        return this.id;
    }
    /**
     * Enlaza un nodo a un nodo anterior
     * @param n 
     */
    public void setPrevious(Node n){
        this.previous = n;
    }
    /**
     * retorna el nodo anterior
     * @return 
     */
    public Node getPrevious(){
        return this.previous;
    }
    
    
}
