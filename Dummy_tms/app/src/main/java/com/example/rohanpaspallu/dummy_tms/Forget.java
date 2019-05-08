package com.example.rohanpaspallu.dummy_tms;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by ROHAN PASPALLU on 2017-09-05.
 */

public class Forget extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgetpage);

        TextView forgotpassword = (TextView)findViewById(R.id.forgotpassword);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "Capture_it_2.ttf");
        forgotpassword.setTypeface(custom_font);
    }
}
