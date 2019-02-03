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
import android.view.MenuItem;
import android.view.View;


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


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new com.example.android.s4s.Notifications()).commit();
                break;
            case R.id.tnc:
                Intent intent1 = new Intent(this, TNC.class);
                startActivity(intent1);
                break;

            case R.id.wishlist:
                Intent intent6 = new Intent(this, Wishlist.class);
                startActivity(intent6);
                break;
            case R.id.logout:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new com.example.android.s4s.Logout()).commit();
                break;
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

    public void openProfile(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);


    }

    public void openProfileEdit(View view) {
        Intent i = new Intent(this, ProfileEdit.class);
        startActivity(i);
    }

    public void openBuyer(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }


}





