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


    public int checkHour() {

        return currentHour;
    }



    public boolean endOfDay() {
        if(hours == dayLength) {
            dayEnd = true;
        }
        return dayEnd;
    }


    /*  Assuming nextHour() should increment currentHour by 1, meaning each activity only takes 1 hour
        However, I can see in Activity class that there is a variable timeCost for activities, so it makes more sense
        for nextHour() to use a getter from Activity object to get the timeCost and take it as a parameter to add that to
        currentHour
     */
    public void nextHour() {
        currentHour += 1;
        hours += 1;
        //currentHour += 'Activity'.getTimeCost();
        //hours += 'Activity'.getTimeCost();
        //why not just let activity pass timeCost to the funciton
    }

    //Returns how many hours are left, useful if for example an activity takes 2 hours, but only 1 hour is left until sleep
    public int getHoursLeft() {
        hoursLeft = dayLength - hours;
        return hoursLeft;
    }
}
