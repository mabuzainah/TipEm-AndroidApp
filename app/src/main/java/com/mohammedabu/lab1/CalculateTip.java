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
    String bill,tip,people2;


    float tipPercent;


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
        tipText = findViewById(R.id.tipAmount);
        peopleText = findViewById(R.id.people);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activate();
            }
        });
    }

    private void activate() {
        initialise();
        if (!validate()){
            Toast.makeText(this,"Unable to send info, form incomplete", Toast.LENGTH_LONG).show();
        }else {
            passingToActvity();
        }
    }


    private void passingToActvity() {
        Intent i = new Intent(CalculateTip.this,Payment.class);

        billAmount = Float.parseFloat(billText.getText().toString()) ;
        tipPercent = Float.parseFloat(tipText.getText().toString()) ;
        tipAmount = billAmount * tipPercent ;
        totalBill = billAmount + tipAmount;
        people = Float.parseFloat(peopleText.getText().toString()) ;
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

    public void initialise(){
        bill = billText.getText().toString().trim();
        tip = tipText.getText().toString().trim();
        people2 = peopleText.getText().toString().trim();
    }
    public boolean validate(){
        boolean valid = true;
        if (bill.isEmpty()||!isPositive(billText)){
            billText.setError("Please enter your bill amount, it has to be positive amount!");
            valid = false;
        }
        if (tip.isEmpty()||!isPositive(tipText)){
            tipText.setError("Please enter a POSITIVE number");
            valid = false;
        }
        if (people2.isEmpty()){
            billText.setError("Please enter a number that is greater than 0");
            valid = false;
        }
        return valid;
    }

    private boolean isPositive(EditText et)
    {
        try
        {
            return Integer.parseInt(et.getText().toString()) > 0;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    
}
