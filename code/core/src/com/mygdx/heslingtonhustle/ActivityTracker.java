package com.mygdx.heslingtonhustle;


import java.util.Dictionary;
import java.util.Hashtable;

public class ActivityTracker {
    private static ActivityTracker tracker;
    Dictionary<String, Integer> done= new Hashtable<>();

    public ActivityTracker(){
        done.put("Eat",0);
        done.put("Recreational",0);
        done.put("Study",0);
        done.put("Sleep",0);

    }
    public static ActivityTracker getActivityTracker(){
        if (tracker==null){
            tracker= new ActivityTracker();
        }
        return tracker;
    }
    protected boolean addActivity(String type){
        done.put(type,done.get(type)+1);
        return true;
    }

    protected int getNumberOfType(String type){
        return(done.get(type));
    }
    Dictionary<String, Integer> getDone(){
        return(done);
    }
}
