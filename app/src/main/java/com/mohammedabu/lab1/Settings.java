package com.mohammedabu.lab1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class Settings extends AppCompatActivity implements View.OnClickListener {

    Button confirm;
    Switch useDefault;
    boolean toggle;

    private CardView currency;
    private CardView tipPercentage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        confirm = findViewById(R.id.saveButton);
        useDefault = findViewById(R.id.switch1);
        currency = findViewById(R.id.currencyButton);
        tipPercentage = findViewById(R.id.tipPercentageButton);

        confirm.setOnClickListener(this);
        currency.setOnClickListener(this);
        tipPercentage.setOnClickListener(this);

        final SharedPreferences sharedPreferences = getSharedPreferences("Press",0);
        toggle = sharedPreferences.getBoolean("Switch",false);

        useDefault.setChecked(toggle);
        useDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle = !toggle;
                useDefault.setChecked(toggle);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("Switch", toggle);
                editor.apply();
            }
        });
    }

    @Override
    public void onClick (View view){
        Intent i;
        switch (view.getId()){
            case R.id.saveButton:
                i= new Intent(this,MainActivity.class);
                startActivity(i);
                break;

            case R.id.currencyButton:
//                TODO: Implement the popup dialogue when pressing the currency button to showcase the different supported currencies
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_currency, null);
                final EditText mEmail = (EditText) mView.findViewById(R.id.etEmail);
                final EditText mPassword = (EditText) mView.findViewById(R.id.etPassword);
                Button mLogin = (Button) mView.findViewById(R.id.btnLogin);

//                TODO: Implement the popup dialogue when pressing the currency button to show progress bar with the %
            case R.id.tipPercentageButton:
                i= new Intent(this,MainActivity.class);
                startActivity(i);
                break;

            default:
                break;
        }
    }
}
