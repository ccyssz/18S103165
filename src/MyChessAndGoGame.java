import java.util.Scanner;

public class MyChessAndGoGame {
    public static void main(String[] args){
        String name1;
        String name2;
        String type;
        Game game ;
        String op="x";
        int playIndex = 1;
        Scanner in = new Scanner(System.in);

        System.out.println("请输入要参加的游戏名称：chess  or  go        ");
        System.out.println("请输入：");
        type = in.next();
        while(!(type.equals("chess") || type.equals("go"))){
            System.out.println("游戏名称输入错误，请重新输入：");
            type = in.next();
        }
        System.out.println("请输入玩家1的昵称：");
        name1 = in.next();
        System.out.println("请输入玩家2的昵称：");
        name2 = in.next();


        //初始化游戏
        if(type.equals("chess")){
            game = new ChessGame(name1,name2);
        }else{
            game = new GoGame(name1,name2);
        }
        while(true){
            try {
                if(!op.equals("")){
                    System.out.println("用户"+playIndex+"输入操作：放置棋子add 移动棋子move 吃子或提子eat 查询棋子占用情况query 查询棋盘上棋子数量count 跳过continue 结束游戏end");
                }
                op = in.next().trim();
                //count
                if("count".equals(op)){
                    game.count();
                //end
                }else if("end".equals(op)){
                    System.out.println("是否要查看走棋记录  1是  2否");
                    int flag = in.nextInt();
                    while(true){
                        if(flag == 1){
                            game.end();
                            System.out.println("游戏结束，再见！");
                            break;
                        }else if(flag == 2){
                            System.out.println("游戏结束，再见！");
                            break;
                        }else {
                            System.out.println("输入错误，游戏结束");
                            flag = in.nextInt();
                        }
                    }
                    break;
                 //add
                }else if("add".equals(op)){
                    boolean res = false;
                    System.out.println("请输入棋子x坐标：");
                    int x = in.nextInt();
                    System.out.println("请输入棋子y坐标：");
                    int y = in.nextInt();
                    if(type.equals("chess")){
                        System.out.println("请输入棋子类型P,K,Q,R,B,Kn");
                        String t = in.next();
                        res = game.add(x,y,playIndex,t);
                    }else{
                        if(playIndex == 1){
                            res = game.add(x,y,playIndex,"w");
                        }else{
                            res = game.add(x,y,playIndex,"b");
                        }
                    }
                    if(res == true){
                        if(playIndex == 1){
                            playIndex = 2;
                        }else {
                            playIndex =1;
                        }
                        System.out.println("操作成功");
                    }

                }
                //move
                else if("move".equals(op)){
                    System.out.println("请输入棋子原x坐标：");
                    int x1 = in.nextInt();
                    System.out.println("请输入棋子原y坐标：");
                    int y1 = in.nextInt();
                    System.out.println("请输入棋子新x坐标：");
                    int x2 = in.nextInt();
                    System.out.println("请输入棋子新y坐标：");
                    int y2 = in.nextInt();
                    boolean res = false ;
                    if(type.equals("chess")){
                        System.out.println("请输入棋子类型P,K,Q,R,B,Kn");
                        String t = in.next();
                        res = game.move(x1,y1,x2,y2,playIndex,t,1);
                    }else{
                        if(playIndex == 1){
                            res =  game.move(x1,y1,x2,y2,playIndex,"w",0);
                        }
                        else{
                            res = game.move(x1,y1,x2,y2,playIndex,"b",0);
                        }
                    }
                    if(res == true){
                        if(playIndex == 1){
                            playIndex = 2;
                        }else {
                            playIndex =1;
                        }
                        System.out.println("操作成功");
                    }
                }
                //continue
                else if("continue".equals(op)){
                    if(playIndex == 1){
                        playIndex = 2;
                    }else {
                        playIndex =1;
                    }
                }
                //query
                else if("query".equals(op)){
                    System.out.println("请输入棋子x坐标：");
                    int x = in.nextInt();
                    System.out.println("请输入棋子y坐标：");
                    int y = in.nextInt();
                    game.query(x,y);
                    //eat
                }else if("eat".equals(op)){
                    System.out.println("请输入棋子x1坐标：");
                    int x1 = in.nextInt();
                    System.out.println("请输入棋子y1坐标：");
                    int y1 = in.nextInt();
                    boolean res = false;
                    if(type.equals("chess")){
                        System.out.println("请输入棋子x2坐标：");
                        int x2 = in.nextInt();
                        System.out.println("请输入棋子y2坐标：");
                        int y2 = in.nextInt();
                        res = game.eat(x1,y1,x2,y2,playIndex);
                    }else{
                        if(playIndex == 1){
                            res = game.eat(x1,y1,-1,-1,playIndex);
                        }
                        else{
                            res = game.eat(x1,y1,-1,-1,playIndex);
                        }
                    }

                    if(res == true){
                        if(playIndex == 1){
                            playIndex = 2;
                        }else {
                            playIndex =1;
                        }
                        System.out.println("操作成功");
                    }

                }

            }catch (Exception e){
                System.out.println("输入错误请重新输入");
            }

        }

    }
}
