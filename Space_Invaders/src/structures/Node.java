
package structures;

import AbstractEnemy.Enemy;

/**
 *
    * @author Daniel
 */
public class Node {
    private Node next,previous;
    private final Enemy value;
    
 
    public Node(Enemy e){
        this.value = e;
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
    
    public Enemy getValue(){
        return this.value;
    }

    
    
}
