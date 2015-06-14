package com.example.sharegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
