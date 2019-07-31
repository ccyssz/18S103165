import org.junit.Test;

import java.util.List;

public class PlayerTest {

    @Test
    public void addPieceTest(){
        Player player = new Player("cys");
        List<Piece> listOut = player.getPiecesOut();
        listOut.add(new Piece("w",1,-1,-1));
        player.addPiece(3,4,"w");
        System.out.println(player.getHistory());
    }

    @Test
    public void deletePieceTest(){
        Player player = new Player("cys");
        List<Piece> listIn = player.getPiecesIn();
        listIn.add(new Piece("w",1,3,4));
        player.deletePiece(new Piece("w",1,3,4));
        System.out.println(player.getHistory());
    }


}
