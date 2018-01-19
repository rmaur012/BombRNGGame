/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bombrnggame;

/**
 *
 * @author Ricky
 */
public class Player {
    
    boolean isDead;
    int spot;
    
    public Player(int place){
        isDead = false;
        spot = place;
    }
    
    public void playerDied(){
        isDead = true;
    }
    
    public boolean isDead(){
        return isDead;
    }
    
    public int makeMove(int leversLeft){
        return 0;
    }
    
    public int getSpot(){
        return spot;
    }

    void closeScanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
