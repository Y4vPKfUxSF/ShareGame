package com.example.sharegame;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class HelpActivity extends Activity {
	
	/**
	 * ヘルプ文章
	 */
	private TextView helpText;
	
	/**
	 * 戻るボタン
	 */
	@SuppressWarnings("unused")
	private Button returnButton;

	/**
	 * アクティビティ起動時に呼ばれる
	 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        /* XMLのViewファイルを関連付け */
        setContentView(R.layout.activity_help);
        
        /* コンポーネントを関連付け */
        helpText = (TextView)findViewById(R.id.helptext);
        helpText.setText("Hello World");
        returnButton = (Button)findViewById(R.id.returnbutton);
    }
    
    /**
     * 戻るボタンを押下時の動作を記述
     * ソースファイルからは呼ばず、XMLファイルの
     * onclick属性に定義する
     */
    public void returnButtonClick(){
    	/* ひとつ前の動作へ戻る */
    	finish();
    }

}
