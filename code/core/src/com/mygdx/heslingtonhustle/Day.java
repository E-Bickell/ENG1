package com.mygdx.heslingtonhustle;

public class Day {
    final int dayLength = 16;
    int hours;
    int currentHour;
    boolean dayEnd; //read endOfDay() comment
    int hoursLeft;

    /**
     * Constructor method
     */
    /*  Assuming hours is a counter of hours elapsed therefore initialised to 0
        Assuming currentHour should start at 8AM, with the day finishing at 24(00:00)
        Alternatively pass parameter for initialising current hour depending on when the player slept
     */
    public Day() {
        hours = 0;
        currentHour = 8;
        dayEnd = false;
        hoursLeft = dayLength;
    }
    /*
    public Day(int wakeTime) {
        hours = 0;
        currentHour = wakeTime;
        dayEnd = false;
    }
     */


    /*  Assuming checkHour(), endOfDay(), and nextHour() should only be called by the Day object itself, therefore private methods
        currentHour seems irrelevant right now, maybe useful if we want to display the time of day (not real-world time elapsed)
     */

    private int checkHour() {

        return currentHour;
    }


    /*  Assuming endOfDay() checks if the day should end (if hours == dayLength, i.e. it is bedtime), therefore returns a boolean.
        Alternatively endOfDay returns nothing, and merely sets boolean to true, which the Week class must then use a getter to retrieve -
        in order to check if it should end the current day and call nextDay().
     */
    private boolean endOfDay() {
        if(hours == dayLength) {
            dayEnd = true;
        }
        return dayEnd;
    }


    /*  Assuming nextHour() should increment currentHour by 1, meaning each activity only takes 1 hour
        However, I can see in Activity class that there is a variable timeCost for activities, so it makes more sense
        for nextHour() to use a getter from Activity object to get the timeCost and add that to currentHour
     */
    private void nextHour() {
        currentHour += 1;
        hours += 1;
        //currentHour += 'Activity'.getTimeCost();
        //hours += 'Activity'.getTimeCost();
    }

    //Returns how many hours are left, useful if for example an activity takes 2 hours, but only 1 hour is left until sleep
    private int getHoursLeft() {
        hoursLeft = dayLength - hours;
        return hoursLeft;
    }
}
