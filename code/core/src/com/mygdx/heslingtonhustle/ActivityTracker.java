package com.mygdx.heslingtonhustle;


import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Keeps track of number of each type of activity performed
 */
public class ActivityTracker {
    private static ActivityTracker tracker;
    Dictionary<String, Integer> done= new Hashtable<>();

    /**
     * Creates a new activity tracker with count values set to 0
     */
    public ActivityTracker(){
        done.put("Eat",0);
        done.put("Recreational",0);
        done.put("Study",0);
        done.put("Sleep",0);

    }

    /**
     * Returns the activity tracker
     * @return tracker
     */
    public static ActivityTracker getActivityTracker(){
        if (tracker==null){
            tracker= new ActivityTracker();
        }
        return tracker;
    }

    /**
     * Adds 1 to the amount of times a specific type of activity has been done
     * @param type type of activity
     * @return true
     */
    protected boolean addActivity(String type){
        done.put(type,done.get(type)+1);
        return true;
    }

    /**
     * Returns how many times a specific type of activity has been done
     * @param type type of activity
     * @return number of times activity specified by type is performed
     */
    protected int getNumberOfType(String type){
        return(done.get(type));
    }
}
