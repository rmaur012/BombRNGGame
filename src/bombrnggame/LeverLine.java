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
public class LeverLine {
    
    private static ArrayList<Lever> leverList;
    private static int leversLeft;
    
    public LeverLine(int bombPlacement, int numOfLevers){
        leversLeft = numOfLevers;
        makeNewLine(bombPlacement, numOfLevers);
    }
    
    public void makeNewLine(int bombPlacement, int numOfLevers){
        leverList = new ArrayList<>(numOfLevers);
        
        //For loop sets the levers that will be pushed
        for(int i =0; i<numOfLevers; i++){
            if(i == bombPlacement){
                leverList.add(new Lever(true, 1));
            } else {
                leverList.add(new Lever(false, 12));
            }
        }
    }
    
    public ArrayList<Lever> checkLevers(){
        return leverList;
    }
    
    //If exactLocation is true, then a human player chose the actual lever they wish to push
    //If false, then a CPU gave a relative location of the lever they chose (ex. 2nd from the left)
    public boolean pushSelectedLever(int lever, boolean exactLocation){
        leversLeft--;
        
        boolean hasBomb = false;
        try{
            Thread.sleep(2000);
        
            if(exactLocation){
                //It's lever-1 since levers are displayed 1-5 while being 0-4 in list
                hasBomb = leverList.get(lever-1).pushLever();
                System.out.println("The player has chosen lever: " + (lever));
            } else {
                int actualLever = 0;
                while(lever >= 0){
                    if(leverList.get(actualLever).isActive()){
                        lever--;
                    }
                    actualLever++;
                }
                hasBomb = leverList.get(actualLever-1).pushLever();
                System.out.println("The CPU has chosen lever: " + (actualLever));
            }
            
            Thread.sleep(1000);
            
            System.out.println("Click!");
            
            Thread.sleep(1000);
            
            System.out.println("...");
            
            Thread.sleep(1000);

            if(hasBomb){
                System.out.println("Boom!\n");
            } else {
                System.out.println("...");
            }
            Thread.sleep(2000);
        } catch(InterruptedException e){
            System.out.println("Was Interrupted");
        }
        
        return hasBomb;
    }
    
    public int howManyLeversLeft(){
        return leversLeft;
    }
    
}
