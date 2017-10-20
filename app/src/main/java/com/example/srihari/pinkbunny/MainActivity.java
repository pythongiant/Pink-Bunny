package com.example.srihari.pinkbunny;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView mHeading;
    private TextView mDayName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        //find the view
        mHeading=(TextView) findViewById(R.id.Heading);
        //get the Font
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/CookieMonster.ttf");
        mHeading.setTypeface(custom_font);
        //set text for the heading
        mHeading.setText("\n\nWelcome to Pink Bunny");

        //find the day name
        mDayName= (TextView) findViewById(R.id.dayName);
        mDayName.setText("\n\n\n\nDay 1:");
    }
}

