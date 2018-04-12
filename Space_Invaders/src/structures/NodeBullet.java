
package structures;

/**
 *
 * @author Daniel
 */
public class NodeBullet {
    
        Object value;
        NodeBullet next;
        public NodeBullet(Object o){
            this.value = o;
            this.next = null;
        }
        public void setNext(NodeBullet n){
            this.next =n;
        }
        public NodeBullet getNext(){
            return this.next;
        }
        public Object getValue(){
            return this.value;
        }

}
