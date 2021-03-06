package com.example.sharegame;

import java.util.Random;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

//イメージ描画
public class GameView extends View {
    /**
     * デフォルト画面サイズを定義
     */
    private static final int SCREEN_X = 768;
    private static final int SCREEN_Y = 1280;

    /**
     * 地面のY座標点を指定
     */
    private static final int GROUND = (int) (SCREEN_Y-(SCREEN_Y/3));

    private Enemy[] enemy;
    private int enemySpeed;
    private Bitmap image2; // イメージ画像

    /**
     * キャラの座標点
     */
    private float charX;
    private float charY;

    /**
     * 蜂初期座標
     */
    private float echarX;
    private float echarY;

    /**
     * 端末の画面サイズ
     */
    private float deviceWidth;
    private float deviceHeight;

    /**
     * 画面サイズに合わせて表示させるための係数
     */
    private float cX;
    private float cY;

    /**
     * 画像サイズ
     */
    private int cSizeX;
    private int cSizeY;
    private int eSizeX;
    private int eSizeY;

    /**
     * ジャンプの高さ
     */
    private float sy = 0.0f;
    private float jumpHeight;
    public int go_flag = 0; // GameOver判定
    private Controller controller;
    private PlayCharacter pChar;
    private SharedPreferences pref;
    private long sysTime;
    private Paint p;
    public String miss,clear,game_to_clear,second;

    /**
     * コンストラクタ
     * 
     * @param context
     */
    public GameView(Context context) {
        super(context);
        controller = new Controller(context);
        setBackgroundColor(Color.BLUE); // 背景色

        // 画像読み込み
        Resources r = context.getResources();
        image2 = BitmapFactory.decodeResource(r, R.drawable.crow);

        // キャラ位置の初期化
        // プレイヤー
        charX = SCREEN_X / 9;
        charY = GROUND;

        // 敵キャラ
        echarX = SCREEN_X;
        echarY = SCREEN_Y;
        pChar = controller.getPChar();
        
        // 文字列
        miss = context.getString(R.string.result_text_miss);
        clear = context.getString(R.string.result_text_goal);
        game_to_clear = context.getString(R.string.game_to_clear);
        second = context.getString(R.string.second);

        pref = PreferenceManager.getDefaultSharedPreferences(context);
        String mexEnemyCountKey = context.getString(R.string.max_enemy_count);
        String enemySpeedKey = context.getString(R.string.enemy_speed);
        String jumpHeightKey = context.getString(R.string.jump_height);
        jumpHeight = Float.parseFloat(pref.getString(jumpHeightKey, "-25"));
        enemy = new Enemy[Integer.parseInt(pref
                .getString(mexEnemyCountKey, "3"))];
        enemySpeed = Integer.parseInt(pref.getString(enemySpeedKey, "2"));

        // eCharControl();
        for (int i = 0; i < enemy.length; i++) {
            enemy[i] = controller.getEChar(SCREEN_X, SCREEN_Y);
        }

        // 画面サイズを取得
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        deviceWidth = size.x;
        deviceHeight = size.y;

        // 画面サイズに合わせて表示させるための係数を代入
        cX = deviceWidth / SCREEN_X;
        cY = deviceHeight / SCREEN_Y;

        cSizeX = BitmapFactory.decodeResource(r, R.drawable.crabe)
                .getWidth();
        cSizeY = BitmapFactory.decodeResource(r, R.drawable.crabe)
                .getHeight();
        eSizeX = image2.getWidth();
        eSizeY = image2.getHeight();
        sysTime = System.currentTimeMillis();
        p = new Paint();
        p.setColor(Color.BLACK);
        p.setTextSize(50);
        p.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        pCharDraw(canvas, pChar.getCharX() * cX, pChar.getCharY() * cY); // 熊の描画
        for (int i = 0; i < enemy.length; i++) {
            eCharDraw(canvas, enemy[i].getCharX() * cX, enemy[i].getCharY()
                    * cY); // 蜂の描画
        }
        canvas.drawText(game_to_clear+String.valueOf(30-(System.currentTimeMillis()-sysTime)/1000+second), 40, 40, p);
        // ミリ秒指定で終了時間を決められる
        if(System.currentTimeMillis()-sysTime > 30000){
            go_flag = 1;
            getFinish(clear);
        }
        if (go_flag != 1) {
            pCharMove();
            eCharMove();
            judge();
            eCharControl();
            invalidate();
        }
    }

    private void getFinish(String msg) {
        Intent i = new Intent(getContext(), ResultActivity.class);
        i.putExtra("result_msg",msg);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getContext().startActivity(i);
    }

    // タッチイベント処理
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            if (pChar.getPosition() == 0)
                charJump();
            break;
        case MotionEvent.ACTION_MOVE:
            pChar.setCharX(event.getX() - (cSizeX * cX / 2));
            break;
        case MotionEvent.ACTION_UP:
            break;
        default:
            break;
        }
        return true;
    }

    public void charJump() {
        pChar.setPosition(1); // ジャンプ中状態にする
        sy = jumpHeight; // ジャンプ力
        charY += sy; // 慣性力
        sy += 0.2f; // 重力
    }

    public void judge() {
        // 蜂と熊がぶつかったときの判定
        for (int i = 0; i < enemy.length; i++) {
            if (pChar.getCharX() < (enemy[i].getCharX() + eSizeX)
                    && (pChar.getCharX() + cSizeX) > enemy[i].getCharX()
                    && pChar.getCharY() < (enemy[i].getCharY() + eSizeY)
                    && (pChar.getCharY() + cSizeY) > enemy[i].getCharY()) {
                go_flag = 1; // GameOverのフラグを立てる
                getFinish(miss);
            }
        }

        // 地面との判定
        if ((int) charY >= GROUND) {
            charY = GROUND; // 地面
            pChar.setPosition(0); // 地上にいる状態にする
        }

        // ゴールした時の処理
    }

    public void pCharMove() {
        // キャラの移動
        pChar.setCharY(pChar.getCharY() + (charY - pChar.getCharY()) / 2.4f);

        // 空中にいる際の処理
        if (charY < GROUND) {
            charY += sy; // 慣性力
            sy += 0.5f; // 重力
        }
    }

    public void eCharMove() {
        for (int i = 0; i < enemy.length; i++) {
            if (go_flag == 0)
                enemy[i].setCharX(enemy[i].getCharX() - i % 3 - enemySpeed); // 蜂の移動
        }
    }

    public void pCharDraw(Canvas canvas, float x, float y) {
        if(x < 0) {
        	canvas.drawBitmap(pChar.getpCharImage(), 0, y, null);
        } else if(x > SCREEN_X * cX - cSizeX) {
        	canvas.drawBitmap(pChar.getpCharImage(), SCREEN_X * cX - cSizeX, y, null);
        } else {
        	canvas.drawBitmap(pChar.getpCharImage(), x, y, null);
        }
    }

    public void eCharDraw(Canvas canvas, float x, float y) {
        if (x > -70 && x < 800)
            canvas.drawBitmap(image2, x, y, null);
    }

    public void eCharControl() {
        Random r = new Random();
        int n = r.nextInt(1000);
        for (int i = 0; i < enemy.length; i++) {
            if (enemy[i].getCharX() < -70)
                enemy[i] = controller.getEChar(SCREEN_X + n, SCREEN_Y);
        }
    }

}
