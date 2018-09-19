package com.example.a9726446.a4_1p;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class DistanceActivity extends AppCompatActivity {

    Converter converter = new Converter();
    private View.OnClickListener clickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            convert();
        }
    };

    private void convert() {
        ((TextView) findViewById(R.id.txtMetric)).setText(converter.convertDistance(
                ((EditText) findViewById(R.id.etMiles)).getText().toString(),
                ((EditText) findViewById(R.id.etFeet)).getText().toString(),
                ((EditText) findViewById(R.id.etInches)).getText().toString(),
                ((CheckBox) findViewById(R.id.chkMetres)).isChecked()
        ));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);
        initialiseUI(savedInstanceState);
    }

    /**
     * Method used to set up the user interface, on first launch and on creation.
     * Separated from onCreate to keep things straightforward.
     * @param b Bundle used to retrieve information.
     *          If this is null (first launch), the method ends early.
     */
    private void initialiseUI(Bundle b) {
        findViewById(R.id.btnConvert).setOnClickListener(clickListener);
        if (b == null) return;
        ((EditText) findViewById(R.id.etMiles)).setText(b.getString("Mile", "0"));
        ((EditText) findViewById(R.id.etFeet)).setText(b.getString("Feet","0"));
        ((EditText) findViewById(R.id.etInches)).setText(b.getString("Inch","0"));
        ((TextView) findViewById(R.id.txtMetric)).setText(b.getString("Result","0"));
        ((CheckBox) findViewById(R.id.chkMetres)).setChecked(b.getBoolean("isMetre", false));
    }

    /**
     * Method used to save data in activity for when it's destroy (eg during orientation change)
     * @param b The bundle used to put everything in.
     */
    @Override
    protected void onSaveInstanceState(Bundle b){
        b.putString("Mile", ((EditText) findViewById(R.id.etMiles)).getText().toString());
        b.putString("Feet", ((EditText) findViewById(R.id.etFeet)).getText().toString());
        b.putString("Inch", ((EditText) findViewById(R.id.etInches)).getText().toString());
        b.putString("Result", ((TextView) findViewById(R.id.txtMetric)).getText().toString());
        b.putBoolean("isMetre", ((CheckBox) findViewById(R.id.chkMetres)).isChecked());
        super.onSaveInstanceState(b);
    }
}