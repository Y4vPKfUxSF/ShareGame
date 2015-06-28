package com.example.sharegame;

import android.app.Activity;
import android.os.Bundle;

public class GameActivity extends Activity{
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GameView gView = new GameView(getApplicationContext());
        setContentView(gView);
    }
}
