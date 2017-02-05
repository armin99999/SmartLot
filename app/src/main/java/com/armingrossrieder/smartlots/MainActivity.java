package com.armingrossrieder.smartlots;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /** Real-time list of parking lots
     * - Constantly updates itself using our DB and user filters
     * - such as city, keywords etc*/
    public List<SmartLot> all_lots;

    public HashMap<SmartLot, Location> currLots;//sort them by closest to current user location



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SmartLot test = new SmartLot();
        currLots = new HashMap<SmartLot, Location>() ;
        currLots.put(test, test.getLocation());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public HashMap<SmartLot, Location> getCurrLots(){
        return currLots;
    }




    /** Called when the user wants to view his lots */
    public void setList_my_lots(View view) {
        startActivity(new Intent(MainActivity.this, ListMyLots.class));
    }

    /** Called when the user wants to search for lots */
    public void setSearch(View view) {
        startActivity(new Intent(MainActivity.this, Search.class));
    }

    /** Called when the user wants to view lots near him */
    public void setView_near_me(View view) {
        startActivity(new Intent(MainActivity.this, FEB6NearMe.class));
    }

    private class ListLots extends AppCompatActivity{


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

    }

}
