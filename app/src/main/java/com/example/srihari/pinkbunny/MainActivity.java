package com.example.srihari.pinkbunny;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.File;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {
    private TextView mHeading;
    private TextView mDayName;
    private String DayNumber;
    private String DayObjective;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.content_main);
            //all the fonts
            Typeface tHeading = Typeface.createFromAsset(getAssets(), "fonts/CookieMonster.ttf");
            Typeface tDayName = Typeface.createFromAsset(getAssets(), "fonts/Quicksand-LightItalic.otf");

            //find the view
            mHeading = (TextView) findViewById(R.id.Heading);
            //get the Font

            mHeading.setTypeface(tHeading);
            //set text for the heading
            mHeading.setText("\n\nWelcome to Pink Bunny");

            //find the day name
            mDayName = (TextView) findViewById(R.id.dayName);
            mDayName.setTypeface(tDayName);
            //make file in which day number is stored
        FirstTimeNumberAdd();
        DayNumber=ReadSet().toString();
        mDayName.setText("\n\n\n\nDay:"+DayNumber);


        }
        String FILENAME="numberfile";

        public void FirstTimeNumberAdd(){
            try {

                FileOutputStream fos=openFileOutput(FILENAME,MODE_WORLD_READABLE);
                if (Integer.parseInt(DayNumber) != 1) {
                    fos.write("1".getBytes());
                    fos.close();
                }
                else{
                    fos.write((DayNumber+1).toString().getBytes());
                    fos.close();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        public StringBuilder ReadSet(){
            StringBuilder sb = new StringBuilder();

            try {
                FileInputStream fin = openFileInput(FILENAME);
                InputStreamReader inputStreamReader = new InputStreamReader(fin);
                String line;
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sb;
        }
    }
