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
    int size;
    Node head;
    public LinkedList(){
        
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
    public void add(Node n){
        this.ad(n);
    }
    /**
     * Elimina un nodo de la lista dependiendo del id que tenga
     * @param n 
     */
    public void delete(Node n){
        this.del(n);
    }
    /**
     * Retorna el nodo head de la lista que es el primer elemento
     * @return 
     */
    public Node getHead(){
        return this.head;
    }
    
    
    
    
    
    
    
    private void ad(Node n){
        if(isEmpty()){
            this.head = n;
        }else{
            Node temp = this.head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }temp.setNext(n);
        }
        size++;
    }
    private void del(Node n){
        Node temp = this.head;
        while(temp.getNext().getId() != n.getId()){
            temp = temp.getNext();
        }temp.setNext(temp.getNext().getNext());
    }
    
}
