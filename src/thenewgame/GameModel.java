package thenewgame;


//モデルだけど使い方あってんの？まぁいいや
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GameModel extends JPanel{
    
    private final int WIDTH, HEIGHT;
    
    public Player player;
    public Scene scene = new Scene();
    //重力ksk度
    public double G = 1.0;
    
    public GameModel(int width, int height){
        WIDTH = width;
        HEIGHT = height;
        player = new Player(WIDTH, HEIGHT);
    }
    //画面更新！
    public void update(Graphics2D g2){
        //Playerを描画
        player.repaintPlayer(g2, G);
    }
    
    //プレイヤー消去
    public void deletePlayer(){
        player = null;
    }
}
