package com.mygdx.heslingtonhustle;

/**
 * Represents an activity available to the player
 */
public class Activity {
     String name;
     String type;
     int timeCost;
     int energyCost;

    /**
     * Creates a new instance of Activity
     * @param activityName
     * @param activityType
     * @param time
     * @param energy
     */
     public Activity(String activityName,String activityType,int time,int energy){
        name=activityName;
        type=activityType;
          //positive for amount of time takes
        timeCost=time;
          //negative for how much energy needs to be changed by
        energyCost=energy;
     }

    /**
     * Does activity and updates relevant player attributes
     * @param week
     * @param player
     * @return false if activity is not possible, true otherwise
     */
     public boolean doActivity(Week week, Player player) {
        Day day = week.getCurrentWeekDay();
        if (!checkValid(day,player)) {
            return false;
        }
        day.nextHour(timeCost);
        player.energyChange(energyCost);
        if (type.equals("Sleep")){
            player.sleep(week);
        }
        else if(type.equals("Eat")) {
            player.eat();
        }
        else if(type.equals("Recreational")) {
            player.scoreChange(2);
        }
        else if(type.equals("Study")) {
            player.scoreChange(5);
        }
        player.tracker.addActivity(type);
        return true;
     }

    /**
     * Checks if the activity can be performed by the player
     * @param day
     * @param player
     * @return true if player has enough energy and time remaining, false otherwise
     */
     boolean checkValid(Day day, Player player){
        if ((day.checkHour()+timeCost<=24) && (player.energyCheck()+energyCost>=0)){
            return true;
        }
        else{
             return false;
        }
     }
    
}
