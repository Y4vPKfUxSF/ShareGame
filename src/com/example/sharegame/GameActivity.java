package com.example.sharegame;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.view.View;
import android.view.View.OnClickListener;

public class GameActivity extends Activity implements View.OnClickListener{
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View stopButton = findViewById(R.id.stopButton);
        stopButton.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.stopButton:
            Intent i = new Intent (this, HelpActivity.class);
            startActivity(i);
            break;
        }
    }

public class Enemy{
	Bitmap eCharImage; 
	int charX, charY, color;
	
	//�R���X�g���N�^�̒�`
	public Enemy(Bitmap eCharImage, int charX, int charY, int color) {
		this.eCharImage = eCharImage;
		this.charX = charX;
		this.charY = charY;
		this.color = color;
	}
	
	//�ȉ�getter,setter�̒�`
	public Bitmap geteCharImage() {
		return eCharImage;
	}
	
	public void seteCharImage(Bitmap eCharImage) {
		this.eCharImage = eCharImage;
	}
	
	public int getcharX() {
		return charX;
	}
	
	public void setcharX(int charX) {
		this.charX = charX;
	}
	
	public int getcharY() {
		return charY;
	}
	
	public void setcharY(int charY) {
		this.charY = charY;
	}
	
	public int getcolor() {
		return color;
	}
	
	public void setcolor(int color) {
		this.color = color;
	}
	
	//toString ������
}