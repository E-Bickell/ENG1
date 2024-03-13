package com.mygdx.heslingtonhustle;

public class Activity {
     String name;
     String type;
     String description;
     int timeCost;
     int energyCost;
    

     Activity(String activityName,String actvityType, String activityDesc,int time,int energy){
        name=activityName;
        type=actvityType;
        description=activityDesc;
        timeCost=time;
        energyCost=energy;
     }

     boolean doActivity(ActivityTracker tracker,Day day, Player player){
        if (!checkValid(day,player)){
            return false;
        }
        tracker.addActivity(type);
        return true;
     }

     boolean checkValid(Day day, Player player){
        // day and player to be fixed when they exist
        if ((day.currentHour()-timeCost>=0) && (player.energyCheck()-energyCost>=0)){
            return true;
        }
        else{return false;}
     }
    
}
