package com.example.sharegame;

import android.app.Application;

public class EnemyCount extends Application{
	
	/**
	 * 敵キャラの数情報を保持する
	 */
	private int eCount;
	
	/**
	 * インスタンス化禁止
	 */
	private EnemyCount(){
	}
	
	/**
	 * 初期化する為の関数
	 */
	public void init(){
		eCount=0;
	}
	
	/**
	 * 現在の敵キャラ総数を返す
	 * @return　敵キャラ総数
	 */
	public int getECount(){
		return eCount;
	}
	
	/**
	 * 敵キャラ総数にプラス1する
	 */
	public void addtion(){
		eCount++;
	}

	/**
	 * 敵キャラ総数からマイナス1する
	 */
	public void subtraction(){
		eCount--;
	}
}
