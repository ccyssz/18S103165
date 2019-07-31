import java.util.ArrayList;
import java.util.List;

public abstract class Game implements Action{
    protected Player player1;
    protected Player player2;
    protected Board board;
    protected List<String> history = new ArrayList<>();
    public Game(){
    }

    //返回棋盘上棋子数
    @Override
    public void count() {
        System.out.println("棋盘上棋子总数:"+board.getBoardCount());
        System.out.println(player1.getName()+"棋子总数"+player1.getPiecesCount());
        System.out.println(player2.getName()+"棋子总数"+player2.getPiecesCount());
    }

    //结束游戏，打印游戏记录
    @Override
    public void end() {
        for(String s:history){
            System.out.println(s);
        }
    }

    //移动棋子(x1,y1) (x2,y2)
    //playerIndex用户id
    //type棋子类型
    //t游戏类型
    @Override
    public boolean move(int x1, int y1, int x2, int y2, int playerIndex, String type,int t) {
        if(t==0){
            if(x1 >=  Board.GO_SIZE || x1 < 0 || y1 >= Board.GO_SIZE || y1 < 0){
                System.out.println("原坐标错误");
                return false;
            }
            if(x2 >=  Board.GO_SIZE || x2 < 0 || y2 >= Board.GO_SIZE || y2 < 0){
                System.out.println("新坐标错误");
                return false;
            }
        }else{
            if(x1 >=  Board.CHESS_SIZE || x1 < 0 || y1 >= Board.CHESS_SIZE || y1 < 0){
                System.out.println("原坐标错误");
                return false;
            }
            if(x2 >=  Board.CHESS_SIZE || x2 < 0 || y2>= Board.CHESS_SIZE || y2 < 0){
                System.out.println("新坐标错误");
                return false;
            }
        }

        if(x1 == x2 && y1 == y2){
            System.out.println("两个坐标相同");
            return false;
        }
        if(board.getMap()[x1][y1]==null){
            System.out.println("原坐标上没有棋子可以移动");
            return false;
        }
        if(!board.getMap()[x1][y1].getType().equals(type)){
            System.out.println("原坐标移动棋子类型错误");
            return false;
        }
        if(board.getMap()[x1][y1].getPlayerIndex()!=playerIndex){
            System.out.println("不是你的棋子");
            return false;
        }
        if(board.getMap()[x2][y2]!=null){
            System.out.println("新坐标上有棋子了，不能移动");
            return false;
        }
        Piece piece = board.getMap()[x1][y1];
        board.getMap()[x1][y1] = null;
        piece.getPosition().setX(x2);
        piece.getPosition().setY(y2);
        board.getMap()[x2][y2] = piece;
        history.add("用户"+playerIndex+"移动了一个棋子"+type+"从坐标"+"("+x1+","+y1+")到坐标（"+x2+","+y2+")");
        return true;
    }




}
