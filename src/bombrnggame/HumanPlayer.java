/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bombrnggame;

import java.util.Scanner;

/**
 *
 * @author Ricky
 */
public class HumanPlayer extends Player{
    Scanner in;
    
    public HumanPlayer(int place){
        super(place);
        in = new Scanner(System.in);
    }
    
    @Override
    public int makeMove(int leversLeft){
        int leverSelected = -1;
        try{
            leverSelected = in.nextInt();
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return leverSelected;
    }
    
    public void closeScanner(){
        in.close();
    }
    
}
