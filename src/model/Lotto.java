/*
 * The lotto-class that handles graphics and randomizing
 * of 5 rows of lotto-numbers in a way that all 35 numbers
 * are available in the 5 rows and every number is 
 * represented once
 */
package model;

import grafik.West;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Random;
import javax.swing.JLabel;

/**
 *
 * @author Reza
 */
public class Lotto {
    
    //Instance variables
    private West we= new West();
    private int[] lottoNumber= new int[35];
    private JLabel[] rowNumberArray= new JLabel[5];
    private JLabel[] lottoNumberArray= new JLabel[35];
    private Random ran = new Random();
    
     public Lotto(){
         
     }
     
    //Contructor 
    public Lotto(West west){
       
        this.we = west;
        
        //clean the west panel, used for cleaning after multiple clicks
        we.removeAll();
        we.updateUI();
        
        randomizeLottoNumbers();
        
        //setting the layout of this panel
        GridBagLayout gr = new GridBagLayout();
        west.setLayout(gr);
        
        GridBagConstraints con ;
        
        //setting x,y,insets, font of the labelarray for the row-numbers, adding the labelarray to the panel
        //x,y of the label + color
        for(int x = 0 ; x < rowNumberArray.length ; x++){
            rowNumberArray[x] = new JLabel();
            con = new GridBagConstraints();
            con.gridx = 1;
            con.gridy = (x+1);
            con.insets = new Insets(10, 200, 10, 50);
            we.add(rowNumberArray[x],con);
            rowNumberArray[x].setFont(new Font("SansSerif", Font.BOLD, 35));
            rowNumberArray[x].setText("Rad " + Integer.toString(x+1) + ":");
            rowNumberArray[x].setBackground(Color.green);
            rowNumberArray[x].setOpaque(true);
        }
        
        
        int arrayIndex = 0;
        
        //setting x,y,insets, font of the labelarray for the lotto-numbers + adding the labelarray to the panel
        //x,y of the label + color
        for(int w=0; w<5; w++){
            
            for(int i=0; i<7; i++){

                lottoNumberArray[arrayIndex] = new JLabel();
                con = new GridBagConstraints();
                con.gridx = (3+i);
                con.gridy = (w+1);
                con.insets = new Insets(10, 20, 10, 50);
                //int arrayIndex = ((((w+1)*(i+1)))-1);
                we.add(lottoNumberArray[arrayIndex],con);
                lottoNumberArray[arrayIndex].setFont(new Font("SansSerif", Font.BOLD, 25));
                lottoNumberArray[arrayIndex].setText(Integer.toString(lottoNumber[arrayIndex]));
                arrayIndex++;
            }
            
            
        }
        
    }
    
    //method for filling the lottoNumber-array
    //and making sure that every number (1-35) are represented once
    public void randomizeLottoNumbers(){
        
        for (int i = 0 ; i < 35 ; i++){
            lottoNumber[i] = 0;
        }
        
        
        for(int x = 0 ; x<35 ; x++){
            
            int ra = ran.nextInt(35);
            lottoNumber[x] = (ra + 1);
        }
        
        int x= 0;
        while( x<35 ){
            
            for(int i = 0 ; i<35 ; i++){
                
                if(lottoNumber[x] == lottoNumber[i] && i!=x){
                    int ra = ran.nextInt(35);
                    lottoNumber[x] = (ra + 1);
                    x=0;
                }
            }
            x++;
        }
        
        sortArray7();
    }
    
    //Sorting every lottorow in acsending order
    public void sortArray7(){
        
        int temp = 0;
        
        for (int i = 0; i < 7; i++) {
            
            for (int j = i; j > 0; j--) {
                
                if (lottoNumber[j] < lottoNumber [j - 1]) {
                 
                    temp = lottoNumber[j];
                    lottoNumber[j] = lottoNumber[j - 1];
                    lottoNumber[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 7; i < 14; i++) {
            
            for (int j = i; j > 7; j--) {
                
                if (lottoNumber[j] < lottoNumber [j - 1]) {
                 
                    temp = lottoNumber[j];
                    lottoNumber[j] = lottoNumber[j - 1];
                    lottoNumber[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 14; i < 21; i++) {
            
            for (int j = i; j > 14; j--) {
                
                if (lottoNumber[j] < lottoNumber [j - 1]) {
                 
                    temp = lottoNumber[j];
                    lottoNumber[j] = lottoNumber[j - 1];
                    lottoNumber[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 21; i < 28; i++) {
            
            for (int j = i; j > 21; j--) {
                
                if (lottoNumber[j] < lottoNumber [j - 1]) {
                 
                    temp = lottoNumber[j];
                    lottoNumber[j] = lottoNumber[j - 1];
                    lottoNumber[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 28; i < 35; i++) {
            
            for (int j = i; j > 28; j--) {
                
                if (lottoNumber[j] < lottoNumber [j - 1]) {
                 
                    temp = lottoNumber[j];
                    lottoNumber[j] = lottoNumber[j - 1];
                    lottoNumber[j - 1] = temp;
                   }
            }
        }
        
    }
    
    
}
