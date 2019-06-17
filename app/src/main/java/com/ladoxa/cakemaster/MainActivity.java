package com.ladoxa.cakemaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClickFactor(View view) {
        Spinner spinnerShape = (Spinner) findViewById(R.id.startFormSpinner);
        Spinner spinnerShape2 = (Spinner) findViewById(R.id.endFormSpinner);
        EditText editText1 = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        EditText editText4 = (EditText) findViewById(R.id.editText4);
//        String s1 = String.valueOf(editText1.getText());
//        double a = Double.parseDouble(s1);
//        String s2 = String.valueOf(editText2.getText());
//        double b = Double.parseDouble(s2);
//        String s3 = String.valueOf(editText3.getText());
//        double c = Double.parseDouble(s3);
//        String s4 = String.valueOf(editText4.getText());
//        double d = Double.parseDouble(s4);
        double a = Double.parseDouble(String.valueOf(editText1.getText()));
        double b = Double.parseDouble(String.valueOf(editText2.getText()));
        double c = Double.parseDouble(String.valueOf(editText3.getText()));
        double d = Double.parseDouble(String.valueOf(editText4.getText()));


        TextView textView = (TextView) findViewById(R.id.factor2Text);

        String stringSpinner1 = String.valueOf(spinnerShape.getSelectedItem().toString());
        String stringSpinner2 = String.valueOf(spinnerShape2.getSelectedItem().toString());

        if (stringSpinner1.equals("Круглая")) {
            if (stringSpinner2.equals("Круглая")){
                String s = String.format("%.2f",coefficient.count(a, b));
                textView.setText(s);
            }
        }



    }
}
