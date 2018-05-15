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
// TODO: Save the state once the OK button is clicked for the currency.
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
            Button yourDialogButton = (Button)layout.findViewById(R.id.your_dialog_button);
            SeekBar yourDialogSeekBar = (SeekBar)layout.findViewById(R.id.your_dialog_seekbar);
            yourDialog.setContentView(layout);
            yourDialog.show();
            yourDialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    yourDialog.dismiss();
                }
            });
        }

//    public void ShowDialog(){
//        final AlertDialog.Builder popDialog = new AlertDialog.Builder(this);
//        final SeekBar seek = new SeekBar(this);
//        seek.setMax(60);
//        seek.setKeyProgressIncrement(1);
//
//        popDialog.setIcon(android.R.drawable.btn_star_big_on);
//        popDialog.setTitle("Please adjust to the desired Tip % needed ");
//        popDialog.setView(seek);
//
//
//        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//
//
//
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
//
//
//                txtView.setText("Value of : " + progress);
//            }
//
//
//
//            public void onStartTrackingTouch(SeekBar arg0) {
//                //do something
//
//                // TODO Auto-generated method stub
//            }
//
//
//
//            public void onStopTrackingTouch(SeekBar seekBar) {
//                //do something
//
//            }
//        });
//
//
//        // Button OK
//        popDialog.setPositiveButton("OK",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//        popDialog.create();
//        popDialog.show();
//    }


//    private void showRadioButtonDialog() {
//
//        // custom dialog
//        final Dialog dialog = new Dialog(getApplicationContext());
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.dialog_currency);
//        List<String> stringList=new ArrayList<>();  // here is list
//        for(int i=0;i<5;i++) {
//            stringList.add("RadioButton " + (i + 1));
//        }
//        RadioGroup rg = dialog.findViewById(R.id.currencySelection);
//
//        for(int i=0;i<stringList.size();i++){
//            RadioButton rb=new RadioButton(getApplicationContext()); // dynamically creating RadioButton and adding to RadioGroup.
//            rb.setText(stringList.get(i));
//            rg.addView(rb);
//        }
//        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                int childCount = group.getChildCount();
//                for (int x = 0; x < childCount; x++) {
//                    RadioButton btn = (RadioButton) group.getChildAt(x);
//                    if (btn.getId() == checkedId) {
//                        Log.e("selected RadioButton->",btn.getText().toString());
//
//                    }
//                }
//            }
//        });
//
//        dialog.show();
//
//    }
}
