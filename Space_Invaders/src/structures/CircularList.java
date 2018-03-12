/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

/**
 *
 * @author Daniel
 */
public class CircularList extends LinkedList{
    public CircularList(){
        this.head = this.tail = null;
    }
    /**
     * Añade un nodo a la lista y lo enlaza al head
     * @param n 
     */
    @Override
    public void add(Ship n){
        this.ad(n);
    }
    
    
    
    
    
    
    
    
    private void ad(Ship n){
        if(isEmpty()){
            this.head = this.tail = n;
    }else{
            this.tail.setNext(n);
            this.tail = n;
            tail.setNext(this.head);
        }
        this.size++;
    }
    
    
}
