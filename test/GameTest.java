import org.junit.Test;

public class GameTest {

    @Test
    public void countTest(){
        String name1 = "c";
        String name2 = "y";
        System.out.println("-------围棋-------");
        Game game = new GoGame(name1,name2);
        game.count();
        System.out.println("-------国际象棋-------");
        Game game2 = new ChessGame(name1,name2);
        game2.count();
    }

    @Test
    public void moveTest(){
        String name1 = "c";
        String name2 = "y";
        System.out.println("-------国际象棋-------");
        Game game2 = new ChessGame(name1,name2);
        game2.move(1,1,3,3,1,"P",1);
        System.out.println(game2.history);
    }

    @Test
    public void addTest(){
        String name1 = "c";
        String name2 = "y";
        System.out.println("-------围棋-------");
        Game game = new GoGame(name1,name2);
        game.add(3,4,1,"w");
        System.out.println(game.history);
    }

    @Test
    public void queryTest(){
        String name1 = "c";
        String name2 = "y";
        Game game = new ChessGame(name1,name2);
        game.query(1,1);
    }

    @Test
    public void eatTest(){
        String name1 = "c";
        String name2 = "y";
        Game game = new ChessGame(name1,name2);
        game.eat(0,0,7,7,1);
        System.out.println(game.history);
    }

    @Test
    public void endTest(){
        String name1 = "c";
        String name2 = "y";
        Game game = new ChessGame(name1,name2);
        game.eat(0,0,7,7,1);
        game.end();
    }


}
