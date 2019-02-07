package com.example.android.s4s;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.widget.Toast;

public class MainActivitywish extends AppCompatActivity {
    Button buy;


    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buy = (Button) findViewById(R.id.buyall);
        builder = new AlertDialog.Builder(this);

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Uncomment the below code to Set the message and title from the strings.xml file
                builder.setMessage("buyall").setTitle("buyall");

                //Setting message manually and performing action on button click
                builder.setMessage("Do you want to buy all the books in the wishlist??")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                Toast.makeText(getApplicationContext(), "Order Placed!!",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(), "Order cancelled!!",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Confirm");
                alert.show();


            }


        });
    }
}
