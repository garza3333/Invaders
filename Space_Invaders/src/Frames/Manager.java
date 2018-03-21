
package Frames;

/**
 *
 * @author Daniel
 */
public class Manager {
    
    public Manager(){
            
    }
    
    
    
    public void show(String n){
        switch(n){
            case "main":
                MainFrame m = new MainFrame();         
                break;
                
                
            case "data":  
                DataFrame d = new DataFrame();
                break;
            
            case "start":
                UsserFrame u = new UsserFrame();
                break;
            
            case "play":
                PlayFrame p = new PlayFrame();
                break;
                
                
        }
                
                    
                    
                
    }
    
}
