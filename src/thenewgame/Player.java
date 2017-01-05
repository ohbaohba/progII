package thenewgame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;


public class Player {
    
    //Playerの座標
    double x, y;
    //Playerの速度
    double vx, vy;
    //Playerの表示/非表示
    boolean hide = false;
    //ジャンプしたかどうか
    boolean jump = false;
    //前のジャンプボタンの状態
    boolean oldJump = false;
    //x回ジャンプカウント
    int jumpCount = 2;
    int jumpCountBuff = jumpCount;
    //ジャンプを受け付ける最大フレーム数
    int jumpValue = 15;
    int jumpValueBuff = jumpValue;
    
    //押されたキーの状態
    boolean W = false, 
            A = false, 
            S = false, 
            D = false, 
            SP = false;
    
    private final int WIDTH;
    private final int HEIGHT;
    
    public Player(int width, int height){
        WIDTH = width;
        HEIGHT = height;
    }
    
    //フレームごとに呼び出される
    public void repaintPlayer(Graphics2D g2, double G){
        
        /*---重力の処理---*/
        if(y >= (HEIGHT - 100)){
            vy = 0;
            y = (HEIGHT - 100);
        }else{
            vy += G;
        }
        
        /*---操作に対する処理---*/
        //ジャンプ
        boolean W_buff = W;//判定中のキー変更を受け付けないため
        if(W_buff){
            if(jumpValueBuff > 0 && jumpCountBuff > 0){
                vy = -10;
                jumpValueBuff--;
            }
        }else{
            jumpValueBuff = jumpValue;
            if(oldJump != W_buff){
                jumpCountBuff--;
            }
        }
        oldJump = W_buff;
        
        //if(地面についてるか判定){}
        if(y == (HEIGHT - 100)){
            jumpCountBuff = jumpCount;
        }
        
        
        //左右移動
        if(A && !D){
            vx = -10;
        }else if(D && !A){
            vx = 10;
        }else{
            vx = 0;
        }
        
        //未実装
        if(S){
            //未実装
        }
        
        /*---移動！---*/
        x += vx;
        y += vy;
        
        g2.setColor(Color.RED);
        g2.fill(new Ellipse2D.Double(x, y, 50.0d, 100.0d));
    }
    
    //プレイヤーを隠したりつけたり
    public void hidePlayer(boolean hide){
        this.hide = hide;
    }
}
