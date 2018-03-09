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
public class DoublyLinkedList extends LinkedList{
    public DoublyLinkedList(){
        
    }
    /**
     * añade un nodo a la lista y los enlaza al anterior y al siguiente
     * @param n 
     */
    @Override
    public void add(Node n){
        this.ad(n);
    }
    
    
    
    
    
    
    
    
    
    private void ad(Node n){
        if(isEmpty()){
            this.head = n;
        }else{
            Node temp = this.head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(n);
            n.setPrevious(temp);
        }
    }
    
}
