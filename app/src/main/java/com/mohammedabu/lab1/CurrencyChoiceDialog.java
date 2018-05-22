package com.mohammedabu.lab1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;


public class CurrencyChoiceDialog extends DialogFragment {

    final CharSequence[] currencies = {"CAD", "USD", "EURO", "POUNDS"};
    String selectedCurrency;
    public static int selectedElement= 0;
    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstance){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose the default currency").setSingleChoiceItems(currencies, selectedElement, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                        selectedCurrency = (String)currencies[i];
                        selectedElement = i;

            }
        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), "The chosen currency is: "+ selectedCurrency, Toast.LENGTH_LONG);
            }
        });
        return  builder.create();
    }
}
