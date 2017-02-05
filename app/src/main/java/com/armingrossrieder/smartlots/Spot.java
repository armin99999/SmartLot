package com.armingrossrieder.smartlots;

import android.location.Location;

/**
 * Created by armingrossrieder on 2/1/17.
 */

public class Spot{

    /** Location on map
     *  Format: array indexes that represent center of parking spot (pixel 2D array) */
    private int row;
    private int col;

    private int level;

    public Location location;

    public Spot(){

    }

    public Spot(int c_row, int c_col, int c_level){
        row = c_row;
        col = c_col;
        level = c_level;
    }

    public Spot(int c_row, int c_col){
        row = c_row;
        col = c_col;
    }


}
