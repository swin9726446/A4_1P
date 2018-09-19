package com.example.a9726446.a4_1p;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    /**
     * Pair of click listeners for handling activity changes.
     */
    private View.OnClickListener tempListener = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            changeActivity('t');
        }
    };
    private View.OnClickListener distListener = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            changeActivity('d');
        }
    };

    /**
     * A method to change the activity.
     * Subjectively, switch statements are nicer to use than nested ifs.
     * @param item to distinguish which activity to launch. No activity should be launched if it can't be matched.
     */
    private void changeActivity(char item) {
        Intent i = new Intent();
        switch (item){
            case 'd':
                i.setClass(getApplicationContext(), com.example.a9726446.a4_1p.DistanceActivity.class);
                break;
            case 't':
                i.setClass(getApplicationContext(), com.example.a9726446.a4_1p.TemperatureActivity.class);
                break;
            default:
                Log.e("Activity Launch","Could not launch subsequent activity.");
                return;
        }
        startActivity(i);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialiseUI();
    }

    //This is just a main menu with no stored user input. No need for bundles.
    private void initialiseUI() {
        findViewById(R.id.btnDist).setOnClickListener(distListener);
        findViewById(R.id.btnTemp).setOnClickListener(tempListener);
    }


}
