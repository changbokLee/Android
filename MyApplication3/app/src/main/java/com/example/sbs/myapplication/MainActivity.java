package com.example.sbs.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // onCreate 는 간수(안드로이드 운영체제)가 알아서 적당한 때에 호출해준다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcButtonClicked(View view) {
        Intent intent = new Intent(this, SubActivity.class);

        EditText editTextNumber1 = findViewById(R.id.editTextNumber1);
        String number1Str = editTextNumber1.getText().toString().trim();

        if (number1Str.length() == 0) {
            number1Str = "0";
        }

        long number1 = Long.parseLong(number1Str);

        EditText editTextNumber2 = findViewById(R.id.editTextNumber2);
        String number2Str = editTextNumber2.getText().toString().trim();

        if (number2Str.length() == 0) {
            number2Str = "0";
        }

        long number2 = Long.parseLong(number2Str);

        intent.putExtra("number1", number1);
        intent.putExtra("number2", number2);
        startActivity(intent);
    }

    public void closeButtonClicked(View view) {
        finish();
    }
}