/*
* this class holds the eastern panel of the graphics of this program
* it creates 2 buttons
* there are also methods that gets the buttons and labels
 */
package grafik;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;



/**
 *
 * @author Reza
 */


public class East extends JPanel {
    
    
    private JButton lottoButton = new JButton();
    private JButton eurojackpotButton = new JButton();
    
    public East(){
        
        //setting the layout of the panel
        GridBagLayout grbl = new GridBagLayout();
        setLayout(grbl);
        
        lottoButton.setText("Lotto");
        lottoButton.setPreferredSize(new Dimension(150,50));
        
        eurojackpotButton.setText("Eurojackpot");
        eurojackpotButton.setPreferredSize(new Dimension(150,50));
        
        GridBagConstraints con;
        
        con = new GridBagConstraints();
        con.gridy = 1;
        con.gridx = 0;
        con.insets = new Insets(10, 10, 10, 10);
        add(lottoButton,con);
        
        con = new GridBagConstraints();
        con.gridy = 2;
        con.gridx = 0;
        con.insets = new Insets(10, 10, 10, 10);
        add(eurojackpotButton,con);
        
    }
    
    //a method that adds actionlistener to the 2 buttons
    public void addButtonListener(ActionListener listenForButton){
	        
        lottoButton.addActionListener(listenForButton);
        eurojackpotButton.addActionListener(listenForButton);
       
    }
    
    
    public javax.swing.JButton getButtonLotto(){
        
	        return this.lottoButton;
    }
    
    public javax.swing.JButton getButtonEurojackpot(){
        
	        return this.eurojackpotButton;
    }
    
}
