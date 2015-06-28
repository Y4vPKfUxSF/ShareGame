package com.example.sharegame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HelpActivity extends Activity implements View.OnClickListener{
	
	/**
	 * テキストビューフィールドを定義
	 * 自アクティビティ内で使いまわすことを想定し
	 * 局所変数ではなくフィールドとして宣言
	 */
	private TextView helpText;
	
	/**
	 * ボタンフィールドを定義
	 * 自アクティビティ内で使いまわすことを想定し
	 * 局所変数ではなくフィールドとして宣言
	 */
	private Button returnButton;

	/**
	 * アクティビティ起動時に呼ばれる
	 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        /* XMLで定義したViewファイルを関連付け */
        setContentView(R.layout.activity_help);
        
        /* コンポーネントを関連付け */
        helpText = (TextView)findViewById(R.id.helptext);
        helpText.setText("Hello World");
        returnButton = (Button)findViewById(R.id.returnbutton);
        returnButton.setOnClickListener(this);
    }
    
    /**
     * 戻るボタンの挙動を定義
     */
    @Override
    public void onClick(View v){
    	/* 戻るボタンの動作 */
    	finish();
    }

}