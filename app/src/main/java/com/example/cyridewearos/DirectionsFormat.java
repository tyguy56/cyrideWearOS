package com.example.cyridewearos;

import com.example.cyridewearos.StopsFormat;

import java.util.ArrayList;

public class DirectionsFormat {

    private boolean IsSegment;
    private int RouteID;
    private int ID;
    private String Name;
    private String Directionality;
    private ArrayList<StopsFormat> Stops;

    public boolean isSegment() {
        return IsSegment;
    }

    public void setSegment(boolean segment) {
        IsSegment = segment;
    }

    public int getRouteID() {
        return RouteID;
    }

    public void setRouteID(int routeID) {
        RouteID = routeID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDirectionality() {
        return Directionality;
    }

    public void setDirectionality(String directionality) {
        Directionality = directionality;
    }

    public ArrayList<StopsFormat> getStops() {
        return Stops;
    }

    public void setStops(ArrayList<StopsFormat> stops) {
        Stops = stops;
    }


}
