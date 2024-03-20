package com.mygdx.heslingtonhustle;

import java.awt.Point;

public class Buildings {
    String name;
    float xStart;
    float yStart;
    float width;
    float height;
    String activityType;
    Activity activity;

    public Buildings(String buildingName, float x, float y, float width, float height, String buildingActivity) {
        name = buildingName;
        xStart = x;
        yStart = y;
        this.width = width;
        this.height = height;
        activityType = buildingActivity;

    }

    public void addAct(Activity activity) {
        this.activity = activity;
    }
    public void interact(Player p, Day d) {
        activity.doActivity(d,p);

    }


    public String getBuildAct() {
        return activityType;
    }
}
