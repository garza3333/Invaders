
package structures;

/**
 *
 * @author Daniel
 */
public class LinkedList {
    protected int size,posX,posY;
    protected Node head,tail;
    public LinkedList(){
        this.head = this.tail = null;
        this.posX = this.posY = 0;
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
     * Retorna el atributo head de la lista 
     * @return 
     */
    public Node getHead(){
        return this.head;
    }
    /**
     * Retorna el atributo tail de la lista
     * @return 
     */
    public Node getTail(){
        return this.tail;
    }
    
    
    
    public int getPosX(){
        return this.posX;
    }
    public int getPosY(){
        return this.posY;
    }
    public void setPosX(int x){
        this.posX = x;
    }
    public void setPosY(int y){
        this.posY = y;
    }
    
    
    
    private void ad(Node n){
        if(isEmpty()){
            this.head=this.tail = n;
        }else{
            
            this.tail.setNext(n);
            this.tail = n;
        }
        size++;
    }
    private void del(Node n){
        Node temp = this.head;
        while(temp.getNext() != null){
            if(temp.getNext().getValue().getID() == n.getValue().getID()){
                
                temp.setNext(temp.getNext().getNext());
                break;
            }
            temp = temp.getNext();
        }
    }
    
}
