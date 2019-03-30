
package com.example.sbs.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        long number1 = getIntent().getLongExtra("number1", 0);
        long number2 = getIntent().getLongExtra("number2", 0);

        TextView textViewRs = findViewById(R.id.textViewRs);
        textViewRs.setText("힌트 : " + number1 + " * " + number2 + " = " + (number1 * number2));
    }

    public void goBackButtonClicked(View view) {
        finish();
    }
}