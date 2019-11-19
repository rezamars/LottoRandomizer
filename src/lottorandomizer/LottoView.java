
package lottorandomizer;

import grafik.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JScrollPane;

/**
 *
 * @author Reza
 */

//this class creates the JFrame and sets the layout and adds the 4 panels to the frame
public class LottoView extends JFrame {
    
    
    //constructor that will set the borderlayout, and adds the 4 panels
    public LottoView(North north, West west, East east, South south){
        
        BorderLayout b = new BorderLayout();
        setLayout(b);
        
        add(north,BorderLayout.NORTH);
        
        add(west,BorderLayout.WEST);
        
        //Adding scroll-function for the west-panel
        JScrollPane scrollFrame = new JScrollPane(west);
        west.setAutoscrolls(true);
        scrollFrame.setPreferredSize(new Dimension( 800,300));
        this.add(scrollFrame);
        
        add(east,BorderLayout.EAST);
        
        add(south,BorderLayout.SOUTH);
        
        //settings of the frame
        this.setResizable(false);
        setLocation(100,50);
        setSize(900,600);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
}
