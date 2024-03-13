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

     boolean doActivity(Day day, Player player){
        if (!checkValid(day,player)){
            return false;
        }
       // recheck how this will be implemented
        player.tracker.addActivity(type);
        //update with actucal Player method
        player.energyUpdate(energyCost);
        //again check once day found
        day.timeSkip(timeCost);
        return true;
     }

     boolean checkValid(Day day, Player player){
        // day and player to be fixed when they exist
        if ((day.currentHour()-timeCost>=0) && (player.energyCheck()-energyCost>=0)){
            return true;
        }
        else{
             return false;
        }
     }
    
}
