package com.example.sharegame;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.view.View;
import android.view.View.OnClickListener;

//maeda

public class GameActivity extends Activity implements View.OnClickListener{
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GameView gView = new GameView(getApplicationContext());
        setContentView(gView);

        //View stopButton = findViewById(R.id.stopButton);
        //stopButton.setOnClickListener(this);
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
}
