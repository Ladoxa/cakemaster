package com.ladoxa.cakemaster;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

    private FirebaseDatabase database; // Добавили БД
    private DatabaseReference myRef;

//    String[] names = {"Круглая", "Прямоугольная"};


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


        // Инициализируем БД
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("items");


        spinnerShape.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0: {
                        editText3.setVisibility(View.INVISIBLE);
//                        myRef.push().setValue(position);
                        break;
                    }
                    case 1: {
                        editText3.setText(null);
                        editText3.setVisibility(View.VISIBLE);
                        break;
                    }
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
                        editText4.setText(null);
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

        double a = 1;
        double b = 1;
        double c = 1;
        double d = 1;


        myRef.setValue("Hello, World!2");

        if (!editText1.getText().toString().equals("")) {
            a = Double.parseDouble(String.valueOf(editText1.getText()));
        } else Toast.makeText(this,"Введите нужные размеры",Toast.LENGTH_SHORT).show();

        if (!editText2.getText().toString().equals("")) {
            b = Double.parseDouble(String.valueOf(editText2.getText()));
        } else Toast.makeText(this,"Введите нужные размеры",Toast.LENGTH_SHORT).show();

        if (!editText3.getText().toString().equals("")) {
           c = Double.parseDouble(String.valueOf(editText3.getText()));
        } else Toast.makeText(this,"Введите нужные размеры",Toast.LENGTH_SHORT).show();

        if (!editText4.getText().toString().equals("")) {
           d = Double.parseDouble(String.valueOf(editText4.getText()));
        } else Toast.makeText(this,"Введите нужные размеры",Toast.LENGTH_SHORT).show();


        if (spinnerShape.getSelectedItemPosition() == 0) {
            if (spinnerShape2.getSelectedItemPosition() == 0){
                String s = String.format("%.2f",coefficient.circles(a, b));
                textView.setText(s); //(s+" = "+ a + "*" + b);
            } else {
                String s = String.format("%.2f",coefficient.circleRect(b, a, d));
                textView.setText(s);//(s+" = "+ b + "*" + d +" / "+ a + "^2");
            }
        }

        if (spinnerShape.getSelectedItemPosition() == 1) {
            if (spinnerShape2.getSelectedItemPosition() == 0){
                String s = String.format("%.2f",coefficient.rectCircle(a, b, c));
                textView.setText(s);//(s + " =" + a + "*" + c + "/ " + b + "^2");
            } else {
                String s = String.format("%.2f",coefficient.rectangles(b, d, a, c));
                textView.setText(s);//(s +" =("+ b + "*" + d +")/("+ a + "*" + c);
            }
        }
    }

    public void onClickNext(View view) {
        startActivity(new Intent(MainActivity.this, TestUploadPhotoActivity.class));
    }
}
