package com.armingrossrieder.smartlots;

import android.location.Location;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by armingrossrieder on 2/1/17.
 */

public class SmartLot {

    private Location location;
    private String password;//for admin roles

    private Location destination;

    private PriorityQueue<Spot> spots;


    /** Specs of SmartLot */
    private int levels;

    public SmartLot(){

        spots = new PriorityQueue<Spot>(10, comparator);
        searchSpot("Select Spot_ID From Lot_106 Where Sensor_Value =1");
    }

    public Location getLocation(){
        return destination;
    }

    private Comparator<Spot> comparator = new Comparator<Spot>() {
        /** Return 1 if x is better than y
         *  Return 0 if x is worse than y
         *  Return -1 for error */
        @Override
        public int compare(Spot x, Spot y){
            float[] xxx = null, yyy = null;
            if(x==null || y==null) return -1;
            Location.distanceBetween(x.location.getLatitude(), x.location.getLongitude(), destination.getLatitude(), destination.getLongitude(), xxx);
            Location.distanceBetween(y.location.getLatitude(), y.location.getLongitude(), destination.getLatitude(), destination.getLongitude(), yyy);
            if(xxx[0] > yyy[0]) return 0;
            return 1;
        }
    };

    public void print(){

    }

    public void searchSpot(String query){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Create a connection string
            String url = "jdbc:mysql://smartparking.cywye26tvru5.us-east-1.rds.amazonaws.com:3306/SmartLot";


            //Create a connection to your DB
            Connection con = DriverManager.getConnection(url, "CS442", "password");

            //Create a SQL statement
            Statement stmt = con.createStatement();
            ResultSet rs;

            //Query for occupied spots
            rs=stmt.executeQuery(query);
            while(rs.next()){
                String Occupied= rs.getString("Spot_ID");
                System.out.println("Available spot");
                System.out.println(Occupied);
            }
            //close the connection.
            con.close();

        }catch( ClassNotFoundException c){ System.out.println("Package Error."); }
        catch ( SQLException s){System.out.println("SQL Error.");}
    }



}
