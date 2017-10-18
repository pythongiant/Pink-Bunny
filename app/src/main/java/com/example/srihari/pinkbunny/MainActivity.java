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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        mHeading=(TextView) findViewById(R.id.Heading);


        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/CookieMonster.ttf");

        mHeading.setTypeface(custom_font);

        mHeading.setText("Welcome to Pink Bunny");


    }
}

