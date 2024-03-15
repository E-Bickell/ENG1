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
          //positive for amount of time takes
        timeCost=time;
          //negitive for how much energy needs to be changed by
        energyCost=energy;
     }

     boolean doActivity(Day day, Player player){
        if (!checkValid(day,player)){
            return false;
        }
        player.tracker.addActivity(type);
        player.energyChange(energyCost);
        //increment time- sub par but functional currently it's fine
        for i in range(0,timeCost){
             day.nextHour();
        }
        return true;
     }

     boolean checkValid(Day day, Player player){
        if ((day.checkHour()+timeCost<=24) && (player.energyCheck()-energyCost>=0)){
            return true;
        }
        else{
             return false;
        }
     }
    
}
