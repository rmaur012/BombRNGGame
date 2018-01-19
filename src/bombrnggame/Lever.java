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
public class Lever {
    
    private boolean hasBomb;
    private boolean active;
    
    public Lever(boolean value, int ded){
        this.hasBomb = value;
        active = true;
    }
    
    public boolean pushLever(){
        active = false;
        return hasBomb;
    }
    
    public boolean isActive(){
        return active;
    }
    
}
