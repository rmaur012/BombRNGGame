/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bombrnggame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Ricky
 */

public class BombRNGGame {
    public static PlayerLine playerLine;
    public static LeverLine leverLine;
    
    public static void displayActiveLevers(ArrayList<Lever> activeLevers){
        String allLevers = "Active Levers: ";
        for(int i =0; i<activeLevers.size(); i++){
            if(activeLevers.get(i).isActive()){
                allLevers += "(" + (i+1) + ")   ";
            }
        }
        System.out.println(allLevers);
    }
    
    public static LeverLine makeNewLeverLine(int bombLocation, int leversToBePlaced){
        LeverLine newLine = new LeverLine(bombLocation, leversToBePlaced);
        return newLine;
    }
    
    public static void runGame(){
        Scanner reader = new Scanner(System.in);
        
        Random num = new Random();
        int playersLeft = 4;
        int humanPlacement = num.nextInt(playersLeft);
        int leversLeft = playersLeft+1;
        int bombPlacement = num.nextInt(leversLeft);
        
        System.out.println("Welcome to Blow Up!");
        System.out.println("You fight 3 CPUs pushing levers and hoping you don't...well... blow up.\n");
        System.out.println("You are player #" + (humanPlacement+1) +"\n");
        
        boolean foundBomb = false;
        playerLine = new PlayerLine(humanPlacement, playersLeft);
        //3While a winner is not selected
        while(playersLeft > 1){
            System.out.println("Assembling new levers...\n");
            leverLine = makeNewLeverLine(bombPlacement, leversLeft);
            while(/*leverLine.howManyLeversLeft() != 0 ||*/ !foundBomb){
                if(leverLine.howManyLeversLeft() == 1){
                    System.out.println("Bomb was found! Making new lever line...\n");
                    bombPlacement = num.nextInt(leversLeft);
                    leverLine = makeNewLeverLine(bombPlacement, leversLeft);
                }
                displayActiveLevers(leverLine.checkLevers());
                int leverChosen = playerLine.nextPlayersTurn(leverLine.howManyLeversLeft());
                
                if(playerLine.checkCurrentPlayer() == humanPlacement){  
                    foundBomb = leverLine.pushSelectedLever(leverChosen, true);
                } else {
                    foundBomb = leverLine.pushSelectedLever(leverChosen, false);
                }
            }
            
            //If the player who detonated the bomb is the human player, break the loop to say they lost.
            if(playerLine.checkCurrentPlayer() == humanPlacement){  
                break;
            } else {
                playerLine.currentPlayerDied();
            }
            
            playersLeft--;
            leversLeft = playersLeft+1;
            bombPlacement = num.nextInt(leversLeft);
            foundBomb = false;
        }
        
        if(playersLeft > 1){
            System.out.println("You detonated the bomb! You lose!");
        } else {
            System.out.println("You win!");
        }
        playerLine.closeHumanPlayerScanner();
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        runGame();
        
        /*displayActiveLevers(leverLine.checkLevers());
        
        System.out.println(leverLine.pushSelectedLever(4, true));
        
        displayActiveLevers(leverLine.checkLevers());
        
        System.out.println(leverLine.pushSelectedLever(5, true));
        
        displayActiveLevers(leverLine.checkLevers());
        
        System.out.println(leverLine.pushSelectedLever(1, false));
        
        displayActiveLevers(leverLine.checkLevers());*/
        
        
        
    }
    
}

/*
Comments:
- Make it so that a new  player line is not created once a bomb explodes, keep the same order
- Make a new lever line once the bomb is the only lever left.
*/