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
	private TextView help_faq_title1;
	private TextView help_faq_title2;
	private TextView help_faq_title3;
	private TextView help_faq_title4;
	private TextView help_faq_title5;
	private TextView help_faq_answer1;
	private TextView help_faq_answer2;
	private TextView help_faq_answer3;
	private TextView help_faq_answer4;
	private TextView help_faq_answer5;
	private TextView help_license;

	
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
        help_faq_title1 = (TextView)findViewById(R.id.help_faq_title1);
        help_faq_answer1 = (TextView)findViewById(R.id.help_faq_answer1);
        help_faq_title2 = (TextView)findViewById(R.id.help_faq_title2);
        help_faq_answer2 = (TextView)findViewById(R.id.help_faq_answer2);
        help_faq_title3 = (TextView)findViewById(R.id.help_faq_title3);
        help_faq_answer3 = (TextView)findViewById(R.id.help_faq_answer3);
        help_faq_title4 = (TextView)findViewById(R.id.help_faq_title4);
        help_faq_answer4 = (TextView)findViewById(R.id.help_faq_answer4);
        help_faq_title5 = (TextView)findViewById(R.id.help_faq_title5);
        help_faq_answer5 = (TextView)findViewById(R.id.help_faq_answer5);
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