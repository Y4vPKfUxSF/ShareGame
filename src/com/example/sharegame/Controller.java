package com.example.sharegame;

import java.util.List;
import java.util.Map;

import android.R.integer;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.util.Log;

/**
 * @author kkouji
 */
public class Controller {
    private CharCount cCount;
    private boolean waitFlg;
    private Handler mHandler;
    private SharedPreferences pref;

    /**
     * コンストラクタ
     * 
     * @param activity
     */
    public Controller(Context c) {
        cCount = (CharCount) c.getApplicationContext();
        waitFlg = false;
        pref = c.getSharedPreferences("enemy_id_data",c.MODE_PRIVATE);
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
            return new PlayCharacter(pCharImage, gravity, charX, charY,position);
        } else {
            return null;
        }
    }

    /**
     * 敵キャラオブジェクトを生成し返す
     * 
     * @return
     */
    public Enemy getEChar(int width, int height) {
        // 生成条件に合致するか確認
        if (eCharValidIsTrue()) {
            // タイミングを見計らう処理
            getEnemyReturnTiming();
            cCount.enemyAddtion();
            return new Enemy(getEnemyId(), eCharImage, width, getECharYPosition(height), 0);
        }
        return null;
    }

    /**
     * 敵キャラオブジェクト解放時に呼ぶ
     * 
     * @return
     */
    public void removeEChar(Enemy enemy) {
        enemy = null;
        if (cCount.getECount() > 0) {
            cCount.enemySubtraction();
        }
    }

    /**
     * プレイヤーオブジェクト解放時に呼ぶ
     */
    public void removePChar(PlayCharacter pChar) {
        pChar = null;
        if (cCount.getPCount() > 0) {
            cCount.playerSubtraction();
        }
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
    private int getECharYPosition(int height) {
        return height / (int) ((Math.random() * 5) + 1);
    }

    /**
     * 敵キャラに振る一意のIDを返す
     * 
     * @return
     */
    private int getEnemyId() {
        for(int i= 0;i<3;i++){
            if (!pref.getBoolean(String.valueOf(i), false)){
                Editor e = pref.edit();
                e.putBoolean(String.valueOf(i), true);
                return i;
            }
        }
        return 4;
    }

}