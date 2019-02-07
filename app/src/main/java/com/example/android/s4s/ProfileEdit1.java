package com.example.android.s4s;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class ProfileEdit1 extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
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


    }
    public void onBackPressed(){
        Intent i = new Intent(this, Profile1.class);
        startActivity(i);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

}
