package com.example.sharegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity implements View.OnClickListener {
    
    private TextView tv;
    private Button retryButton;
    private Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv = (TextView)findViewById(R.id.resulttext);
        retryButton = (Button)findViewById(R.id.retrybutton);
        retryButton.setOnClickListener(this);
        exitButton = (Button)findViewById(R.id.exitbutton);
        exitButton.setOnClickListener(this);
        Intent i = getIntent();
        tv.setText(i.getStringExtra("result_msg"));
    }
    
    @Override
    public void onClick(View v){
        switch (v.getId()) {
        case R.id.retrybutton:
            goOtherActivity(GameActivity.class);
            break;
        case R.id.exitbutton:
            goOtherActivity(MenuActivity.class);
            break;
        }
    }
    
    private void goOtherActivity(Class<?> className){
        Intent i = new Intent(getApplicationContext(), className);
        startActivity(i);
    }
}
