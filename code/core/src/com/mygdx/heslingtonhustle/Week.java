package com.mygdx.heslingtonhustle;

/**
 * Represents a week in the game containing seven days
 */
public class Week {
    int currentWeekDay;
    Day[] weekDays;
    final int weekLength = 7;
    boolean weekEnd;
    int daysLeft;

    /**
     * Creates an instance of a Week which creates 7 Days
     */
    public Week() {
        //Assuming currentWeekDay keeps track of the day with int 0-6 for use with the weekDays array
        currentWeekDay = 0;
        weekEnd = false;
        daysLeft = weekLength;
        weekDays = new Day[weekLength];

        for(int i=0; i<weekLength; i++)
        {
            weekDays[i] = new Day();
        }
    }

    /**
     * Returns how many days are left in the Week
     */
    //Assuming checkWeek() is used to get the number of days left in the week before the end of the game
    public int checkWeek(){
        daysLeft = weekLength - (currentWeekDay);
        return daysLeft;
    }

    /**
     * Returns true if the week has finished
     * @return weekEnd which is false by default
     */
    public boolean endWeek() {
        if(checkWeek() == 0) {
            weekEnd = true;

        }
        return weekEnd;
    }

    /**
     * If the week has not ended, changes the currentWeekDay to the next one
     */
    public void nextDay() {
        if(!endWeek()) {
            currentWeekDay += 1;
        }
    }

    /**
     * Returns the current Day in the Week
     * @return the instance of Day referenced by the currentWeekDay counter
     */
    public Day getCurrentWeekDay() {
        return weekDays[currentWeekDay];
    }

}
