package com.mygdx.heslingtonhustle;

public class Week {
    int currentWeekDay;
    Day[] weekDays;
    final int weekLength = 7;
    boolean weekEnd;
    int daysLeft;
    Time time; //Read Time() comment in Time Class

    /**
     * Constructor method
     */
    //Assuming currentWeekDay keeps track of the day with int 0-6 for use with the weekDays array
    public Week() {
        currentWeekDay = 0;
        weekEnd = false;
        daysLeft = weekLength;
        weekDays = new Day[weekLength];
        //time = new Time();

        for(int i=0; i<weekLength; i++)
        {
            weekDays[i] = new Day();
        }
    }


    //Assuming checkWeek() is used to get the number of days left in the week before the end of the game?
    public int checkWeek(){
        daysLeft = weekLength - (currentWeekDay);
        return daysLeft;
    }


    public boolean endWeek() {
        if(checkWeek() == 0) {
            weekEnd = true;

        }
        return weekEnd;
    }


    /*  Not sure what the difference between nextDay() and addDay() was meant to be, presumably it was to add the day
        to a weekDays arrayList but as the weekLength is set from the start, it makes more sense to just create the array
        of size weekLength(7), and use a loop to create all the days at once, as they should be independently accessed.
        Creating all the days at the start and storing them should not be an issue for performance.
     */
    public void nextDay() {
        if(!endWeek()) {
            currentWeekDay += 1;
        }
        else {
            System.out.println("Cannot increase weekDay, week has ended");
        }
    }

    public Day getCurrentWeekDay() {
        return weekDays[currentWeekDay];
    }

}
