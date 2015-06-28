package com.example.sharegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
        
        View prefButton = findViewById(R.id.prefButton);
        prefButton.setOnClickListener(this);
    }
    
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.startButton:
            goOtherActivity(GameActivity.class);
            break;
        case R.id.helpButton:
            goOtherActivity(HelpActivity.class);
            break;
        case R.id.prefButton:
            goOtherActivity(PrefActivity.class);
            break;
        }
    }
    
    /**
     * 別のアクティビティに移る処理
     * @param className
     */
    private void goOtherActivity(Class<?> className){
        Intent i = new Intent(this, className);
        startActivity(i);
    }

}