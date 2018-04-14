
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
    /**
     * Constructor de la clase Manager
     */
    public Manager(){
            
    }
    
    /**
     * Crea una ventana de tipo PlayFrame y le da valor al atributo de namePlayer
     * @param n tipo de ventana
     * @param p nombre de usuario
     */
    
    public void show(String n , String p){
        if("play".equals(n)){
            
        play = new PlayFrame(this,p);
        }
    }
    
    /**
     * Crea una ventana dependiendo del String que sea introducido en el parametro
     * @param n nombre de ventana a crear
     */
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
    
        /**
         * Retorna la ventana principal
         * @return 
         */
        public MainFrame getMainFrame(){
            return this.main;
        }/**
         * Retorna la ventana de datos
         * @return 
         */
        public DataFrame getDataFrame(){
            return this.data;
            
        }
        /**
         * Retorna la ventana de usuario
         * @return 
         */
        public UsserFrame getUsserFrame(){
            return this.user;
        }
        /**
         * Retorna la ventana de juego
         * @return 
         */
       public PlayFrame getPlayFrame(){
           return this.play;
       }
}
