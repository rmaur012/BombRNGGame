/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bombrnggame;

import java.util.Random;

/**
 *
 * @author Ricky
 */
public class CPUPlayer extends Player{
    
    public CPUPlayer(int spot){
        super(spot);
    }
    
    @Override
    public int makeMove(int leversLeft){
        
        Random thinking = new Random();
        int leverSelected = thinking.nextInt(leversLeft);
        
        return leverSelected;
    }
    
}
