
package structures;

/**
 *
    * @author Daniel
 */
public class Ship {
    private Ship next,previous;
    private int life,id;
    private boolean boss;
 
    public Ship(int i){
        
        this(i,1);
        
    }
    public Ship(int i , int l){
        this.next = this.previous = null;
        this.id = i;
        this.life = l;
        
        
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
     * Retorna el atributo life
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

    
    
}
