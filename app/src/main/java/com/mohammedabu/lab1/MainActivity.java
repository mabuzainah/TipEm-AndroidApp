package com.mohammedabu.lab1;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.View;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;
import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView calcTip;
    private CardView previousTip;
    private CardView suggestedTip;
    private CardView settings;
    int tipPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();
        tipPercent = i.getIntExtra ( "IP", 0);
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
                i.putExtra ( "IP", tipPercent);
                startActivity(i);
                //showDialogView(view);
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
//    public void showDialogView(View view){
//        Dialog dialog = new Dialog(this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.test);
//        List<PagerModel> pagerArr = new ArrayList<>();
//        pagerArr.add(new PagerModel("1","Pager Item #1"));
//        pagerArr.add(new PagerModel("2","Pager Item #2"));
//        pagerArr.add(new PagerModel("3","Pager Item #3"));
//
//        PagerAdapterProject adapter = new PagerAdapterProject(this, pagerArr);
//        AutoScrollViewPager pager = dialog.findViewById(R.id.pager);
//        pager.setAdapter(adapter);
//        CircleIndicator pageIndicator = dialog.findViewById(R.id.indicator);
//        pageIndicator.setViewPager(pager);
//        pageIndicator.setViewPager(pager);
//
//        dialog.show();
//    }


}
