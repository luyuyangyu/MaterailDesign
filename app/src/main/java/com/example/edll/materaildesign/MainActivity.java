package com.example.edll.materaildesign;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.edll.materaildesign.Nav.Call;
import com.example.edll.materaildesign.Nav.Friends;
import com.example.edll.materaildesign.Nav.Location;
import com.example.edll.materaildesign.Nav.Mail;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=new Intent(MainActivity.this,Login.class);
        startActivity(intent);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navView = findViewById(R.id.nav_view);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.menu_48);
        }
        navView.setCheckedItem(R.id.nav_call);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //mDrawerLayout.closeDrawers();
                switch (menuItem.getItemId()){
                    case R.id.nav_call:
                        Intent intent = new Intent(MainActivity.this,Call.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_friends:
                        Intent intent2 = new Intent(MainActivity.this,Friends.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_mail:
                        Intent intent3 = new Intent(MainActivity.this,Mail.class);
                        startActivity(intent3);
                        break;
                    case R.id.location:
                        Intent intent4 = new Intent(MainActivity.this,Location.class);
                        startActivity(intent4);
                        break;

                    default:
                }
                return true;
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.back:
                onBackPressed();
                break;
            case R.id.delete:
                Toast.makeText(this,"You Clicked Delete",Toast.LENGTH_LONG).show();
                break;
            case R.id.settings:
                Toast.makeText(this,"You clicked Setting",Toast.LENGTH_LONG).show();
                break;
            default:
        }
        return true;
    }



}
