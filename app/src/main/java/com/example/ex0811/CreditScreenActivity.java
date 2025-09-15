package com.example.ex0811;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CreditScreenActivity extends AppCompatActivity {
    private TextView tV_credit;
    private Intent gi;
    private double credit;
    private boolean creditGiven;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_screen);
        tV_credit = findViewById(R.id.tV_credit);
        gi = getIntent();
        credit = gi.getDoubleExtra("result",0);
        creditGiven = gi.getBooleanExtra("record",false);
        if (creditGiven)
        {
            if (credit == (int)(credit))
            {
                tV_credit.setText((int)(credit)+"");
            }
            else
            {
                tV_credit.setText(credit+"");
            }
        }
        else
        {
            tV_credit.setText("No previous results recorded");
        }
    }

    public void returnToCalculator(View view) {
        finish();
    }
}