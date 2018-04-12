

import AbstractEnemy.Enemy_Basic;
import Frames.*;
import structures.LinkedList;
import structures.Node;



/**
 *
 * @author Daniel
 */
public class Main {

  
    public static void main(String[] args) {
//        Thread t = new Thread(){
//            @Override
//            public void run(){
//            while(true){
//            int randomNum = ThreadLocalRandom.current().nextInt(0, 12);
//            System.out.println(randomNum);
//               try {
//                    this.sleep(40);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//                }            
//            }
// 
//            }
//        };
//        t.start();

          Manager m = new Manager();
          m.show("main");



//            Enemy_Basic b = new Enemy_Basic();
//            b.setBoss(true);
//            LinkedList l = new LinkedList();
//            l.add(new Node(new Enemy_Basic()));
//            l.add(new Node(new Enemy_Basic()));
//            l.add(new Node(new Enemy_Basic()));
//            l.add(new Node(b));
//            int a = 0;
//            Node temp =l.getHead();
//            while(temp!=null){
//                if(a == l.getSize()-1){
//                    System.out.println(temp.getValue().isBoss());
//                }
//                temp = temp.getNext();
//                a++;
//            }
            

            

    }
    
}
