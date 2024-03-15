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
        player.tracker.addActivity(type);
        //update with actucal Player method still can't find player class
        player.energyUpdate(energyCost);
        //increment time- sub par but functional currently it's fine
        for i in range(0,timeCost){
             day.nextHour();
        }
        return true;
     }

     boolean checkValid(Day day, Player player){
        // player to be fixed when they exist
        if ((day.checkHour()+timeCost<=24) && (player.energyCheck()-energyCost>=0)){
            return true;
        }
        else{
             return false;
        }
     }
    
}
