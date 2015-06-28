package com.example.sharegame;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

//イメージ描画
public class GameView extends View{
    /** Called when the activity is first created. */
	//定数の定義
	public static final float SCREEN_X = 1080;
    public static final float SCREEN_Y = 1920;
	public static final int GROUND = 1300; //地面の座標
	public int ENEMY = 3;
	
	private Bitmap image2, image3; //イメージ画像
	public float c_x = 123, c_y = GROUND;; //キャラ初期座標
	public int ec_x = 410, ec_y = 600; //蜂初期座標
	public float sy = 0.0f; //ジャンプ力
	public int csizex = 300, csizey = 203; //キャラサイズ
	public int esizex = 300, esizey = 203; //蜂サイズ
	public int go_flag = 0; //GameOver判定
	private Handler mHandler = new Handler();
	private Controller controller;
	private PlayCharacter pChar;
	Enemy[] Enemy = new Enemy[ENEMY];
	
	//端末の画面サイズを計算
    WindowManager wm = (WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
    Display disp = wm.getDefaultDisplay();
    float width = disp.getWidth();
    float height = disp.getHeight();
    //画面サイズに合わせて表示させるための係数
    float CX = width / SCREEN_X;
    float CY = height / SCREEN_Y;    
		
	public GameView(Context context) {
		super(context);
		controller = new Controller(context);
		setBackgroundColor(Color.BLUE); //背景色

		//画像読み込み
		Resources r =context.getResources();
		image2=BitmapFactory.decodeResource(r, R.drawable.crow_a03);
		image3=BitmapFactory.decodeResource(r, R.drawable.gameover);
		
		pChar = controller.getPChar();
		
		Enemy[0] = controller.getEChar(1280, 500);
		Enemy[1] = controller.getEChar(1280, 1000);
		Enemy[2] = controller.getEChar(1280, 1500);
		
		Timer mTimer = new Timer();
        mTimer.schedule( new TimerTask(){
            @Override
            public void run() {
                mHandler.post( new Runnable() {
                    public void run() {
                        invalidate();
                        pCharMove();
                        eCharMove();
                        judge();
                        eCharControl();
                    }
                });
            }
        }, 20, 20);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		pCharDraw(canvas, pChar.getCharX(), pChar.getCharY()*CY); //熊の描画
		for(int i = 0; i < Enemy.length; i++) {
			eCharDraw(canvas, Enemy[i].getCharX()*CX, Enemy[i].getCharY()*CY); //蜂の描画
		}
		if(go_flag == 1) canvas.drawBitmap(image3, 0, 0,null); //GameOver
	}
	
	//タッチイベント処理
	public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
        	if(pChar.getPosition() == 0) charJump();
            break;
        case MotionEvent.ACTION_MOVE:
        	pChar.setCharX(event.getX()-(csizex/4));
            break;
        case MotionEvent.ACTION_UP:
            break;
        default:
            break;
        }
        return true;
    }
	
	public void charJump() {
		pChar.setPosition(1); //ジャンプ中状態にする
		sy = -30.f; //ジャンプ力
		c_y += sy; //慣性力
		sy += 0.2f; //重力
	}
	
	public void judge() {
		//蜂と熊がぶつかったときの判定
		for(int i = 0; i < Enemy.length; i++) {
			if(pChar.getCharX() < ((Enemy[i].getCharX() + esizex)*CX) && (pChar.getCharX() + csizex*CX) > Enemy[i].getCharX()*CX && pChar.getCharY()*CY < ((Enemy[i].getCharY() + esizey)*CY) && ((pChar.getCharY() + csizey)*CY) > Enemy[i].getCharY()*CY) {
				go_flag = 1; //GameOverのフラグを立てる
				
				Intent intent = new Intent(getContext(),ResultActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				intent.putExtra("result","GameOverです！！");
				getContext().startActivity(intent);
				//getContext().startActivity(new Intent(getContext(), MenuActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
			}
		}
		
		//地面との判定
		if(pChar.getCharY() >= GROUND) {
			pChar.setCharY(GROUND);//地面
			pChar.setPosition(0); //地上にいる状態にする
		}
		
		//左右画面端の判定
		if(pChar.getCharX() <= 0) {
			pChar.setCharX(0);
		} else if(pChar.getCharX() >= (SCREEN_X - csizex) * CX) {
			pChar.setCharX((SCREEN_X - csizex) * CX);
		}
		
		//ゴールした時の処理
	}
	
	public void pCharMove() {
		//キャラの移動
		pChar.setCharY(pChar.getCharY() + (c_y - pChar.getCharY())/2.4f);
        
        //空中にいる際の処理
  		if(c_y < GROUND) {
  			c_y += sy; //慣性力
  			sy += 0.5f; //重力
  		}
	}
	
	public void eCharMove() {
		for(int i = 0; i < Enemy.length; i++) {
			if(go_flag == 0) Enemy[i].setCharX(Enemy[i].getCharX() - i * 2 % 3 - 3); //蜂の移動
		}
	}
	
	public void pCharDraw(Canvas canvas, float x, float y) {
		canvas.drawBitmap(pChar.getpCharImage(), x, y, null);
	}
	
	public void eCharDraw(Canvas canvas, float x, float y) {
		if(x > -esizex && x < SCREEN_X+esizex) canvas.drawBitmap(image2, x, y, null);
	}
	
	public void eCharControl() {
		Random r = new Random();
		int n = r.nextInt(1280);
		for(int i = 0; i < ENEMY; i++) { 
			if(Enemy[i].getCharX() < -esizex) Enemy[i] = controller.getEChar((1280 + n), 1080);
		}
	}
	
	public void setPref(boolean gameflg) {
		//ゲーム終了時の情報を保存
	}
}
