import java.util.List;

public class ChessGame extends Game {
    private static String[] chessList = new String[]{"P","K","Q","R","B","Kn"};
    public ChessGame(String name1,String name2){
        player1 = new Player(name1);
        player2 = new Player(name2);
        board = new Board(1);
        init();
    }

    //国际象棋初始化
    @Override
    public void init() {
        player1.setPiecesCount(16);
        List<Piece> pieceList1 = player1.getPiecesIn();
        player2.setPiecesCount(16);
        List<Piece> pieceList2 = player2.getPiecesIn();
        for(int i = 0 ;i < 8;i++){
            Piece piece = new Piece("P",1,i,1);
            pieceList1.add(piece);
            board.getMap()[i][1] = piece;
        }
        for(int i = 0 ;i < 8;i++){
            Piece piece = new Piece("P",2,i,6);
            pieceList1.add(piece);
            board.getMap()[i][6] = piece;
        }
        Piece piece = new Piece("K",1,3,0);
        pieceList1.add(piece);
        board.getMap()[3][0] = piece;
        piece = new Piece("Q",1,4,0);
        pieceList1.add(piece);
        board.getMap()[4][0] = piece;
        piece = new Piece("R",1,0,0);
        pieceList1.add(piece);
        board.getMap()[0][0] = piece;
        piece = new Piece("R",1,7,0);
        pieceList1.add(piece);
        board.getMap()[7][0] = piece;
        piece = new Piece("B",1,2,0);
        pieceList1.add(piece);
        board.getMap()[2][0] = piece;
        piece = new Piece("B",1,5,0);
        pieceList1.add(piece);
        board.getMap()[5][0] = piece;
        piece = new Piece("Kn",1,1,0);
        pieceList1.add(piece);
        board.getMap()[1][0] = piece;
        piece = new Piece("Kn",1,6,0);
        pieceList1.add(piece);
        board.getMap()[6][0] = piece;

        piece = new Piece("K",2,3,7);
        pieceList2.add(piece);
        board.getMap()[3][7] = piece;
        piece = new Piece("Q",2,4,7);
        pieceList2.add(piece);
        board.getMap()[4][7] = piece;
        piece = new Piece("R",2,0,7);
        pieceList2.add(piece);
        board.getMap()[0][7] = piece;
        piece = new Piece("R",2,7,7);
        pieceList2.add(piece);
        board.getMap()[7][7] = piece;
        piece = new Piece("B",2,2,7);
        pieceList2.add(piece);
        board.getMap()[2][7] = piece;
        piece = new Piece("B",2,5,7);
        pieceList2.add(piece);
        board.getMap()[5][7] = piece;
        piece = new Piece("Kn",2,1,7);
        pieceList2.add(piece);
        board.getMap()[1][7] = piece;
        piece = new Piece("Kn",2,6,7);
        pieceList2.add(piece);
        board.getMap()[6][7] = piece;
    }

    //放置棋子 （x，y）坐标
    //playerIndex 用户号
    //type 棋子类型
    @Override
    public boolean add(int x, int y, int playerIndex, String type) {
        if(x >=  Board.CHESS_SIZE || x < 0 || y >= Board.CHESS_SIZE || y < 0){
            System.out.println("坐标错误,请重新输入");
            return false;
        }
        if(board.getMap()[x][y]!=null){
            System.out.println("坐标上已经有棋子了,请重新输入");
            return false;
        }
        boolean flag = false;
        for(String t:chessList){
            if(t.equals(type)){
                flag = true;
            }
        }
        if(!flag){
            System.out.println("棋子类型输入错误");
            return false;
        }
        Piece piece = null;
        if(playerIndex == 1){
            piece = player1.addPiece(x,y,type);
        }else{
            piece = player2.addPiece(x,y,type);
        }
        if(piece == null){
            System.out.println("棋盘下没有所选棋子了，不能添加棋子");
            return false;
        }
        board.getMap()[x][y] = piece;
        history.add("用户"+playerIndex+"放置了一个棋子"+type+"在坐标"+"("+x+","+y+")");
        board.setBoardCount(board.getBoardCount()+1);
        return true;
    }

    //吃子 （x1,y1),(x2,y2)
    //playerIndex 用户号
    @Override
    public boolean eat(int x1, int y1, int x2, int y2, int playerIndex) {
        if(x1 >=  Board.CHESS_SIZE || x1 < 0 || y1 >= Board.CHESS_SIZE || y1 < 0){
            System.out.println("原坐标错误");
            return false;
        }
        if(x2 >=  Board.CHESS_SIZE || x2 < 0 || y2>= Board.CHESS_SIZE || y2 < 0){
            System.out.println("新坐标错误");
            return false;
        }
        if(x1 == x2 && y1 == y2){
            System.out.println("两个坐标相同");
            return false;
        }
        if(board.getMap()[x1][y1]==null){
            System.out.println("原坐标没有棋子");
            return false;
        }if(board.getMap()[x2][y2]==null){
            System.out.println("新坐标没有棋子");
            return false;
        }
        if(board.getMap()[x1][y1].getPlayerIndex()!=playerIndex) {
            System.out.println("原坐标上不是你的棋子");
            return false;
        }
        if(board.getMap()[x2][y2].getPlayerIndex()==playerIndex) {
            System.out.println("新坐标上是你的棋子");
            return false;
        }
        Piece piece = board.getMap()[x2][y2];
        board.getMap()[x2][y2] = board.getMap()[x1][y1];
        board.getMap()[x1][y1] = null;
        board.setBoardCount(board.getBoardCount()-1);

        if(playerIndex == 1){
            player2.deletePiece(piece);
        }
        else{
            player1.deletePiece(piece);
        }
        history.add("用户"+playerIndex+"移动"+"("+x1+","+y1+")棋子吃了("+x2+","+y2+")棋子");
        return true;
    }


    //查询坐标
    @Override
    public void query(int x,int y) {
        if(x >=  Board.CHESS_SIZE || x < 0 || y >= Board.CHESS_SIZE || y < 0){
            System.out.println("坐标错误,请重新输入");
            return;
        }
        Piece piece = board.getMap()[x][y];
        if(piece == null){
            System.out.println("当前位置没有棋子");
        }else {
            System.out.println("当前位置有用户"+piece.getPlayerIndex()+"的棋子"+piece.getType());
        }
    }
}
