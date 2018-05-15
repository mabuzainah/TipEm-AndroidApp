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
    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstance){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose the default currency").setSingleChoiceItems(currencies, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i){
                    case 0:
                        selectedCurrency = (String)currencies[i];
                        break;
                    case 1:
                        selectedCurrency = (String)currencies[i];
                        break;
                    case 2:
                        selectedCurrency = (String)currencies[i];
                        break;
                    case 3:
                        selectedCurrency = (String)currencies[i];
                        break;
                    default:
                        break;
                }
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
