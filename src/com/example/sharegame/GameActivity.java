package com.example.sharegame;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;

public class GameActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View stopButton = findViewById(R.id.stopButton);
        stopButton.setOnClickListener(this);
    }
    
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.stopButton:
            Intent i = new Intent (this, HelpActivity.class);
            startActivity(i);
            break;
        }
    }
}



public class Enemy{
	Bitmap eCharImage; 
	int charX, charY, color;
	
	//コンストラクタの定義
	public Enemy(Bitmap eCharImage, int charX, int charY, int color) {
		this.eCharImage = eCharImage;
		this.charX = charX;
		this.charY = charY;
		this.color = color;
	}
	
	//以下getter,setterの定義
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
	
	//toString 未着手
}