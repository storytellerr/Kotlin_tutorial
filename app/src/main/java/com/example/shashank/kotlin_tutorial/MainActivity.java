package com.example.shashank.kotlin_tutorial;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         *Setup the DrawerLayout and NavigationView
         */

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.sidemenu) ;
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();
        /**
         * Setup click events on the Navigation View Items.
         */

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();



                if (menuItem.getItemId() == R.id.home) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();

                }

                if (menuItem.getItemId() == R.id.variable1) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView,new FragmentOne()).commit();
                }
                if (menuItem.getItemId()==R.id.variable2)
                {
                    FragmentTransaction xfragmentTransaction =mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView,new FragmentTwo()).commit();
                }

                if(menuItem.getItemId()==R.id.variable3)
                {
                    Toast.makeText(getApplicationContext(),"variable3",Toast.LENGTH_LONG).show();

                }
                if(menuItem.getItemId()==R.id.settigs)
                {
                    Toast.makeText(getApplicationContext(),"settings",Toast.LENGTH_LONG).show();

                }
                if(menuItem.getItemId()==R.id.about)
                {
                    Toast.makeText(getApplicationContext(),"about",Toast.LENGTH_LONG).show();

                }
                if(menuItem.getItemId()==R.id.variable4)
                {
                    Toast.makeText(getApplicationContext(),"variable4",Toast.LENGTH_LONG).show();

                }


                return false;
            }

        });
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar,R.string.app_name,
                R.string.app_name);

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();

    }
}