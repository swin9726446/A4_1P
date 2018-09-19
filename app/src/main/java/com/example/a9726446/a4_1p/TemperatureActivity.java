package com.example.a9726446.a4_1p;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by 9726446 on 19/9/18.
 * - Code originally from Lecture delivered by NRonald
 * - Amended to support bundles.
 * - Ignoring their TODOs for now.
 */

// TODO #1 Set up all the views needed: EditText for the celsius value, a Button and a TextView for the fahrenheit value.
// TODO #1a limit keyboard entry for celsius value.

// TODO #2 Record UI tests and edit.

// TODO #4 Create the converter class/model.
// TODO #4a Write unit tests and run.
// TODO #4b Finalise the model.

// TODO #7 Create new landscape layout using ConstraintLayout.

public class TemperatureActivity extends AppCompatActivity {

    // TODO #5 create a local variable to store the model.
    Converter converter = new Converter();

    // TODO #3 add initializeUI() call.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        initialiseUI(savedInstanceState);
    }

    // TODO #3a Connect up the button listener here.
    // TODO #6c Refactor to restore state.
    void initialiseUI(Bundle b) {
        Button convert = findViewById(R.id.bConvert);
        convert.setOnClickListener(clickListener);
        if (b == null) return;
        ((EditText) findViewById(R.id.etCelsius)).setText(b.getString("Celsius","0"));
        ((TextView) findViewById(R.id.tvFahrenheit)).setText(b.getString("Fahrenheit","0"));
    }

    // TODO #3b write click listener using anonymous class
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            convertValue();
        }
    };


    // TODO #3c write a function to process button click using dummy data. Run app.
    // TODO #5a Fix up the actual data using the model.
    // TODO #5b run UI tests again
    void convertValue() {
        EditText celsius = findViewById(R.id.etCelsius);
        String sFahrenheit = converter.convertTemperature(celsius.getText().toString());
        TextView fahrenheit = findViewById(R.id.tvFahrenheit);
        fahrenheit.setText(sFahrenheit + R.string.strF);
    }



    // TODO #6 write UI test for orientation change.
    // TODO #6a Update the saved instance state here.
    @Override
    protected void onSaveInstanceState(Bundle b){
        b.putString("Celsius", ((EditText) findViewById(R.id.etCelsius)).getText().toString());
        b.putString("Fahrenheit", ((TextView) findViewById(R.id.tvFahrenheit)).getText().toString());
        super.onSaveInstanceState(b);
    }
    // TODO #6b write a function to restore state here.
}