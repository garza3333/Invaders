
package structures;

/**
 *
 * @author Daniel
 */
public class BulletList{
    private NodeBullet t,h;
    
    public BulletList(){
        t = h = null;
    }
    
    public void add(Object o){
        this.ad(o);
    }
    public NodeBullet deleteFirst(){
        return this.deleteF();
    }
    public NodeBullet getHead(){
            return this.h;
        }
    public boolean isEmpty(){
        return this.h == null;
    }

    
    

    private void ad(Object o){
        if(isEmpty()){
            
            this.t = h = new NodeBullet(o);
        }else{
            NodeBullet n = new NodeBullet(o);
            this.t.setNext(n);
            this.t = n;
        }
   
    } 
    private NodeBullet deleteF(){
        NodeBullet current = this.h;
        this.h = current.getNext();
        return current;
    }
    
    
 
    
}
