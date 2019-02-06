package com.example.android.s4s;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        ViewPager Pager = (ViewPager) findViewById(R.id.viewpager);

        tabpagerAdapter Tabpageradapter = new tabpagerAdapter(getSupportFragmentManager(),MainActivity.this);
        Pager.setAdapter(Tabpageradapter);
        tabLayout.setupWithViewPager(Pager);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final EditText search = (EditText) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Search=search.getText().toString();
                if(!TextUtils.isEmpty(Search)) {
                    Intent intent = new Intent(MainActivity.this, SearchResults.class);
                    startActivity(intent);
                }

            }
        });


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        assert drawer!=null;
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else super.onBackPressed();
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) { //different pages
        switch (item.getItemId()) {
            case R.id.old_transactions:
                Intent intent3 = new Intent(this, Old.class);
                startActivity(intent3);
                break;
            case R.id.notification:
                Intent intent7 = new Intent(this, Notification.class);
                startActivity(intent7);                break;
            case R.id.tnc:
                Intent intent1 = new Intent(this, TermsActivity.class);
                startActivity(intent1);
                break;

            case R.id.wishlist:
                Intent intent6 = new Intent(this, Wishlist.class);
                startActivity(intent6);
                break;
            case R.id.logout:
                Intent intent8 = new Intent(this, LoginActivity.class);
                startActivity(intent8);                break;
            case R.id.feedback_form:
                Intent intent2 = new Intent(this, Feedback.class);
                startActivity(intent2);
                break;

            case R.id.seller:
                Intent intent4 = new Intent(this, Seller.class);
                startActivity(intent4);
                break;

            case R.id.buyer:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void openProfile1(View view) {
        Intent intent = new Intent(MainActivity.this, Profile1.class);
        startActivity(intent);
    }

    public void openProfileEdit1(View view) {
        Intent i = new Intent(this, ProfileEdit1.class);
        startActivity(i);
    }

    public void openBuyer(View view) {

        String mess = "Updated Successfully";
        Toast.makeText(this, mess, Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void openPayment(View view)
    {
        Intent i = new Intent(this, payment.class);
        startActivity(i);
    }


}





