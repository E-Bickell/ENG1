package com.mygdx.heslingtonhustle;

import java.awt.Point;

public class Buildings {
    String name;
    String type;
    Point position;
    String activityType;
    Activity activity;

    public Buildings(String buildingName, String buildingType, Point buildingPos, String buildingActivity) {
        name = buildingName;
        type = buildingType;
        position = buildingPos;
        activityType = buildingActivity;

    }

    public void addAct() {

    }
    public void interact(Player p, Day d) {
        activity.doActivity(d,p);

    }


    public String getBuildAct() {
        return activityType;
    }
}
