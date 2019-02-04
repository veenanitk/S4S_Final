package com.example.android.s4s;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class Profile extends MainActivity
{
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent back=new Intent(Profile.this,MainActivity.class);
        startActivity(back);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ImageButton ib = (ImageButton) findViewById(R.id.edit);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            @NonNull
            public void onClick(View v) {
                openProfileEdit(v);
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }


}