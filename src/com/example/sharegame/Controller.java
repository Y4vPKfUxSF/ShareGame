package com.example.sharegame;

import java.util.Random;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.Log;

/**
 * @author kkouji
 */
public class Controller {
    private static String E_CHAR_KEY="enemy_id";
    private static int E_CHAR_COUNT=3;
    private CharCount cCount;
    private boolean waitFlg;
    private Handler mHandler;
    private SharedPreferences pref;
    private Bitmap pCharImage;
    private Bitmap eCharImage;

    /**
     * コンストラクタ
     * 
     * @param activity
     */
    public Controller(Context c) {
        cCount = (CharCount) c.getApplicationContext();
        waitFlg = false;
        pref = c.getSharedPreferences("enemy_id_data",Context.MODE_PRIVATE);
        pCharImage=BitmapFactory.decodeResource(c.getResources(), R.drawable.crabe_a03);
        eCharImage=BitmapFactory.decodeResource(c.getResources(), R.drawable.crow_a03);
    }

    /**
     * プレイヤーを生成し返す
     * 
     * @return
     */
    public PlayCharacter getPChar() {
        // 生成条件に合致するか確認
        if (pCharValidIsTrue()) {
            cCount.playerAddition();
            return new PlayCharacter(pCharImage, 9, 100,550,0);
        } else {
            return null;
        }
    }

    /**
     * 敵キャラオブジェクトを生成し返す
     * 
     * @return
     */
    public Enemy getEChar(float width, float height) {
        // 生成条件に合致するか確認
        if (eCharValidIsTrue()) {
            // タイミングを見計らう処理
            //getEnemyReturnTiming();
            //cCount.enemyAddtion();
            return new Enemy(0, eCharImage, width, getECharYPosition(height), 0);
        }
        return null;
    }

    /**
     * 敵キャラオブジェクト解放時に呼ぶ
     * 
     * @return
     */
    public void removeEChar(Enemy enemy) {
        //使用中フラグを折る
        SharedPreferences.Editor e = pref.edit();
        e.putBoolean(E_CHAR_KEY+enemy.getId(), false).commit();
        //敵キャラカウントを減らす
        if (cCount.getECount() > 0) {
            cCount.enemySubtraction();
        }
        enemy = null;
    }

    /**
     * プレイヤーオブジェクト解放時に呼ぶ
     */
    public void removePChar(PlayCharacter pChar) {
        if (cCount.getPCount() > 0) {
            cCount.playerSubtraction();
        }
        pChar = null;
    }

    /**
     * 敵キャラが生成条件に一致する場合Trueを返す
     * 
     * @return
     */
    private boolean eCharValidIsTrue() {
        // ゲーム画面内で敵が3体より少なく、待ちがなければTrue
        if (cCount.getECount() <= 3 && !waitFlg) {
            return true;
        }
        return false;
    }

    /**
     * プレイキャラクタが生成条件に一致する場合Trueを返す
     */
    private boolean pCharValidIsTrue() {
        // ゲーム画面内でプレイヤーがいなければTrue
        if (cCount.getPCount() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 敵キャラ生成のタイミングを見計らう
     */
    private void getEnemyReturnTiming() {
        waitFlg = true;
        mHandler = new Handler();
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    // 3秒以内待つ
                    Thread.sleep((long) (Math.random() * 3000));
                } catch (InterruptedException e) {
                    Log.d("", e.getMessage());
                }
            }
        });
        waitFlg = false;
    }

    /**
     * 敵キャラのY座標点をランダムに返す
     * 
     * @return
     */
    private float getECharYPosition(float height) {
        return height / (float) ((Math.random() * 5) + 1);
    }

    /**
     * 敵キャラに振る一意のIDを返す
     * 
     * @return
     */
    private int getEnemyId() {
        for(int i= 0;i<E_CHAR_COUNT;i++){
            if (!pref.getBoolean(E_CHAR_KEY+i, false)){
                SharedPreferences.Editor e = pref.edit();
                e.putBoolean(E_CHAR_KEY+i, true).commit();
                return i;
            }
        }
        return -1;
    }

}