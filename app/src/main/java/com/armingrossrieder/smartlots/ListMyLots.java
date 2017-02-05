package com.armingrossrieder.smartlots;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ListMyLots extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_my_lots);

        test1();
    }

    public void test1(){
        SmartLot sm = new SmartLot();
    }
}
