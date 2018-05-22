package com.mohammedabu.lab1;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class TipPercentDialog extends DialogFragment {
    public static TipPercentDialog newInstance(String title) {
        TipPercentDialog alertFragment = new TipPercentDialog();
        Bundle args = new Bundle();
        args.putString("title", title);
        alertFragment.setArguments(args);
        return alertFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = getArguments().getString("title");

        final Dialog dialog = new Dialog(getActivity());

        dialog.setTitle(title);
        dialog.setContentView(R.layout.dialog_tippercentage);

        SeekBar seekBar = dialog.findViewById(R.id.seekBar1);
        final EditText edit = dialog.findViewById(R.id.editText1);
        Button submit = dialog.findViewById(R.id.submitButton);

        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                edit.setText("" + progress);
            }
        });

        submit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        return dialog;
    }

}
