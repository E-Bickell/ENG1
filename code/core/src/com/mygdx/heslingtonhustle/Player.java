package com.mygdx.heslingtonhustle;

import java.awt.*;

public class Player {
    String name;
    int energy;
    int hunger;
    Point pos;
    ActivityTracker tracker;

    // initialises Player if no attributes are given
    public Player() {
        name = "TestPerson";
        energy = 10;
        hunger = 10;
        pos = new Point(0,0);
        tracker = ActivityTracker.getActivityTracker();
    }

    // initialises Player if attributes are given
    public Player(String name, int energy, int hunger, int x, int y) {
        this.name = name;
        this.energy = energy;
        this.hunger = hunger;
        this.pos = new Point(x, y);
        this.tracker = ActivityTracker.getActivityTracker();
    }

    // Player interacts with a building
    public void interact(Buildings building, Week week){
        Day currentDay = week.weekDays[week.currentWeekDay];
        if (building.activity.checkValid(currentDay,this)){
            building.interact(this, currentDay);
        }
    }

    // Player eats
    public void eat(){
        hunger += 10;
        tracker.addActivity("eat");
    }

    // Player sleeps
    public void sleep(Week week) {
        energy += 10;
        tracker.addActivity("sleep");
        week.nextDay();
    }

    // Returns how much energy the player currently has
    public int energyCheck(){
        return energy;
    }

    public int hungerCheck(){
        return hunger;
    }

    public void energyChange(int amount) {
        energy += amount;
    }
    public void move(float x, float y){
        pos.move((int) (pos.getX() + x), (int) (pos.getY() + y));
    }

    public int getX(){return (int) pos.getX();}

    public int getY(){return (int) pos.getY();}
}
