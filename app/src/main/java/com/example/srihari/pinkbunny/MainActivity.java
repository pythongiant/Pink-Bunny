package com.example.srihari.pinkbunny;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import java.io.BufferedReader;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView mHeading;
    private TextView mDayName;
    private TextView mObjective;
    private String DayNumber;
    private String DayObjective;
    SharedPreferences prefs = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.content_main);
            //all the fonts
            Typeface tHeading = Typeface.createFromAsset(getAssets(), "fonts/CookieMonster.ttf");
            Typeface tDayName = Typeface.createFromAsset(getAssets(), "fonts/Quicksand-LightItalic.otf");

            //find the view
            mHeading = (TextView) findViewById(R.id.Heading);
            mObjective = (TextView) findViewById(R.id.ObjectiveName);
            mObjective.setTypeface(tDayName);
            //get the Font
            mHeading.setTypeface(tHeading);

            //set text for the heading\n\n\n\n\n\n
            mHeading.setText("\nWelcome to Pink Bunny\n");
            //find the day name
            mDayName = (TextView) findViewById(R.id.dayName);

            mDayName.setTypeface(tDayName);

        prefs = getSharedPreferences("com.example.srihari.pinkbunny", MODE_PRIVATE);
        DayNumber=ReadSet().toString();
        mDayName.setText("Task "+DayNumber+":");
        mObjective.setText(ObjectiveNames.AllNames(Integer.parseInt(DayNumber))+"\n\n");

        //button
        final Button button = (Button) findViewById(R.id.DoneButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                appendDayNumber();
                mDayName.setText("Task "+DayNumber+":");
                mObjective.setText(ObjectiveNames.AllNames(Integer.parseInt(DayNumber))+"\n\n");
            }

        });
        final Button BackButton = (Button) findViewById(R.id.BackButton);
        BackButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Integer DayNum = Integer.parseInt(DayNumber)-1;
                String sDaynum = DayNum.toString();
                mDayName.setText("Task "+sDaynum +":");
                mObjective.setText(ObjectiveNames.AllNames(Integer.parseInt(sDaynum))+"\n\n");
            }

        });

    final Button bRandomButton  = (Button) findViewById(R.id.RandomButton);
       bRandomButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Random rand = new Random();
            Integer DayNum = rand.nextInt(30)+1;
            String sDaynum = DayNum.toString();
            mDayName.setText("Task "+sDaynum +":");
            mObjective.setText(ObjectiveNames.AllNames(Integer.parseInt(sDaynum))+"\n\n");
        }


    });
    }
    @Override
    protected void onResume() {
        super.onResume();

        if (prefs.getBoolean("firstrun", true)) {
            FirstTimeNumberAdd();
            prefs.edit().putBoolean("firstrun", false).commit();
        }
    }

//All DayNumber management stuff starts here
    String FILENAME="numberfile";
    private void FirstTimeNumberAdd(){
        try {
            FileOutputStream fos=openFileOutput(FILENAME,MODE_WORLD_READABLE);
            fos.write("0".getBytes());
            fos.close();

         }
         catch (FileNotFoundException e) {
                e.printStackTrace();
         } catch (IOException e) {
               e.printStackTrace();
         }
            }

    private StringBuilder ReadSet(){
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

    private void appendDayNumber(){
            Integer extended_date= Integer.parseInt(ReadSet().toString())+1;
            String daynum= extended_date.toString();
            if (Integer.parseInt(daynum)>=30) {
                daynum="0";
            }
            else{
                DayNumber=daynum;
            }
            try {

                FileOutputStream fos=openFileOutput(FILENAME,MODE_WORLD_READABLE);
                fos.write(daynum.getBytes());
                fos.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
