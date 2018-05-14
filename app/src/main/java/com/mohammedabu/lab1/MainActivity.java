package com.mohammedabu.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView calcTip;
    private CardView previousTip;
    private CardView suggestedTip;
    private CardView settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calcTip = findViewById(R.id.calcTip);
        previousTip = findViewById(R.id.prevTip);
        suggestedTip = findViewById(R.id.suggested);
        settings = findViewById(R.id.settings);

        calcTip.setOnClickListener(this);
        previousTip.setOnClickListener(this);
        suggestedTip.setOnClickListener(this);
        settings.setOnClickListener(this);

    }

    @Override
    public void onClick (View view){
        Intent i;
        switch (view.getId()){
            case R.id.calcTip:
                i= new Intent(this,CalculateTip.class);
                startActivity(i);
                break;

            case R.id.prevTip:
                i= new Intent(this,PreviousTip.class);
                startActivity(i);
                break;

            case R.id.suggested:
                i= new Intent(this,Suggested.class);
                startActivity(i);
                break;

            case R.id.settings:
                i= new Intent(this,Settings.class);
                startActivity(i);
                break;

            default:
                break;
        }
    }

}
