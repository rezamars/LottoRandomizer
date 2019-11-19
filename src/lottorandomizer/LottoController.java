/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import grafik.East;
import grafik.North;
import grafik.South;
import grafik.West;
import lottorandomizer.LottoView;
import model.ButtonListener;

/**
 *
 * @author Reza
 */
public class LottoController {

    private North north = new North();
    private West west = new West();
    private East east = new East();
    private South south = new South();
    
    
    public LottoController (){
        
        east.addButtonListener(new ButtonListener(west,east));
        LottoView v = new LottoView(north, west, east, south);
        
    }
    
    public static void main(String[] args) {
        
        //create instance of controller and start the program
        LottoController c = new LottoController();
        
    }
    
}
