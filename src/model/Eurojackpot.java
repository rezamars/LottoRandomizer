/*
 * The eurojackpot-class that handles graphics and randomizing
 * of 10 rows of eurojackpot-numbers in a way that all 50 numbers
 * are available in the 10 rows and every number is 
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
public class Eurojackpot {
    
    private West we= new West();
    private int[] eurojackpotNumber= new int[50];
    private JLabel[] rowNumberArray= new JLabel[10];
    private JLabel[] eurojackpotNumberArray= new JLabel[50];
    private JLabel[] tillaggNumberArray= new JLabel[20];
    private int[] tillaggNumber= new int[20];
    private Random ran = new Random();
    
     public Eurojackpot(){
         
     }
     
    //Constructor
    public Eurojackpot(West west){
       
        this.we = west;
        
        //clean the west panel, used for cleaning after multiple clicks
        we.removeAll();
        we.updateUI();
       
        randomizeEurojackpotNumbers();
        randomizetillaggNumbers();
        
        //setting the layout of this panel
        GridBagLayout gr = new GridBagLayout();
        west.setLayout(gr);
        
        //x,y of the label
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
            rowNumberArray[x].setBackground(Color.ORANGE);
            rowNumberArray[x].setOpaque(true);
        }
        
        
        int arrayIndex = 0;
        
        //setting x,y,insets, font of the labelarray for the eurojackpot-numbers + adding the labelarray to the panel
        //x,y of the label + color
        for(int w=0; w<10; w++){
            
            for(int i=0; i<5; i++){

                eurojackpotNumberArray[arrayIndex] = new JLabel();
                con = new GridBagConstraints();
                con.gridx = (3+i);
                con.gridy = (w+1);
                con.insets = new Insets(10, 20, 10, 50);
                
                we.add(eurojackpotNumberArray[arrayIndex],con);
                eurojackpotNumberArray[arrayIndex].setFont(new Font("SansSerif", Font.BOLD, 25));
                eurojackpotNumberArray[arrayIndex].setText(Integer.toString(eurojackpotNumber[arrayIndex]));
                eurojackpotNumberArray[arrayIndex].setForeground(Color.RED);
                eurojackpotNumberArray[arrayIndex].setOpaque(true);
                arrayIndex++;
            }
            
        }
        
        arrayIndex = 0;
        
        //setting x,y,insets, font of the labelarray for the tillagg-numbers + adding the labelarray to the panel
        //x,y of the label + color
        for(int w=0; w<10; w++){
            
            for(int i=0; i<2; i++){

                tillaggNumberArray[arrayIndex] = new JLabel();
                con = new GridBagConstraints();
                con.gridx = (10+i);
                con.gridy = (w+1);
                con.insets = new Insets(10, 20, 10, 50);
                
                we.add(tillaggNumberArray[arrayIndex],con);
                tillaggNumberArray[arrayIndex].setFont(new Font("SansSerif", Font.BOLD, 25));
                tillaggNumberArray[arrayIndex].setText(Integer.toString(tillaggNumber[arrayIndex]));
                //tillaggNumberArray[arrayIndex].setBackground(Color.RED);
                tillaggNumberArray[arrayIndex].setForeground(Color.BLUE);
                tillaggNumberArray[arrayIndex].setOpaque(true);
                arrayIndex++;
            }
            
        }
        
    }
    
    //method for filling the eurojackpotnumber-array
    //and making sure that every number (1-50) are represented once
    public void randomizeEurojackpotNumbers(){
        
        for (int i = 0 ; i < 50 ; i++){
            eurojackpotNumber[i] = 0;
        }
        
        
        for(int x = 0 ; x<50 ; x++){
            
            int ra = ran.nextInt(50);
            eurojackpotNumber[x] = (ra + 1);
        }
        
        int x= 0;
        while( x<50 ){
            
            for(int i = 0 ; i<50 ; i++){
                
                if(eurojackpotNumber[x] == eurojackpotNumber[i] && i!=x){
                    int ra = ran.nextInt(50);
                    eurojackpotNumber[x] = (ra + 1);
                    x=0;
                }
            }
            x++;
        }
        
        sortEurojackpotNumberArray();
    }
    
   
    //Sorting every eurojackpot-row in acsending order
    public void sortEurojackpotNumberArray(){
        
        int temp = 0;
        
        for (int i = 0; i < 5; i++) {
            
            for (int j = i; j > 0; j--) {
                
                if (eurojackpotNumber[j] < eurojackpotNumber [j - 1]) {
                 
                    temp = eurojackpotNumber[j];
                    eurojackpotNumber[j] = eurojackpotNumber[j - 1];
                    eurojackpotNumber[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 5; i < 10; i++) {
            
            for (int j = i; j > 5; j--) {
                
                if (eurojackpotNumber[j] < eurojackpotNumber [j - 1]) {
                 
                    temp = eurojackpotNumber[j];
                    eurojackpotNumber[j] = eurojackpotNumber[j - 1];
                    eurojackpotNumber[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 10; i < 15; i++) {
            
            for (int j = i; j > 10; j--) {
                
                if (eurojackpotNumber[j] < eurojackpotNumber [j - 1]) {
                 
                    temp = eurojackpotNumber[j];
                    eurojackpotNumber[j] = eurojackpotNumber[j - 1];
                    eurojackpotNumber[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 15; i < 20; i++) {
            
            for (int j = i; j > 15; j--) {
                
                if (eurojackpotNumber[j] < eurojackpotNumber [j - 1]) {
                 
                    temp = eurojackpotNumber[j];
                    eurojackpotNumber[j] = eurojackpotNumber[j - 1];
                    eurojackpotNumber[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 20; i < 25; i++) {
            
            for (int j = i; j > 20; j--) {
                
                if (eurojackpotNumber[j] < eurojackpotNumber [j - 1]) {
                 
                    temp = eurojackpotNumber[j];
                    eurojackpotNumber[j] = eurojackpotNumber[j - 1];
                    eurojackpotNumber[j - 1] = temp;
                   }
            }
        }
        
        for (int i = 25; i < 30; i++) {
            
            for (int j = i; j > 25; j--) {
                
                if (eurojackpotNumber[j] < eurojackpotNumber [j - 1]) {
                 
                    temp = eurojackpotNumber[j];
                    eurojackpotNumber[j] = eurojackpotNumber[j - 1];
                    eurojackpotNumber[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 30; i < 35; i++) {
            
            for (int j = i; j > 30; j--) {
                
                if (eurojackpotNumber[j] < eurojackpotNumber [j - 1]) {
                 
                    temp = eurojackpotNumber[j];
                    eurojackpotNumber[j] = eurojackpotNumber[j - 1];
                    eurojackpotNumber[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 35; i < 40; i++) {
            
            for (int j = i; j > 35; j--) {
                
                if (eurojackpotNumber[j] < eurojackpotNumber [j - 1]) {
                 
                    temp = eurojackpotNumber[j];
                    eurojackpotNumber[j] = eurojackpotNumber[j - 1];
                    eurojackpotNumber[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 40; i < 45; i++) {
            
            for (int j = i; j > 40 ; j--) {
                
                if (eurojackpotNumber[j] < eurojackpotNumber [j - 1]) {
                 
                    temp = eurojackpotNumber[j];
                    eurojackpotNumber[j] = eurojackpotNumber[j - 1];
                    eurojackpotNumber[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 45; i < 50; i++) {
            
            for (int j = i; j > 45; j--) {
                
                if (eurojackpotNumber[j] < eurojackpotNumber [j - 1]) {
                 
                    temp = eurojackpotNumber[j];
                    eurojackpotNumber[j] = eurojackpotNumber[j - 1];
                    eurojackpotNumber[j - 1] = temp;
                   }
            }
        }
        
    }
    
    //method for filling the tillaggnumber-array
    //and making sure that the 2 tillagg-numbers are not the same
     public void randomizetillaggNumbers(){
        
        for (int i = 0 ; i < 20 ; i++){
            tillaggNumber[i] = 0;
        }
        
        
        for(int x = 0 ; x<20 ; x++){
            
            int ra = ran.nextInt(10);
            tillaggNumber[x] = (ra + 1);
        }
        
        
        for(int w=0 ; w<20 ; w++){
            
            if((w%2)==0){
                System.out.println("even: " + w);
                
            }
            else {
                System.out.println("odd: " + w);
                
                do{
                    
                    int ra = ran.nextInt(10);
                    tillaggNumber[w] = (ra + 1);
                    
                }while (tillaggNumber[w] == tillaggNumber[w-1]);
                
            }
   
        }
        
        sortTillaggNumberArray();
    }
    
     //Sorting the 10 pairs of 2 tillagg-numbers in acsending order
    public void sortTillaggNumberArray(){
        
        int temp = 0;
        
        for (int i = 0; i < 2; i++) {
            
            for (int j = i; j > 0; j--) {
                
                if (tillaggNumber[j] < tillaggNumber [j - 1]) {
                 
                    temp = tillaggNumber[j];
                    tillaggNumber[j] = tillaggNumber[j - 1];
                    tillaggNumber[j - 1] = temp;
                   }
            }
        }
        
        for (int i = 2; i < 4; i++) {
            
            for (int j = i; j > 2; j--) {
                
                if (tillaggNumber[j] < tillaggNumber [j - 1]) {
                 
                    temp = tillaggNumber[j];
                    tillaggNumber[j] = tillaggNumber[j - 1];
                    tillaggNumber[j - 1] = temp;
                   }
            }
        }
        
        for (int i = 4; i < 6; i++) {
            
            for (int j = i; j > 4; j--) {
                
                if (tillaggNumber[j] < tillaggNumber [j - 1]) {
                 
                    temp = tillaggNumber[j];
                    tillaggNumber[j] = tillaggNumber[j - 1];
                    tillaggNumber[j - 1] = temp;
                   }
            }
        }
        
        for (int i = 6; i < 8; i++) {
            
            for (int j = i; j > 6; j--) {
                
                if (tillaggNumber[j] < tillaggNumber [j - 1]) {
                 
                    temp = tillaggNumber[j];
                    tillaggNumber[j] = tillaggNumber[j - 1];
                    tillaggNumber[j - 1] = temp;
                   }
            }
        }
        
        for (int i = 8; i < 10; i++) {
            
            for (int j = i; j > 8; j--) {
                
                if (tillaggNumber[j] < tillaggNumber [j - 1]) {
                 
                    temp = tillaggNumber[j];
                    tillaggNumber[j] = tillaggNumber[j - 1];
                    tillaggNumber[j - 1] = temp;
                   }
            }
        }
        
        for (int i = 10; i < 12; i++) {
            
            for (int j = i; j > 10; j--) {
                
                if (tillaggNumber[j] < tillaggNumber [j - 1]) {
                 
                    temp = tillaggNumber[j];
                    tillaggNumber[j] = tillaggNumber[j - 1];
                    tillaggNumber[j - 1] = temp;
                   }
            }
        }
        
        for (int i = 12; i < 14; i++) {
            
            for (int j = i; j > 12; j--) {
                
                if (tillaggNumber[j] < tillaggNumber [j - 1]) {
                 
                    temp = tillaggNumber[j];
                    tillaggNumber[j] = tillaggNumber[j - 1];
                    tillaggNumber[j - 1] = temp;
                   }
            }
        }
        
        for (int i = 14; i < 16; i++) {
            
            for (int j = i; j > 14; j--) {
                
                if (tillaggNumber[j] < tillaggNumber [j - 1]) {
                 
                    temp = tillaggNumber[j];
                    tillaggNumber[j] = tillaggNumber[j - 1];
                    tillaggNumber[j - 1] = temp;
                   }
            }
        }
        
        for (int i = 16; i < 18; i++) {
            
            for (int j = i; j > 16; j--) {
                
                if (tillaggNumber[j] < tillaggNumber [j - 1]) {
                 
                    temp = tillaggNumber[j];
                    tillaggNumber[j] = tillaggNumber[j - 1];
                    tillaggNumber[j - 1] = temp;
                   }
            }
        }
        
        for (int i = 18; i < 20; i++) {
            
            for (int j = i; j > 18; j--) {
                
                if (tillaggNumber[j] < tillaggNumber [j - 1]) {
                 
                    temp = tillaggNumber[j];
                    tillaggNumber[j] = tillaggNumber[j - 1];
                    tillaggNumber[j - 1] = temp;
                   }
            }
        }
        
    }
    
}
