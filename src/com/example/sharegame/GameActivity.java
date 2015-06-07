package com.example.sharegame;

import android.app.Activity;
import android.os.Bundle;

public class GameActivity extends Activity{
    
    private Controller c;
    
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        c = new Controller(this);
    }
}
