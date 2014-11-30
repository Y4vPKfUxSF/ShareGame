package com.example.sharegame;

import android.app.Application;

public class EnemyCount extends Application{
	
	/**
	 * 謨ｵ繧ｭ繝｣繝ｩ縺ｮ謨ｰ諠�蝣ｱ繧剃ｿ晄戟縺吶ｋ
	 */
	private int eCount;
	
	/**
	 * Application繧ｯ繝ｩ繧ｹ菴懈�先凾縺ｫ蜻ｼ縺ｰ繧後ｋ
	 */
	@Override
	public void onCreate(){
		eCount=0;
	}
	
	/**
	 * Application繧ｯ繝ｩ繧ｹ邨ゆｺ�譎ゅ↓蜻ｼ縺ｰ繧後ｋ
	 */
	@Override
	public void onTerminate(){
		eCount=0;
	}
	
	/**
	 * 蛻晄悄蛹悶☆繧狗ぜ縺ｮ髢｢謨ｰ
	 */
	public void init(){
		eCount=0;
	}
	
	/**
	 * 迴ｾ蝨ｨ縺ｮ謨ｵ繧ｭ繝｣繝ｩ邱乗焚繧定ｿ斐☆
	 * @return縲�謨ｵ繧ｭ繝｣繝ｩ邱乗焚
	 */
	public int getECount(){
		return eCount;
	}
	
	/**
	 * 謨ｵ繧ｭ繝｣繝ｩ邱乗焚縺ｫ繝励Λ繧ｹ1縺吶ｋ
	 */
	public void addtion(){
		eCount++;
	}

	/**
	 * 謨ｵ繧ｭ繝｣繝ｩ邱乗焚縺九ｉ繝槭う繝翫せ1縺吶ｋ
	 */
	public void subtraction(){
		eCount--;
	}
}
