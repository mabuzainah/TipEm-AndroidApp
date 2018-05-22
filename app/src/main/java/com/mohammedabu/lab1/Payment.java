package com.mohammedabu.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Payment extends AppCompatActivity {

    Button ok;
    float billAmount;
    float tipAmount;
    float totalBill;
    float tipPerPerson;
    float paymentPerPerson;
    float people;


    TextView toPay;
    TextView billAT;
    TextView tipAT;
    TextView billTot;
    TextView tpPPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        toPay = findViewById(R.id.payTextView);
        billAT = findViewById(R.id.billAmtText);
        tipAT = findViewById(R.id.tipAmtText);
        billTot = findViewById(R.id.billTotal);
        tpPPerson = findViewById(R.id.payTip);

        Intent in = getIntent();
        billAmount = in.getFloatExtra ( "BillAmount", 0);
        tipAmount = in.getFloatExtra ( "TipAmount", 0);
        totalBill = in.getFloatExtra ( "TotalBill", 0);
        tipPerPerson = in.getFloatExtra ( "TipPerPerson", 0);
        paymentPerPerson = in.getFloatExtra ( "EachPerson", 0);
        people = in.getFloatExtra("People",1);

        float tipAmt = tipAmount/100;
        float tipPP = tipPerPerson/100;
        float tot = tipAmt + billAmount;
        float ppl = people;
        float bTot = (billAmount/ppl) + tipPP ;

        billAT.setText(String.valueOf(billAmount));
        tipAT.setText(String.valueOf(tipAmt));
        billTot.setText(String.valueOf(tot));
        tpPPerson.setText(String.valueOf(tipPP));
        toPay.setText(String.valueOf(bTot));

        ok = findViewById(R.id.submit2);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Payment.this, MainActivity.class );
                startActivity(i);
            }
        });
    }
}
