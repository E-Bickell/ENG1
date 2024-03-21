package com.mygdx.heslingtonhustle;

public class Activity {
     String name;
     String type;
     int timeCost;
     int energyCost;
    

     public Activity(String activityName,String actvityType,int time,int energy){
        name=activityName;
        type=actvityType;
          //positive for amount of time takes
        timeCost=time;
          //negitive for how much energy needs to be changed by
        energyCost=energy;
     }

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
            //Score functions
        }
        else if(type.equals("Study")) {
            //score functions
        }
        //player.tracker.addActivity(type);
        player.energyChange(energyCost);
        return true;
     }

     boolean checkValid(Day day, Player player){
        if ((day.checkHour()+timeCost<=16) && (player.energyCheck()-energyCost>=0)){
            return true;
        }
        else{
             return false;
        }
     }
    
}
