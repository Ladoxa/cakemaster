package com.ladoxa.cakemaster;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends Activity  {

    Spinner spinnerShape;
    Spinner spinnerShape2;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    String stringSpinner1;
    String stringSpinner2;
    TextView textView;
    ArrayAdapter dataAdapter;

    String[] names = {"Круглая", "Прямоугольная"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerShape = (Spinner) findViewById(R.id.startFormSpinner);
        spinnerShape2 = (Spinner) findViewById(R.id.endFormSpinner);
        editText1 = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        stringSpinner1 = String.valueOf(spinnerShape.getSelectedItem());
        stringSpinner2 = String.valueOf(spinnerShape2.getSelectedItem());
        textView = (TextView) findViewById(R.id.factor2Text);

        spinnerShape.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0: {
                       editText3.setVisibility(View.INVISIBLE);
                        break;
                    }
                    case 1:
                            editText3.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerShape2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0: {
                        editText4.setVisibility(View.INVISIBLE);
                        break;
                    }
                    case 1:
                        editText4.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.shape) );

        spinnerShape.setAdapter(dataAdapter);
        spinnerShape2.setAdapter(dataAdapter);

    }

    public void onClickFactor(View view) {


        double a = Double.parseDouble(String.valueOf(editText1.getText()));
        double b = Double.parseDouble(String.valueOf(editText2.getText()));
        double c = Double.parseDouble(String.valueOf(editText3.getText()));
        double d = Double.parseDouble(String.valueOf(editText4.getText()));


        if (stringSpinner1.equals("Круглая")) {
            if (stringSpinner2.equals("Круглая")){
                String s = String.format("%.2f",coefficient.count(a, b));
                textView.setText(s);
            } else {
                String s = String.format("%.2f",coefficient.count(a, b, d));
                textView.setText(s);
            }
        }

        if (stringSpinner1.equals("Прямоугольная")) {
            if (stringSpinner2.equals("Круглая")){
                String s = String.format("%.2f",coefficient.count(a, c, d));
                textView.setText(s);
            } else {
                String s = String.format("%.2f",coefficient.count(a, c, b, d));
                textView.setText(s);
            }
        }
    }

}
