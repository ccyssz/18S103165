import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name ;
    private List<String> history= new ArrayList<String>();
    //在棋盘上的棋子
    private List<Piece> piecesIn = new ArrayList<>();
    //没在棋盘上的棋子
    private List<Piece> piecesOut = new ArrayList<>();
    private int piecesCount;

    public Player(){}

    public Player(String name){
        this.name = name;
    }

    public int getPiecesCount() {
        return piecesCount;
    }

    public void setPiecesCount(int piecesCount) {
        this.piecesCount = piecesCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }

    public List<Piece> getPiecesIn() {
        return piecesIn;
    }

    public void setPiecesIn(List<Piece> piecesIn) {
        this.piecesIn = piecesIn;
    }

    public List<Piece> getPiecesOut() {
        return piecesOut;
    }

    public void setPiecesOut(List<Piece> piecesOut) {
        this.piecesOut = piecesOut;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", history=" + history +
                ", piecesIn=" + piecesIn +
                ", piecesOut=" + piecesOut +
                ", piecesCount=" + piecesCount +
                '}';
    }

    //添加一个棋子
    public Piece addPiece(int x,int y,String type){
        for(int i=0;i<piecesOut.size();i++){
            if(piecesOut.get(i).getType().equals(type)){
                Piece piece = piecesOut.remove(i);
                piece.getPosition().setX(x);
                piece.getPosition().setY(y);
                piecesIn.add(piece);
                history.add("用户"+name+"放置了一个棋子"+type+"在坐标"+"("+x+","+y+")");
                piecesCount = piecesCount +1;
                return piece;
            }
        }
        return null;
    }

    //删除一个棋子
    public void deletePiece(Piece piece){
        Position position = piece.getPosition();
        for(int i=0;i<piecesIn.size();i++){
            if(position.equals(piecesIn.get(i).getPosition())){

                piecesIn.remove(i);
                piece.getPosition().setX(-1);
                piece.getPosition().setY(-1);
                piecesOut.add(piece);
                piecesCount = piecesCount - 1;
                history.add("用户"+name+"移去一个棋子"+piece.getType());
            }
        }
    }
}
