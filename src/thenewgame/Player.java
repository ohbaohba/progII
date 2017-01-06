package thenewgame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;


public class Player {
    //あばばば
    
    //Playerの座標
    double x, y;
    //Playerの速度
    double vx, vy;
    //Playerの表示/非表示
    boolean hide = false;
    //接地しているかどうか
    boolean air = false;
    //地面の座標
    int ground;
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
        
        ground = (HEIGHT - 100);
    }
    
    //フレームごとに呼び出される
    public void repaintPlayer(Graphics2D g2, double G){
        
        /*---重力の処理---*/
        if(!air){
            vy = 0;
            y = ground;
        }else{
            vy += G;
        }
        
        /*---操作に対する処理---*/
        //ジャンプ
        boolean W_buff = W;
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
        
        //着地した時
        if(!air){
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
        
        /*---空中か判定---*/
        //後でいじります
        air = (y < (HEIGHT - 100));
        ground = (HEIGHT - 100);
        
        g2.setColor(Color.RED);
        g2.fill(new Ellipse2D.Double(x, y, 50.0d, 100.0d));
    }
    
    //プレイヤーを隠したりつけたり
    public void setVisiblePlayer(boolean hide){
        this.hide = hide;
    }
}
