
package structures;

import AbstractEnemy.Enemy;

/**
 *
 * @author Daniel
 */
public class LinkedList implements AbstractList{
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
    @Override
    public boolean  isEmpty(){
        return this.head == null;
    }
    /**
     * añade un nuevo nodo a la lista
     * @param n nodo a añadir
     */
    @Override
    public void add(Node n){
        this.ad(n);
    }
    /**
     * Elimina un nodo de la lista dependiendo del id que tenga
     * @param n 
     */
    @Override
    public void delete(int n){
        this.del(n);
    }
    /**
     * Retorna el atributo head de la lista 
     * @return 
     */
    @Override
    public Node getHead(){
        return this.head;
    }
    /**
     * Retorna el atributo tail de la lista
     * @return 
     */
    @Override
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
    @Override
    public int getSize(){
        return this.size;
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
    private void del(int n){
        
        int cont = 0;
        
        Node temp = this.head;
        while(temp != null){
            if(n==0)
            {
                this.head=temp.getNext();
                break;
            }else if(n == this.getSize()-1){
                
                System.out.println("ultimo");
                
                temp = this.getHead();
                
                while(temp.getNext() != this.tail){
                    temp = temp.getNext();
                }
                temp.setNext(null);
                this.tail = temp;
            }
            else if(cont+1 == n){
                temp.setNext(temp.getNext().getNext());
                break;
            }
            temp = temp.getNext();
            cont++;
        }
        size--;
    }



    
}
