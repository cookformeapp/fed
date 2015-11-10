package com.example.john.cookforme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.view.View;
import android.widget.Toast;

import eat.section.content.Food_Fragment;
import eat.section.content.Location_Fragment;
import eat.section.content.ShoppingCart_Fragment;
import eat.section.content.profile_page;

public class eat_main_page extends AppCompatActivity {
    private android.support.v7.widget.Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setStatusBarColor(this.getResources().getColor(R.color.colorPrimaryDark)); //Sets the status bar color
        setContentView(R.layout.activity_eat_main_page);

        //Setup Action Bar from customized toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initialize the layout and drawer view
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        //Set Default Loading Page after Entering
        Food_Fragment food_fragment1 = new Food_Fragment();
        FragmentTransaction food_fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        food_fragmentTransaction1.replace(R.id.fragmentholder,food_fragment1);
        food_fragmentTransaction1.commit();
        toolbar.setTitle("Food");

        //Fill the drawer with items that can be selected
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
        public boolean onNavigationItemSelected(MenuItem menuItem){
                //Checking if the item is in checked state or not, if not make it in checked state
                if(menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                switch (menuItem.getItemId()){

                    // For rest of the options we just show a toast on click

                    case R.id.food_item:
                        Toast.makeText(getApplicationContext(), "Food Refreshing", Toast.LENGTH_SHORT).show();
                        Food_Fragment food_fragment = new Food_Fragment();
                        FragmentTransaction food_fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        food_fragmentTransaction.replace(R.id.fragmentholder, food_fragment);
                        food_fragmentTransaction.commit();
                        toolbar.setTitle("Food");
                        break;
                    case R.id.location_item:
                        Toast.makeText(getApplicationContext(), "Location Refreshing", Toast.LENGTH_SHORT).show();
                        Location_Fragment location_fragment = new Location_Fragment();
                        FragmentTransaction location_fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        location_fragmentTransaction.replace(R.id.fragmentholder,location_fragment);
                        location_fragmentTransaction.commit();
                        toolbar.setTitle("Location");
                        break;
                    case R.id.favorite_item:
                        Toast.makeText(getApplicationContext(),"Favorite Refreshing",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.shopping_cart_item:
                        Toast.makeText(getApplicationContext(),"Shopping Cart Refreshing",Toast.LENGTH_SHORT).show();
                        ShoppingCart_Fragment shoppingCart_fragment = new ShoppingCart_Fragment();
                        FragmentTransaction shoppingCart_fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        shoppingCart_fragmentTransaction.replace(R.id.fragmentholder, shoppingCart_fragment);
                        shoppingCart_fragmentTransaction.commit();
                        toolbar.setTitle("Shopping Cart");
                        break;
                }
            return true; }
        });
        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.DrawerOpened, R.string.DrawerClosed){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_eat_main_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }

    public void profile_page_direct(View view){
        Intent intent = new Intent(this, profile_page.class);
        startActivity(intent);
    }


}