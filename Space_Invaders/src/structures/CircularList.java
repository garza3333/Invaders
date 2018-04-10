
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
    public void add(Node n){
        this.ad(n);
    }
    
    
    
    
    
    
    
    
    private void ad(Node n){
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
