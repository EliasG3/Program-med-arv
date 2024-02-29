package game;

public class ComputerPlayer extends Player{
    
    private String name; 
    
    public ComputerPlayer(String name){
        super("4321", "Computer", name);
        this.name = name;
    }
    
   
    
    public int generateRandomNumber(){
        return (int) (Math.random() * 2) + 1;
    }

    @Override
    public String getName() {
        return name;
    }
}
