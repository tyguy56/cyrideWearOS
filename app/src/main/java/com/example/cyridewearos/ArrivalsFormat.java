package com.example.cyridewearos;

import java.util.ArrayList;

public class ArrivalsFormat {

    private int RouteID;
    private ArrayList<ArrivalsInfo> Arrivals;

    public int getRouteID() {
        return RouteID;
    }

    public void setRouteID(int routeID) {
        RouteID = routeID;
    }

    public ArrayList<ArrivalsInfo> getArrivals() {
        return Arrivals;
    }

    public void setArrivals(ArrayList<ArrivalsInfo> arrivals) {
        Arrivals = arrivals;
    }

}
