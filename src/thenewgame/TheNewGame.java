package thenewgame;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

//びゅぅ
public class TheNewGame extends JFrame implements ActionListener{
    
    public static int WIDTH = 1024;
    public static int HEIGHT = 800;
    
    private static GameModel model = new GameModel(WIDTH, HEIGHT);
    private Timer timer;
    
    
    public TheNewGame(){
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(WIDTH, HEIGHT));
        
        //サイズ合わせ(⑨なのでよく分かっていない)
        Container contentPane = getContentPane();
        contentPane.add(new GamePane(WIDTH, HEIGHT));
        this.pack();
        this.setBackground(Color.black);
        
        this.setVisible(true);
        
        //フレーム更新用Timer
        timer = new Timer(16, this);
        timer.start();
    }

    public static void main(String[] args) {
        TheNewGame view = new TheNewGame();
        new GameControler(view, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    //描画用パネルクラス
    class GamePane extends JPanel{
        public GamePane(int width, int height){
            this.setPreferredSize(new Dimension(width, height));
        }
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;

            //アンチエイリアス設定
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            
            //モデルを参照しに行こう
            model.update(g2);
            
        }
    }
}
