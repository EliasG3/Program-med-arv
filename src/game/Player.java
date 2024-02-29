package game;
abstract class Player {
    
    private String userID;
    private String player; 
    private String name;
    
    public Player(String userID, String player, String name){
        this.userID = userID;
        this.player = player;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getUserID(){
        return userID;
    }

    public String getPlayer(){
        return player;
    }

    public void setUserID(String userID){
        this.userID = userID;
    }

    public void setPlayer(String player){
        this.player = player;
    }

    public void setName(String name){
        this.name = name;
    }

    public int take2Pins(Board board){
        board.take2Pins();
        return board.getPins();
    }

    public int take1Pin(Board board){
        board.take1Pin();
        return board.getPins();
    }
}
