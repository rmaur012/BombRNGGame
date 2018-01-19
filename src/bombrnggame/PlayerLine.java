/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bombrnggame;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Ricky
 */
public class PlayerLine {
    
    private static ArrayList<Player> playerList;
    private int currentPlayerTurn;
    private boolean winnerDecided;
    private int humanPlacement;
    
    public PlayerLine(int humanPlacement, int numOfPlayers){
        currentPlayerTurn = -1;  //It's -1 since when nextPlayerTurn() is called, it will add +1 to start at zero
        HumanPlayer hmn = new HumanPlayer(humanPlacement);
        winnerDecided = false;
        this.humanPlacement = humanPlacement;
        
        playerList = new ArrayList<>(numOfPlayers);
        
        //For loop sets the order in which the CPUs and the human player will play
        for(int i =0; i<numOfPlayers; i++){
            if(i == humanPlacement){
                playerList.add(hmn);
            } else {
                playerList.add(new CPUPlayer(i));
            }
        }
    }
    
    public int nextPlayersTurn(int leversLeft){
        do{
            if((currentPlayerTurn + 1) == playerList.size()){
                currentPlayerTurn = 0;
            } else {
                currentPlayerTurn++;
            }
        }while(playerList.get(currentPlayerTurn).isDead());
        
        System.out.println("It is Player " + (playerList.get(currentPlayerTurn).getSpot()+1) + "'s turn!");
        
        int chosenLever = playerList.get(currentPlayerTurn).makeMove(leversLeft);
        
        return chosenLever;
    }
    
    public void currentPlayerDied(){
        playerList.get(currentPlayerTurn).playerDied();
    }
    
    public int checkCurrentPlayer(){
        return currentPlayerTurn;
    }
    
    public void closeHumanPlayerScanner(){
        playerList.get(humanPlacement).closeScanner();
    }
    
}
