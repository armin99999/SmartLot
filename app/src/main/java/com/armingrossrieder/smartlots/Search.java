package com.armingrossrieder.smartlots;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Search extends AppCompatActivity {

    /** Called when user wants to view current status of list of SmartLot 's */
    public void viewLots(View view) {
        startActivity(new Intent(Search.this, ListLots.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
    }
}
