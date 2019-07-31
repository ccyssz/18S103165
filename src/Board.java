public class Board {
    public static final int GO_SIZE = 19;
    public static final int CHESS_SIZE =  8;
    private int boardSize;
    private int boardCount;
    private Piece[][] map;


    //type 0 围棋 1 国际象棋
    public Board(int type){
        if(type == 0){
            map = new Piece[GO_SIZE][GO_SIZE];
            boardSize = GO_SIZE;
        }else{
            map = new Piece[CHESS_SIZE][CHESS_SIZE];
            boardSize = CHESS_SIZE;
            boardCount = 32;
        }

    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public int getBoardCount() {
        return boardCount;
    }

    public void setBoardCount(int boardCount) {
        this.boardCount = boardCount;
    }

    public Piece[][] getMap() {
        return map;
    }

    public void setMap(Piece[][] map) {
        this.map = map;
    }
}
