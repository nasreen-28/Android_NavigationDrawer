package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nav = (NavigationView)findViewById(R.id.navmenu);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);

        toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.settings:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        startActivity(new Intent(MainActivity.this,settings.class));
                        break;
                    case R.id.reminder:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        startActivity(new Intent(MainActivity.this,reminder.class));
                        break;
                    case R.id.support:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        startActivity(new Intent(MainActivity.this,support.class));
                        break;
                    case R.id.logout:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(getApplicationContext(),"You have logged out successfully",Toast.LENGTH_LONG).show();
                        break;

                }
                return true;
            }
        });
    }
}