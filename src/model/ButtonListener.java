/*
 * A listener that creates instance of the object 
 * that the user clicks on (Lotto or Eurojackpot)
 * 
 */
package model;

import grafik.East;
import grafik.West;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author Reza
 */
public class ButtonListener implements ActionListener{

    private East east;
    private West west ;
    
    
    public ButtonListener(){
       
    }
    
    //Constructor
    public ButtonListener(West w, East e){
        
        this.east = e;
        this.west = w;
       
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
         
        //If the user clicks on the Lotto-button
        if(ae.getSource() == east.getButtonLotto()){
            
            
            Lotto lotto = new Lotto(west);
            
        }
        
        //If the user clicks on the Eurojackpot-button
        else if(ae.getSource() == east.getButtonEurojackpot()){
            
            Eurojackpot euro = new Eurojackpot(west);
            
        }
    }

    
    
    
}
