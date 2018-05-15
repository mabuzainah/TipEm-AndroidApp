package com.mohammedabu.lab1;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class Suggested extends AppCompatActivity {

    RatingBar food;
    RatingBar mood;
    RatingBar price;
    RatingBar staff;
    float totalRating;
    int rating;
    Button calcualteRating;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggested);
        food = findViewById(R.id.ratingBarFood);
        mood = findViewById(R.id.ratingBarMood);
        price = findViewById(R.id.ratingBarPrice);
        staff = findViewById(R.id.ratingBarStaff);
        calcualteRating = findViewById(R.id.calculateRatingButton);
        calcualteRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int foodRating = (int) food.getRating();
                int moodRating = (int) mood.getRating();
                int priceRating = (int) food.getRating();
                int staffRating = (int) food.getRating();
                int finalRating = (foodRating + moodRating + staffRating + priceRating)/4;
                int resultOfCalc = 10 + (finalRating * 2);
                String msg = "Based on the ratings you provided, the calculated tip is: " +"<b>"+ resultOfCalc+"<b>" + "% ";


                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
//                LayoutInflater inflater = context.getLayoutInflater();
//
//                // Inflate and set the layout for the dialog
//                // Pass null as the parent view because its going in the dialog layout
//                View content =  inflater.inflate(R.layout.dialog_tip_result, null);
//                alertDialogBuilder.setView(content);

                alertDialogBuilder.setTitle("Your Tip %");

                alertDialogBuilder
//                        .setMessage(msg)
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                dialog.cancel();
                            }
                        });
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    alertDialogBuilder.setMessage(Html.fromHtml(msg, Html.FROM_HTML_MODE_LEGACY));
                } else {
                    alertDialogBuilder.setMessage(Html.fromHtml(msg));
                }
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

                //rating = calculateTip();
               //showDialogPopup(rating);

    }



//    private int calculateTip() {
//        totalRating = (food.getRating() + mood.getRating() + staff.getRating() + price.getRating())
//                        /4;
//        int tipPercentage = (10 + (((int) totalRating) * 2));
//        return  tipPercentage;
//    }
//
//    public void showDialogPopup(int rating){
//        final Dialog yourDialog = new Dialog(this);
//        LayoutInflater inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
//        View layout = inflater.inflate(R.layout.dialog_tip_result, null);
//        TextView tipPercentage = layout.findViewById(R.id.tipToPay);
//        Button yourDialogButton = layout.findViewById(R.id.your_dialog_button);
//        yourDialog.setContentView(layout);
//        yourDialog.show();
//        tipPercentage.setText(rating);
//        yourDialogButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                yourDialog.dismiss();
//            }
//        });
//    }



}
