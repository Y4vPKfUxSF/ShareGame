package com.example.sharegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameActivity extends Activity{
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GameView gView = new GameView(getApplicationContext());
        setContentView(gView);
    }
}
