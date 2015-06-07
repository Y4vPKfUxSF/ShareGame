package com.example.sharegame;

import android.app.Activity;

/**
 * @author kkouji
 */
public class Controller {
    private CharCount cCount;

    /**
     * コンストラクタ
     * 
     * @param activity
     */
    public Controller(Activity activity) {
        cCount = (CharCount) activity.getApplication();
    }
    
    /**
     * プレイヤーを生成し返す
     * @return
     */
    public PlayCharacter getPlayChar() {
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
     * @return
     */
    public Enemy getEChar() {
        // 生成条件に合致するか確認
        if (eCharValidIsTrue()) {
            cCount.enemyAddtion();
            return new Enemy(eCharImage, charX, charY, color);
        } else {
            return null;
        }
    }
    
    /**
     * 敵キャラオブジェクト解放時に呼ぶ
     * @return
     */
    public boolean removeEChar(){
        if(cCount.getECount() > 0){
            cCount.enemySubtraction();
            return true;
        }
        return false;
    }
    
    /**
     * プレイヤーオブジェクト解放時に呼ぶ
     */
    public boolean removePChar(){
        if(cCount.getPCount() > 0){
            cCount.playerSubtraction();
            return true;
        }
        return false;
    }

    /**
     * 敵キャラが生成条件に一致する場合Trueを返す
     * 
     * @return
     */
    private boolean eCharValidIsTrue() {
        // ゲーム画面内で敵が3体より少なければTrue
        if (cCount.getECount() <= 3) {
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
}
