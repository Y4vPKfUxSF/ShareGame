package com.example.sharegame;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class HelpActivity extends Activity {
	
	/**
	 * �w���v����
	 */
	private TextView helpText;
	
	/**
	 * �߂�{�^��
	 */
	@SuppressWarnings("unused")
	private Button returnButton;

	/**
	 * �A�N�e�B�r�e�B�N�����ɌĂ΂��
	 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        /* XML��View�t�@�C�����֘A�t�� */
        setContentView(R.layout.activity_help);
        
        /* �R���|�[�l���g���֘A�t�� */
        helpText = (TextView)findViewById(R.id.helptext);
        helpText.setText("Hello World");
        returnButton = (Button)findViewById(R.id.returnbutton);
    }
    
    /**
     * �߂�{�^�����������̓�����L�q
     * �\�[�X�t�@�C������͌Ă΂��AXML�t�@�C����
     * onclick�����ɒ�`����
     */
    public void returnButtonClick(){
    	/* �ЂƂO�̓���֖߂� */
    	finish();
    }

}
