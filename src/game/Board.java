package game;
public class Board {
    
    private int pins;
    
    public void Board(){ 
        pins = 10;
    }
    
    public int getPins(){
        return pins;
    }
    
    public void setPins(int pins){
        this.pins = pins;
    }
    
    public void take1Pin(){
        this.pins -= 1;
    }

    public void take2Pins(){
        this.pins -= 2;
    }
    
    public boolean isEmpty(){
        return pins == 0;
    }
    
    public String toString(){
        return "Pins: " + pins;
    }
}
