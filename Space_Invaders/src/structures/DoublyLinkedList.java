
package structures;

/**
 *
 * @author Daniel
 */
public class DoublyLinkedList extends LinkedList{
    public DoublyLinkedList(){
        this.head = this.tail = null;
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
            this.head = this.tail = n;
        }else{
            Node temp = this.head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(n);
            n.setPrevious(temp);
            this.tail = n;
        }
        size++;
    }
    
    
}
