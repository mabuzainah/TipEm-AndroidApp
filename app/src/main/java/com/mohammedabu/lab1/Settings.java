package com.mohammedabu.lab1;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
            switch (view.getId()) {
                case R.id.saveButton:
                    i = new Intent(this, MainActivity.class);
                    startActivity(i);
                    break;
                case R.id.currencyButton:
                    setCurrency(view);
                    break;
                    //  TODO: Finish implementing the changes in the seekbar and reflecting it with the percentage text, and saving that state in the application
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
            final Dialog yourDialog = new Dialog(this);
            LayoutInflater inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.dialog_tippercentage, (ViewGroup)findViewById(R.id.your_dialog_root_element));
            Button yourDialogButton = layout.findViewById(R.id.your_dialog_button);
            SeekBar yourDialogSeekBar = layout.findViewById(R.id.seekBar1);
            final TextView percentage = findViewById(R.id.editText1);
            yourDialog.setContentView(layout);
            yourDialog.show();
            yourDialogSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
            {
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
                {
                   // percentage.setText(Integer.toString(progress + 10));
                }

                public void onStartTrackingTouch(SeekBar seekBar) {}

                public void onStopTrackingTouch(SeekBar seekBar) {}
            });
            yourDialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    yourDialog.dismiss();
                }
            });
        }
}
