package com.mygdx.heslingtonhustle;

/**
 * Represents a day in-game
 */
public class Day {
    final int dayLength = 16;
    int hours;
    int currentHour;
    boolean dayEnd;
    int hoursLeft;

    /**
     * Creates a new instance of Day
     */
    /*  Assuming hours is a counter of hours elapsed therefore initialised to 0
        Assuming currentHour should start at 8AM, with the day finishing at 24(00:00)
        Alternatively pass parameter for initialising current hour depending on when the player slept
     */
    public Day() {
        hours = 0;
        currentHour = 0;
        dayEnd = false;
        hoursLeft = dayLength;
    }

    /**
     * Returns the current hour
     */
    public int checkHour() {

        return currentHour;
    }

    /**
     * Returns true if the day has ended
     */
    public boolean endOfDay() {
        if(hours == dayLength) {
            dayEnd = true;
        }
        return dayEnd;
    }

    /**
     * Increments currentHour by the parameter passed
     * @param timeCost number of hours to increment currentHour by
     */
    /*  Assuming nextHour() should increment currentHour by 1, meaning each activity only takes 1 hour
        However, I can see in Activity class that there is a variable timeCost for activities, so it makes more sense
        for nextHour() to use a getter from Activity object to get the timeCost and take it as a parameter to add that to
        currentHour
     */
    public void nextHour(int timeCost) {
        currentHour += timeCost;
        hours += timeCost;

    }

    /**
     * Returns how many hours remain in the day
     */
    //Returns how many hours are left, useful if for example an activity takes 2 hours, but only 1 hour is left until sleep
    public int getHoursLeft() {
        hoursLeft = dayLength - hours;
        return hoursLeft;
    }
}
