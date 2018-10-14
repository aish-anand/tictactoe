//driver for new mvc tictactoe
import model.*;
import view.*;
import controller.*;
 public class TicTacToe {                                                              
                                                                                 
    public static void main(String[] args) {                                                                           
        Model m = new Model();                                                        
        View v = new View();                                                     
        Controller c = new Controller();                                                
                                                                                                        
        m.registerView(v);                                                       
        c.setModel(m);                                                                                           
        v.setActionListener(c);                                                                                                         
    }                                                                            
}
