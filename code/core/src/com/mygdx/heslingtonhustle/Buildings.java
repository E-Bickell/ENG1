package com.mygdx.heslingtonhustle;

/**
 * Represents a building containing an activity
 */
public class Buildings {
    String name;
    float xStart;
    float yStart;
    float width;
    float height;
    String activityType;
    Activity activity;

    /**
     * Creates a new building object
     * @param buildingName
     * @param x x position of building
     * @param y y position of building
     * @param width of building
     * @param height of building
     * @param buildingActivity type of activity offered
     */
    public Buildings(String buildingName, float x, float y, float width, float height, String buildingActivity) {
        name = buildingName;
        xStart = x;
        yStart = y;
        this.width = width;
        this.height = height;
        activityType = buildingActivity;

    }

    /**
     * Sets this Building's Activity to the Activity passed
     * @param activity new Activity
     */
    public void addAct(Activity activity) {
        this.activity = activity;
    }

    /**
     * Calls doActivity
     * @param p the Player
     * @param w the Week
     */
    public void interact(Player p, Week w) {
        activity.doActivity(w,p);

    }
}
