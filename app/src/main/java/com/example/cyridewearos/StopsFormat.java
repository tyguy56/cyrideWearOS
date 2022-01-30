package com.example.cyridewearos;

public class StopsFormat {

    private int ID;
    private String Image;
    private float Latitude;
    private float Longitude;
    private String Name;
    private int RtpiNumber;
    private boolean ShowLabel;
    private boolean ShowStopRtpiNumberLabel;
    private boolean ShowVehicleName;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public float getLatitude() {
        return Latitude;
    }

    public void setLatitude(float latitude) {
        Latitude = latitude;
    }

    public float getLongitude() {
        return Longitude;
    }

    public void setLongitude(float longitude) {
        Longitude = longitude;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getRtpiNumber() {
        return RtpiNumber;
    }

    public void setRtpiNumber(int rtpiNumber) {
        RtpiNumber = rtpiNumber;
    }

    public boolean isShowLabel() {
        return ShowLabel;
    }

    public void setShowLabel(boolean showLabel) {
        ShowLabel = showLabel;
    }

    public boolean isShowStopRtpiNumberLabel() {
        return ShowStopRtpiNumberLabel;
    }

    public void setShowStopRtpiNumberLabel(boolean showStopRtpiNumberLabel) {
        ShowStopRtpiNumberLabel = showStopRtpiNumberLabel;
    }

    public boolean isShowVehicleName() {
        return ShowVehicleName;
    }

    public void setShowVehicleName(boolean showVehicleName) {
        ShowVehicleName = showVehicleName;
    }

}
