import java.util.List;

public class GoGame extends Game {

    public GoGame(String name1, String name2){
        player1 = new Player(name1);
        player2 = new Player(name2);
        board = new Board(0);
        init();
    }

    //围棋初始化
    @Override
    public void init() {
        List<Piece> pieces1= player1.getPiecesOut();
        for(int i=0;i<180;i++){
            pieces1.add(new Piece("w",1,-1,-1));
        }

        List<Piece> pieces2= player2.getPiecesOut();
        for(int i=0;i<180;i++){
            pieces2.add(new Piece("b",2,-1,-1));
        }
    }


    //放置棋子 （x，y）坐标
    //playerIndex 用户号
    //type 棋子类型
    @Override
    public boolean add(int x,int y,int playerIndex,String type) {
        if(x >=  Board.GO_SIZE || x < 0 || y >= Board.GO_SIZE || y < 0){
            System.out.println("坐标错误,请重新输入");
            return false;
        }
        if(board.getMap()[x][y]!=null){
            System.out.println("坐标上已经有棋子了,请重新输入");
            return false;
        }
        Piece piece ;
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
        if(x1 >=  Board.GO_SIZE || x1 < 0 || y1 >= Board.GO_SIZE || y1 < 0){
            System.out.println("坐标错误");
            return false;
        }
        if(board.getMap()[x1][y1] == null){
            System.out.println("该坐标位置上没有棋子");
            return false;
        }
        Piece piece = board.getMap()[x1][y1];
        if(piece.getPlayerIndex()== playerIndex){
            System.out.println("该坐标上棋子是自己的");
            return false;
        }
        board.getMap()[x1][y1] = null;
        player1.deletePiece(piece);
        history.add("用户"+playerIndex+"提子"+"("+x1+","+y1+")");
        board.setBoardCount(board.getBoardCount()-1);
        return true;
    }

    //查询坐标
    @Override
    public void query(int x,int y) {
        if(x >=  Board.GO_SIZE || x < 0 || y >= Board.GO_SIZE || y < 0){
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
