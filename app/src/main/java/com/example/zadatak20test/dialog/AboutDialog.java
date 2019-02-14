package com.example.zadatak20test.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.zadatak20test.R;
import com.example.zadatak20test.activities.MainActivity;

public class AboutDialog extends AlertDialog.Builder {


    public AboutDialog(final Context context) {
        super(context);

        setTitle("About Application");
        setMessage("Here we store informations about most popular ACTORS. Do You like the application?");
        setCancelable(false);

        setPositiveButton("Yes,I do.", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               dialog.dismiss();
                Toast.makeText(getContext(), "Thank you", Toast.LENGTH_LONG).show();


            }});

        setNegativeButton("No, i don't.", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Toast.makeText(getContext(),"We're sorry to hear that",Toast.LENGTH_LONG).show();
            }
        });


    }

    public AlertDialog prepareDialog() {

    AlertDialog alertDialog = create();
    alertDialog.setCanceledOnTouchOutside(false);
    return alertDialog;

    }


}