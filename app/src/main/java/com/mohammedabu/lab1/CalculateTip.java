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
    boolean validBill;
    boolean validTip;
    boolean validPeople;

    int tip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_tip);
        billText = findViewById(R.id.billAmount);


        Intent i = getIntent();
        tip = i.getIntExtra("IP", 10);


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
                } else if(Integer.parseInt(working) > 500 || Integer.parseInt(working) < 0 ) {
                    valid = false;
                }
                if (!valid){
                    billText.setError("Please input a bill amount between 1 - 500");
                    validBill = false;
                } else {
                    billText.setError(null);
                    validBill = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        tipText = findViewById(R.id.tipAmount);
        tipText.setText(String.valueOf(tip));
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
                    validTip = false;
                } else {
                    tipText.setError(null);
                    validTip = true;
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
                    validPeople = false;
                } else {
                    peopleText.setError(null);
                    validPeople = true;
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
                if (!valid()){
                    submit.setEnabled(false);
                    Toast.makeText(CalculateTip.this,"Make sure the form is filled out properly!", Toast.LENGTH_SHORT).show();

                }else{
                    submit.setEnabled(true);
                    navigateToCalculate();

                }
            }
        });
    }

    public boolean valid(){
        validForm = validPeople && validBill && validPeople;
        return validForm;
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
