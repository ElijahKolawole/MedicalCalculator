package com.adefemikolawole.medicalcalculator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double conversionRate = 2.2;
    double weightEntered;
    double convertedWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        final EditText weight = findViewById(R.id.txtWeight);
        final RadioButton lbToKilo = findViewById(R.id.radLbtoKilo);
        final RadioButton kiloToLb = findViewById(R.id.radKiloToLb);
        final TextView result = findViewById(R.id.txtResult);
        Button convert = findViewById(R.id.btnConvert);

        convert.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                weightEntered = Double.parseDouble(weight.getText().toString());
                DecimalFormat tenth = new DecimalFormat("#.#");
                if (lbToKilo.isChecked()) {
                    if (weightEntered <= 500.00) {
                        convertedWeight = weightEntered / conversionRate;
                        result.setText(tenth.format(convertedWeight) + " kilograms");

                    } else {
                        Toast.makeText(MainActivity.this, "pounds must be less than 500", Toast.LENGTH_LONG).show();
                    }
                }

                 if (kiloToLb.isChecked()){
                    if (weightEntered <= 225.00){
                        convertedWeight =  weightEntered * conversionRate;
                        result.setText(tenth.format(convertedWeight) + " pounds");
                    }
                    else{
                        Toast.makeText(MainActivity.this, "kilos must be less than 225", Toast.LENGTH_LONG).show();

                    }
                }



            }
        });



    }
}
