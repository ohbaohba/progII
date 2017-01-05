package thenewgame;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//コントローラっすね
public class GameControler extends KeyAdapter{
    GameModel model;
    public GameControler(TheNewGame view, GameModel model){
        view.addKeyListener(new MyKeyListener());
        this.model = model;
    }
    class MyKeyListener extends KeyAdapter{
        @Override
        //押された時
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                //上
                case KeyEvent.VK_W:
                    model.player.W = true;
                    break;
                //左
                case KeyEvent.VK_A:
                    model.player.A = true;
                    break;
                //下
                case KeyEvent.VK_S:
                    model.player.S = true;
                    break;
                //右
                case KeyEvent.VK_D:
                    model.player.D = true;
                    break;
                //攻撃
                case ' ':
                    model.player.SP = true;
                    break;
            }
        }
        
        //離された時
        @Override
        public void keyReleased(KeyEvent e){
            switch(e.getKeyCode()){
                //上
                case KeyEvent.VK_W:
                    model.player.W = false;
                    break;
                //左
                case KeyEvent.VK_A:
                    model.player.A = false;
                    break;
                //下
                case KeyEvent.VK_S:
                    model.player.S = false;
                    break;
                //右
                case KeyEvent.VK_D:
                    model.player.D = false;
                    break;
                //攻撃
                case KeyEvent.VK_SPACE:
                    model.player.SP = false;
                    break;
            }
        }
    }
}
