public class Piece {
    private Position position;
    private String type;
    private int playerIndex;

    public Piece(String type,int playerIndex,int x,int y){
        Position p = new Position(x,y);
        this.position = p;
        this.type = type;
        this.playerIndex = playerIndex;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }
}
