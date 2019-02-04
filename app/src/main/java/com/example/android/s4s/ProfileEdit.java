package com.example.android.s4s;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class ProfileEdit extends MainActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_edit);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ImageButton ib = (ImageButton) findViewById(R.id.tick);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            @NonNull
            public void onClick(View v) {
                openBuyer(v);
            }
        });



        /**
         * Error display for invalid phone
         */

    }








    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }


}