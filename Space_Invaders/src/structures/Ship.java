
package structures;

import AbstractEnemy.Enemy;

/**
 *
    * @author Daniel
 */
public class Ship {
    private Ship next,previous;
    private final Enemy value;
    
 
    public Ship(Enemy e){
        this.value = e;
        this.next = this.previous = null;
      
        
        
    }
    /**
     * Enlaza un nodo a otro
     * @param n nodo a enlazar
     */
    public void setNext(Ship n){
        this.next = n;
    }
    /**
     * Retorna el nodo siguiente
     * @return 
     */
    public Ship getNext(){
        return this.next;
    }


    /**
     * Enlaza un nodo a un nodo anterior
     * @param n 
     */
    public void setPrevious(Ship n){
        this.previous = n;
    }
    /**
     * retorna el nodo anterior
     * @return 
     */
    public Ship getPrevious(){
        return this.previous;
    }
    
    public Enemy getValue(){
        return this.value;
    }

    
    
}
