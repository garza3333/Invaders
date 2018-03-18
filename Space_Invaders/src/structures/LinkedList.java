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
public class LinkedList {
    protected int size;
    protected Ship head,tail;
    public LinkedList(){
        this.head = this.tail = null;
    }
    /**
     * Retorna true en caso de que head sea null , de lo contrario true
     * @return 
     */
    public boolean  isEmpty(){
        return this.head == null;
    }
    /**
     * añade un nuevo nodo a la lista
     * @param n nodo a añadir
     */
    public void add(Ship n){
        this.ad(n);
    }
    /**
     * Elimina un nodo de la lista dependiendo del id que tenga
     * @param n 
     */
    public void delete(Ship n){
        this.del(n);
    }
    /**
     * Retorna el atributo head de la lista 
     * @return 
     */
    public Ship getHead(){
        return this.head;
    }
    /**
     * Retorna el atributo tail de la lista
     * @return 
     */
    public Ship getTail(){
        return this.tail;
    }
    private void ad(Ship n){
        if(isEmpty()){
            this.head=this.tail = n;
        }else{
            
            this.tail.setNext(n);
            this.tail = n;
        }
        size++;
    }
    private void del(Ship n){
        Ship temp = this.head;
        while(temp.getNext() != null){
            if(temp.getNext().getId() == n.getId()){
                
                temp.setNext(temp.getNext().getNext());
                break;
            }
            temp = temp.getNext();
        }
    }
    
}
