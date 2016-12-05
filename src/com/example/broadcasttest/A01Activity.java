package com.example.broadcasttest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class A01Activity extends Activity {
 private TextView tv;
 private ImageView iv;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv=(TextView)findViewById(R.id.tv);
        tv.setText("ª∂”≠π‚¡Ÿ168855");
        iv=(ImageView)findViewById(R.id.iv);
        iv.setBackgroundResource(R.drawable.smile);      
    }
}