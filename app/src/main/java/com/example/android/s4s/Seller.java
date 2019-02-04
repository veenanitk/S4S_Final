package com.example.android.s4s;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Seller extends AppCompatActivity {

    ImageView uploadfront, uploadback;
    Button textView4, textView5, button;
    AlertDialog.Builder builder;
    Intent I;
    EditText editText, editText2, editText3, editText4, editText5, editText7, editText8, editText9, editText10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        uploadfront = (ImageView) findViewById(R.id.uploadfront);
        builder = new AlertDialog.Builder(this);
        uploadback = (ImageView) findViewById(R.id.uploadback);
        textView4 = (Button) findViewById(R.id.textView4);
        textView5 = (Button) findViewById(R.id.textView5);
        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText7 = (EditText) findViewById(R.id.editText7);
        editText8 = (EditText) findViewById(R.id.editText8);
        editText9 = (EditText) findViewById(R.id.editText9);
        editText10 = (EditText) findViewById(R.id.editText10);
        //below content is for placing backbutton in th toolbar
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        // below code is the validation code for the details
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().equals("")) {
                    editText.setError("Name of the book is req");

                }
                if (editText2.getText().toString().equals("")) {
                    editText2.setError("Author's Name is req");

                }
                if (editText3.getText().toString().equals("")) {
                    editText3.setError("Expected price is req");

                }
                if (editText4.getText().toString().equals("")) {
                    editText4.setError("Edition is req");

                }
                if (editText5.getText().toString().equals("")) {
                    editText5.setError("Publisher's name is req");

                }
                if (editText7.getText().toString().equals("")) {
                    editText7.setError("enter you apartment/society/village name is req");
                }
                if (editText8.getText().toString().equals("")) {
                    editText8.setError("District name is req");

                }
                if (editText9.getText().toString().equals("")) {
                    editText9.setError("Pincode is req");

                }
                if (editText10.getText().toString().equals("")) {
                    editText10.setError("State name is req");

                }
                if(!editText.getText().toString().equals("") && !editText2.getText().toString().equals("") &&
                        !editText3.getText().toString().equals("") && !editText4.getText().toString().equals("") &&
                        !editText5.getText().toString().equals("") && !editText7.getText().toString().equals("") &&
                        !editText8.getText().toString().equals("") && !editText9.getText().toString().equals("") &&
                        !editText10.getText().toString().equals("")) {
                    startActivity(new Intent(Seller.this, Pop.class));
                    I = new Intent(getApplicationContext(), Pop.class);

                }


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


