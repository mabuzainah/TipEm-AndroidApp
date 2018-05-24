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
        });
    }

    //TODO: Finish Implementing the verification for the form.

    private void setupFloatingLabelError() {
        final TextInputLayout floatingBillLabel = findViewById(R.id.billAmount);
        floatingBillLabel.getEditText().addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence text, int start, int count, int after) {
                if (text.length()== 0)
                    floatingBillLabel.setError("Input your bill amount");
                    floatingBillLabel.setErrorEnabled(true);
                }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });
    }

    public int calculate(){
    return 0;
    }
}
