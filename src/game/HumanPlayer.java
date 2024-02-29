package game;

public class HumanPlayer extends Player{

    private String name; 

    public HumanPlayer(String name){
        super("1234", "Human",name);
        this.name = name;
    }

    
    @Override
    public String getName() {
        return name;
    }
}
