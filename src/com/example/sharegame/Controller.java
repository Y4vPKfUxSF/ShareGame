package com.example.sharegame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * @author kkouji
 */
public class Controller {
    private Bitmap pCharImage;
    private Bitmap eCharImage;

    /**
     * コンストラクタ
     * 
     * @param activity
     */
    public Controller(Context c) {
        pCharImage = BitmapFactory.decodeResource(c.getResources(),
                R.drawable.crabe);
        eCharImage = BitmapFactory.decodeResource(c.getResources(),
                R.drawable.crow);
    }

    /**
     * プレイヤーを生成し返す
     * 
     * @return
     */
    public PlayCharacter getPChar() {
        return new PlayCharacter(pCharImage, 9, 100, 550, 0);
    }

    /**
     * 敵キャラオブジェクトを生成し返す
     * 
     * @return
     */
    public Enemy getEChar(int width, int height) {
        return new Enemy(0, eCharImage, width, getECharYPosition(height), 0);
    }

    /**
     * 敵キャラのY座標点をランダムに返す
     * 
     * @return
     */
    private int getECharYPosition(int height) {
        return (int) (Math.random () * 996);
    }

}