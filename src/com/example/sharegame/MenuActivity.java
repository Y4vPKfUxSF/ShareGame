package com.example.sharegame;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class MenuActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        View startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(this);
        
        View helpButton = findViewById(R.id.helpButton);
        helpButton.setOnClickListener(this);
    }
    
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.startButton:
            Intent i = new Intent (this, GameActivity.class);
            startActivity(i);
            break;
        case R.id.helpButton:
            Intent j = new Intent (this, HelpActivity.class);
            startActivity(j);
            break;
        }
    }
}