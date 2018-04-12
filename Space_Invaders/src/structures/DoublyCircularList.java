
package structures;

/**
 *
 * @author Daniel
 */
public class DoublyCircularList extends LinkedList{
    public DoublyCircularList(){
        this.head = this.tail = null;
    }
    /**
     * Añade un nodo a la lista , lo enlaza al anterior y al head
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
            n.setPrevious(this.tail);
            this.tail = n;
            tail.setNext(this.head);
            this.head.setPrevious(this.tail);
        }
        
        size++;
    }
        
}
