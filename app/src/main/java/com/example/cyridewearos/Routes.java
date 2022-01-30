package com.example.cyridewearos;

import java.util.ArrayList;

public class Routes {

    public Object getDirectionStops() {
        return DirectionStops;
    }

    public void setDirectionStops(Object directionStops) {
        DirectionStops = directionStops;
    }

    private Object DirectionStops;
    private boolean ArrivalsEnabled;
    private boolean ArrivalsShowVehicleNames;
    private String BackwardDirectionName;
    private String Color;
    private int CustomerID;
    private String DisplayName;
    private String ForwardDirectionName;
    private int ID;
    private boolean IsHeadway;
    private String Name;
    private int NumberOfVehicles;
    private ArrayList<Object> Patterns;
    private Object Points;
    private ArrayList<Integer> RegionIDs;
    private String ShortName;
    private boolean ShowLine;
    private String TextColor;

    public boolean isArrivalsEnabled() {
        return ArrivalsEnabled;
    }

    public void setArrivalsEnabled(boolean arrivalsEnabled) {
        ArrivalsEnabled = arrivalsEnabled;
    }

    public boolean isArrivalsShowVehicleNames() {
        return ArrivalsShowVehicleNames;
    }

    public void setArrivalsShowVehicleNames(boolean arrivalsShowVehicleNames) {
        ArrivalsShowVehicleNames = arrivalsShowVehicleNames;
    }

    public String getBackwardDirectionName() {
        return BackwardDirectionName;
    }

    public void setBackwardDirectionName(String backwardDirectionName) {
        BackwardDirectionName = backwardDirectionName;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public String getForwardDirectionName() {
        return ForwardDirectionName;
    }

    public void setForwardDirectionName(String forwardDirectionName) {
        ForwardDirectionName = forwardDirectionName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean isHeadway() {
        return IsHeadway;
    }

    public void setHeadway(boolean headway) {
        IsHeadway = headway;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getNumberOfVehicles() {
        return NumberOfVehicles;
    }

    public void setNumberOfVehicles(int numberOfVehicles) {
        NumberOfVehicles = numberOfVehicles;
    }

    public ArrayList<Object> getPatterns() {
        return Patterns;
    }

    public void setPatterns(ArrayList<Object> patterns) {
        Patterns = patterns;
    }

    public Object getPoints() {
        return Points;
    }

    public void setPoints(Object points) {
        Points = points;
    }

    public ArrayList<Integer> getRegionIDs() {
        return RegionIDs;
    }

    public void setRegionIDs(ArrayList<Integer> regionIDs) {
        RegionIDs = regionIDs;
    }

    public String getShortName() {
        return ShortName;
    }

    public void setShortName(String shortName) {
        ShortName = shortName;
    }

    public boolean isShowLine() {
        return ShowLine;
    }

    public void setShowLine(boolean showLine) {
        ShowLine = showLine;
    }

    public String getTextColor() {
        return TextColor;
    }

    public void setTextColor(String textColor) {
        TextColor = textColor;
    }


    @Override
    public String toString(){

        return this.getDisplayName();
    }
}
