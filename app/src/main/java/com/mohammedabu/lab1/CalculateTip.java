package com.mohammedabu.lab1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateTip extends AppCompatActivity {
    private static final String TAG = "CalculateTip" ;
    EditText billText;
    EditText tipText;
    EditText peopleText;
    Button submit;

    String bill1;
    String tip1;
    String people1;


    float tipPercent;

    boolean validForm = true;

    float billAmount;
    float tipAmount;
    float totalBill;
    float tipPerPerson;
    float paymentPerPerson;
    float people;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_tip);
        billText = findViewById(R.id.billAmount);
        billText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String working = s.toString();
                boolean valid = true;
                if (working.isEmpty()){
                    valid = false;
                } else {valid = true;}
                if (!valid){
                    billText.setError("Please input an amount that's reasonable");
                    validForm = false;
                } else {
                    billText.setError(null);
                    validForm = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        tipText = findViewById(R.id.tipAmount);
        tipText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String working = s.toString();
                boolean valid = true;
                if (working.isEmpty()){
                    valid = false;
                } else if (Integer.parseInt(working) >100 || Integer.parseInt(working) < 0 ) {
                        valid = false;
                }
                if (!valid){
                    tipText.setError("Please input a percentage between 0 --> 100");
                    validForm = false;
                } else {
                    tipText.setError(null);
                    validForm = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        peopleText = findViewById(R.id.people);
        peopleText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String working = s.toString();
                boolean valid = true;
                if (working.isEmpty()){
                    valid = false;
                } else if (Integer.parseInt(working) >9 || Integer.parseInt(working) < 1 ) {
                    valid = false;
                }
                if (!valid){
                    peopleText.setError("Please input a number between 1 --> 9");
                    validForm = false;
                } else {
                    peopleText.setError(null);
                    validForm = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initialise();
                if (!validForm){
                    Toast.makeText(CalculateTip.this,"Missing or invalid information", Toast.LENGTH_SHORT).show();
                }else{
                navigateToCalculate();
                }
            }
        });
    }

    public void navigateToCalculate(){
        Intent i = new Intent(CalculateTip.this,Payment.class);

        billAmount = Float.parseFloat(bill1) ;
        tipPercent = Float.parseFloat(tip1) ;
        tipAmount = billAmount * tipPercent ;
        totalBill = billAmount + tipAmount;
        people = Float.parseFloat(people1) ;
        tipPerPerson = tipAmount / people ;
        paymentPerPerson = tipPerPerson + (billAmount / people);


        i.putExtra ( "BillAmount", billAmount);
        i.putExtra ( "TipAmount", tipAmount );
        i.putExtra ( "TotalBill", totalBill );
        i.putExtra ( "TipPerPerson", tipPerPerson);
        i.putExtra ( "EachPerson", paymentPerPerson);
        i.putExtra("People",people);
        startActivity(i);
    }

    private void initialise() {
        bill1 = billText.getText().toString() ;
        tip1 = tipText.getText().toString() ;
        people1 = peopleText.getText().toString() ;
    }

}
