/*
 * This class holds the northern panel of the graphics of this program
 * 
 * 
 */
package grafik;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Reza
 */

public class North extends JPanel{
    
    JLabel lottoPic1 = new JLabel(new ImageIcon("pictures\\lotto.png"));
    JLabel lottoPic2 = new JLabel(new ImageIcon("pictures\\LOTTOBALLS.jpg"));
    JLabel lottoPic3 = new JLabel(new ImageIcon("pictures\\lotto.png"));
    
    //constructor
    public North(){
        
        lottoPic1.setPreferredSize(new Dimension(400,200));
        add(lottoPic1);
        lottoPic2.setPreferredSize(new Dimension(400,200));
        add(lottoPic2);
        lottoPic3.setPreferredSize(new Dimension(400,200));
        add(lottoPic3);
        
    }
}
