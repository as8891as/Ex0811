package com.example.ex0811;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText eT_numbersDisplay;
    double result;
    boolean numberEntered;
    char lastOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eT_numbersDisplay = findViewById(R.id.eT_numbersDisplay);
        result = 0;
        numberEntered = false;
        lastOperation = '!';
    }

    public void addition(View view) {
        if (!eT_numbersDisplay.getText().toString().isEmpty()) {
            if (!numberEntered) {
                result = Double.parseDouble(eT_numbersDisplay.getText().toString());
                eT_numbersDisplay.getText().clear();
                lastOperation = '+';
                numberEntered = true;
            }
            else
            {
                result = calcLastAction(result, lastOperation, eT_numbersDisplay);
                lastOperation = '+';
                eT_numbersDisplay.getText().clear();
            }
        }
    }

    public void subtraction(View view) {
        if (!eT_numbersDisplay.getText().toString().isEmpty()) {
            if (!numberEntered) {
                result = Double.parseDouble(eT_numbersDisplay.getText().toString());
                eT_numbersDisplay.getText().clear();
                lastOperation = '-';
                numberEntered = true;
            }
            else
            {
                result = calcLastAction(result, lastOperation, eT_numbersDisplay);
                lastOperation = '-';
                eT_numbersDisplay.getText().clear();
            }
        }
    }

    public void multiplication(View view) {
        if (!eT_numbersDisplay.getText().toString().isEmpty()) {
            if (!numberEntered) {
                result = Double.parseDouble(eT_numbersDisplay.getText().toString());
                eT_numbersDisplay.getText().clear();
                lastOperation = '*';
                numberEntered = true;
            }
            else
            {
                result = calcLastAction(result, lastOperation, eT_numbersDisplay);
                lastOperation = '*';
                eT_numbersDisplay.getText().clear();
            }
        }
    }

    public void division(View view) {
        if (!eT_numbersDisplay.getText().toString().isEmpty()) {
            if (!numberEntered) {
                result = Double.parseDouble(eT_numbersDisplay.getText().toString());
                eT_numbersDisplay.getText().clear();
                lastOperation = '/';
                numberEntered = true;
            }
            else
            {
                result = calcLastAction(result, lastOperation, eT_numbersDisplay);
                lastOperation = '/';
                eT_numbersDisplay.getText().clear();
            }
        }
    }

    public void reset(View view) {
        eT_numbersDisplay.getText().clear();
        result = 0;
        numberEntered = false;
        lastOperation = '!';
    }

    public void showResult(View view) {
        if (!eT_numbersDisplay.getText().toString().isEmpty())
        {
            if (lastOperation != '!')
            {
                result = calcLastAction(result,lastOperation,eT_numbersDisplay);
            }
            else
            {
                result = Double.parseDouble(eT_numbersDisplay.getText().toString());
            }
            if (result == (int)(result))
            {
                eT_numbersDisplay.setText((int)(result)+"");
            }
            else
            {
                eT_numbersDisplay.setText(result+"");
            }
        }
    }
    private static double calcLastAction(double lastResult, char lastAction, EditText eT)
    {
        switch(lastAction)
        {
            case '+': return lastResult+Double.parseDouble(eT.getText().toString());
            case '-': return lastResult-Double.parseDouble(eT.getText().toString());
            case '*': return lastResult*Double.parseDouble(eT.getText().toString());
            default: return lastResult/Double.parseDouble(eT.getText().toString());
        }
    }
}