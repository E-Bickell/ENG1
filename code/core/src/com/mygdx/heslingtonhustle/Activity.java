package com.mygdx.heslingtonhustle;

public class Activity {
     String name;
     String type;
     int timeCost;
     int energyCost;
    

     public Activity(String activityName,String activityType,int time,int energy){
        name=activityName;
        type=activityType;
          //positive for amount of time takes
        timeCost=time;
          //negative for how much energy needs to be changed by
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
            player.scoreChange(2);
        }
        else if(type.equals("Study")) {
            player.scoreChange(5);
        }
        player.tracker.addActivity(type);
        return true;
     }

     boolean checkValid(Day day, Player player){
        if ((day.checkHour()+timeCost<=24) && (player.energyCheck()+energyCost>=0)){
            return true;
        }
        else{
             return false;
        }
     }
    
}
