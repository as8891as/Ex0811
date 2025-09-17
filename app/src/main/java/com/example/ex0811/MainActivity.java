package com.example.ex0811;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private  EditText eT_numbersDisplay;
    private double result;
    private double lastNumber;
    private boolean numberEntered;
    private boolean resultGiven;
    private char lastOperation;
    private Intent si;
    private boolean resultRecorded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eT_numbersDisplay = findViewById(R.id.eT_numbersDisplay);
        numberEntered = false;
        resultGiven = false;
        lastOperation = '!';
        si = new Intent(this,CreditScreenActivity.class);
        resultRecorded = false;
    }

    public void addition(View view) {
        if (!eT_numbersDisplay.getText().toString().isEmpty() && eT_numbersDisplay.getText().toString().matches("[^aiInNfty]*") && (!eT_numbersDisplay.getText().toString().contains(String.valueOf('E')) || (eT_numbersDisplay.getText().toString().indexOf('E') != 0 && eT_numbersDisplay.getText().toString().indexOf('E') != eT_numbersDisplay.getText().toString().length() - 1))) {
            resultGiven = false;
            lastNumber = Double.parseDouble(eT_numbersDisplay.getText().toString());
            if (!numberEntered) {
                result = Double.parseDouble(eT_numbersDisplay.getText().toString());
                eT_numbersDisplay.getText().clear();
                lastOperation = '+';
                numberEntered = true;
            }
            else
            {
                result = calcLastAction(result,lastOperation,Double.parseDouble(eT_numbersDisplay.getText().toString()));
                lastOperation = '+';
                eT_numbersDisplay.getText().clear();
            }
        }
    }

    public void subtraction(View view) {
        if (!eT_numbersDisplay.getText().toString().isEmpty() && eT_numbersDisplay.getText().toString().matches("[^aiInNfty]*") && (!eT_numbersDisplay.getText().toString().contains(String.valueOf('E')) || (eT_numbersDisplay.getText().toString().indexOf('E') != 0 && eT_numbersDisplay.getText().toString().indexOf('E') != eT_numbersDisplay.getText().toString().length() - 1))) {
            resultGiven = false;
            lastNumber = Double.parseDouble(eT_numbersDisplay.getText().toString());
            if (!numberEntered) {
                result = Double.parseDouble(eT_numbersDisplay.getText().toString());
                eT_numbersDisplay.getText().clear();
                lastOperation = '-';
                numberEntered = true;
            }
            else
            {
                result = calcLastAction(result,lastOperation,Double.parseDouble(eT_numbersDisplay.getText().toString()));
                lastOperation = '-';
                eT_numbersDisplay.getText().clear();
            }
        }
    }

    public void multiplication(View view) {
        if (!eT_numbersDisplay.getText().toString().isEmpty() && eT_numbersDisplay.getText().toString().matches("[^aiInNfty]*") && (!eT_numbersDisplay.getText().toString().contains(String.valueOf('E')) || (eT_numbersDisplay.getText().toString().indexOf('E') != 0 && eT_numbersDisplay.getText().toString().indexOf('E') != eT_numbersDisplay.getText().toString().length() - 1))) {
            resultGiven = false;
            lastNumber = Double.parseDouble(eT_numbersDisplay.getText().toString());
            if (!numberEntered) {
                result = Double.parseDouble(eT_numbersDisplay.getText().toString());
                eT_numbersDisplay.getText().clear();
                lastOperation = '*';
                numberEntered = true;
            }
            else
            {
                result = calcLastAction(result,lastOperation,Double.parseDouble(eT_numbersDisplay.getText().toString()));
                lastOperation = '*';
                eT_numbersDisplay.getText().clear();
            }
        }
    }

    public void division(View view) {
        if (!eT_numbersDisplay.getText().toString().isEmpty() && eT_numbersDisplay.getText().toString().matches("[^aiInNfty]*") && (!eT_numbersDisplay.getText().toString().contains(String.valueOf('E')) || (eT_numbersDisplay.getText().toString().indexOf('E') != 0 && eT_numbersDisplay.getText().toString().indexOf('E') != eT_numbersDisplay.getText().toString().length() - 1))) {
            resultGiven = false;
            lastNumber = Double.parseDouble(eT_numbersDisplay.getText().toString());
            if (!numberEntered) {
                result = Double.parseDouble(eT_numbersDisplay.getText().toString());
                eT_numbersDisplay.getText().clear();
                lastOperation = '/';
                numberEntered = true;
            }
            else
            {
                result = calcLastAction(result,lastOperation,Double.parseDouble(eT_numbersDisplay.getText().toString()));
                lastOperation = '/';
                eT_numbersDisplay.getText().clear();
            }
        }
    }

    public void reset(View view) {
        eT_numbersDisplay.getText().clear();
        numberEntered = false;
        lastOperation = '!';
    }

    public void showResult(View view) {
        if (!eT_numbersDisplay.getText().toString().isEmpty() && eT_numbersDisplay.getText().toString().matches("[^aiInNfty]*") && (!eT_numbersDisplay.getText().toString().contains(String.valueOf('E')) || (eT_numbersDisplay.getText().toString().indexOf('E') != 0 && eT_numbersDisplay.getText().toString().indexOf('E') != eT_numbersDisplay.getText().toString().length() - 1)))
        {
            resultRecorded = true;
            if (lastOperation != '!')
            {
                if (!resultGiven)
                {
                    result = calcLastAction(result,lastOperation,Double.parseDouble(eT_numbersDisplay.getText().toString()));
                }
                else
                {
                    result = calcLastAction(result,lastOperation,lastNumber);
                }
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
            numberEntered = false;
            resultGiven = true;
        }
    }
    private static double calcLastAction(double lastResult, char lastAction, double newNumber)
    {
        switch(lastAction)
        {
            case '+': return lastResult+newNumber;
            case '-': return lastResult-newNumber;
            case '*': return lastResult*newNumber;
            default: return lastResult/newNumber;
        }
    }

    public void goToCreditsScreen(View view) {
        si.putExtra("result",result);
        si.putExtra("record",resultRecorded);
        startActivity(si);
    }
}