
package Frames;

/**
 *
 * @author Daniel
 */
public class Manager {
    private MainFrame main;
    private DataFrame data;
    private UsserFrame user;
    private PlayFrame play;
    
    public Manager(){
            
    }
    
    
    
    public void show(String n){
        switch(n){
            case "main":
                main = new MainFrame(this);         
                break;
                
                
            case "data":  
                data = new DataFrame(this);
                break;
            
            case "start":
                user = new UsserFrame(this);
                break;
            
            case "play":
                play = new PlayFrame(this);
                break;
                
                
        }
        

                  
    }
        public MainFrame getMainFrame(){
            return this.main;
        }    
        public DataFrame getDataFrame(){
            return this.data;
            
        }
        public UsserFrame getUsserFrame(){
            return this.user;
        }
       public PlayFrame getPlayFrame(){
           return this.play;
       }
}
