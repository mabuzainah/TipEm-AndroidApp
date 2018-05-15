//package com.mohammedabu.lab1;
//
//import android.app.Dialog;
//import android.os.Bundle;
//import android.support.v4.app.DialogFragment;
//import android.support.v7.app.AlertDialog;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.TextView;
//
//public class TipPercentDialog extends DialogFragment {
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        // Use the Builder class for convenient dialog construction
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//
//        LayoutInflater inflater = getActivity().getLayoutInflater();
//
//        // Inflate and set the layout for the dialog
//        // Pass null as the parent view because its going in the dialog layout
//        View content =  inflater.inflate(R.layout.dialog_tip_result, null);
//        builder.setView(content);
//
//        TextView textView = (TextView) getActivity().findViewById(R.id.info);
//        textView.setText(Html.fromHtml("<h1>Text has been correctly set</h1>"));
//
//    }
//}
//
