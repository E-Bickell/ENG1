package com.mygdx.heslingtonhustle;

public class Time {
    //Assuming timeSpeed:Real means to represent timeSpeed as a float/double
    double timeSpeed;
    Week week;

    /**
     * Constructor method
     */
    /*  In the architecture section it shows the Time class having a week, so I have called the constructor method for
        week within the constructor for time, but later on in the document it states that Menu new() should initialise
        Week, and that week should initialise Day and Time, so I am not sure if Week() should be called here
        or if Time() should be called in Week().
     */
    public Time(double speed) {
        timeSpeed = speed;
        week = new Week();
    }

    public void timeSkip() {

    }

    /*  Should probably just return the time(what time?), and the actual displaying of the time be done elsewhere.
        If elapsed runtime will be counted, it should probably be done within the main method, and then displayed.
        Unless a counter method is implemented here that will be called within the main method.


        long start = System.currentTimeMillis();

        //right before program ends

        long elapsedTimeMillis = System.currentTimeMillis()-start;
        float elapsedTimeMin = elapsedTimeMillis/(60*1000F);

     */
    public void displayTime() {

    }

}
