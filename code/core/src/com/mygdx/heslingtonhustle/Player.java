package com.mygdx.heslingtonhustle;

/**
 * Represents the player character
 */
public class Player {
    String name;
    int energy;
    int hunger;
    float posX;
    float posY;
    ActivityTracker tracker;
    int score;

    /**
     * Creates an instance of Player
     */
    // initialises Player if no attributes are given
    public Player() {
        name = "TestPerson";
        energy = 10;
        hunger = 10;
        posX = 400;
        posY = 240;
        score = 0;
        tracker = ActivityTracker.getActivityTracker();

    }

    /**
     * Creates an instance of Player with specified attributes
     * @param name
     * @param energy
     * @param hunger
     * @param x position
     * @param y position
     * @param score
     */
    // initialises Player if attributes are given
    public Player(String name, int energy, int hunger, int x, int y, int score) {
        this.name = name;
        this.energy = energy;
        this.hunger = hunger;
        this.posX = x;
        this.posY = y;
        this.score = score;
        this.tracker = ActivityTracker.getActivityTracker();
    }

    /**
     * Allows the Player to interact with a Building and therefore an Activity
     * @param building
     * @param week
     */
    // Player interacts with a building
    public void interact(Buildings building, Week week){
        Day currentDay = week.weekDays[week.currentWeekDay];
        if (building.activity.checkValid(currentDay,this)){
            building.interact(this, week);
        }
    }

    /**
     * Increments hunger by 5
     */
    public void eat(){
        hunger += 5;
    }

    /**
     * Tries to change to the next day and resets player attributes to daily starting values
     * @param week
     */
    public void sleep(Week week) {
        week.nextDay();
        resetPlayer();
    }

    /**
     * Returns how much energy the player currently has
     * @return energy
     */
    public int energyCheck(){
        return energy;
    }

    /**
     * Returns how much hunger the player currently has
     * @return hunger
     */
    public int hungerCheck(){
        return hunger;
    }

    /**
     * Changes the Player energy by the amount passed
     * @param amount amount to change energy by
     */
    public void energyChange(int amount) {
        energy += amount;
    }

    /**
     * Changes the Player score by the amount passed
     * @param amount amount to change score by
     */
    public void scoreChange(int amount) {
        score += amount;
    }

    /**
     * Returns the Player's score
     */
    public int getScore() {
        return score;
    }

    /**
     * Changes the Player's position by the parameters passed
     * @param x amount to change x position by
     * @param y amount to change y position by
     */
    public void move(float x, float y){
        this.posX += x;
        this.posY += y;
    }

    /**
     * Returns the Player's x position
     */
    public float getX(){return posX;}

    /**
     * Returns the Player's y position
     */
    public float getY(){return posY;}

    /**
     * Resets the Player's attributes to the default daily amount
     */
    public void resetPlayer() {
        energy = 10;
        hunger = 10;
        posX = 400;
        posY = 240;

    }

}
