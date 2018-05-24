package com.mohammedabu.lab1;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Settings extends AppCompatActivity implements View.OnClickListener {


        Button confirm;
        public int value ;
        private CardView currency;
        private CardView tipPercentage;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_settings);
            confirm = findViewById(R.id.saveButton);
            //useDefault = findViewById(R.id.switch1);
            currency = findViewById(R.id.currencyButton);
            tipPercentage = findViewById(R.id.tipPercentageButton);

            confirm.setOnClickListener(this);
            currency.setOnClickListener(this);
            tipPercentage.setOnClickListener(this);

            final SharedPreferences sharedPreferences = getSharedPreferences("Press",0);

        }
//TODO: update the tip % in the calculate Tip class with the tip selected by users in settings.
        @Override
        public void onClick (View view){
            Intent i;
            switch (view.getId()) {
                case R.id.saveButton:
                    i = new Intent(this, MainActivity.class);
                    startActivity(i);
                    break;
                case R.id.currencyButton:
                    setCurrency(view);
                    break;
                    //  TODO:  Saving that state in the application
                case R.id.tipPercentageButton:
                    showDialog();
                    break;

                default:
                    break;
            }
        }

        public void setCurrency(View view){
            CurrencyChoiceDialog currencyChoiceDialog = new CurrencyChoiceDialog();
            currencyChoiceDialog.show(getSupportFragmentManager(),"CurrencySelection");
        }


        public void showDialog(){

            final AlertDialog.Builder popDialog = new AlertDialog.Builder(this);
            final SeekBar seek = new SeekBar(this);
            seek.setMax(100);
            seek.setMin(10);
            seek.incrementProgressBy(5);

            popDialog.setTitle("Tip Percentage");
            popDialog.setMessage("10%");
            popDialog.setView(seek);
            popDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "Tip % has been updated to: "+ seek.getProgress(), Toast.LENGTH_SHORT).show();
                }
            });
            final AlertDialog dialog = popDialog.create();


            seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public int progress ;

                public void onProgressChanged(SeekBar seekBar, int progressV, boolean fromUser) {
                    dialog.setMessage(progressV+" %");
                }

                public void onStartTrackingTouch(SeekBar arg0) {
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                    dialog.setMessage(seekBar.getProgress() +" %");
                    progress = seekBar.getProgress();

                }
            });
            dialog.show();
        }

}
