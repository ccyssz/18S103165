public interface Action {
    //吃子
    public boolean add(int x,int y,int playerIndex,String type);

    //查询棋子个数
    public void count();

    //结束游戏
    public void end();

    //查询某个坐标棋子
    public void query(int x,int y);


    //吃子或者提子
    public boolean eat(int x1,int y1,int x2,int y2,int playerIndex);


    //移动棋子
    public boolean move(int x1,int y1,int x2,int y2,int playerIndex,String type,int t);

    //初始化游戏
    public void init();

}
