package com.mygdx.heslingtonhustle;

import java.util.Dictionary;
import java.util.Hashtable;

public class ActivityTracker {
    ActivityTracker tracker;
    Dictionary<String, Integer> done= new Hashtable<>();

    private ActivityTracker(){
        done.put("eat",0);
        done.put("fun",0);
        done.put("study",0);
        done.put("sleep",0);

    }
    protected boolean addActivity(String type){
        done.put(type,done.get(type)+1);
        return true;
    }

    protected int getNumberOfType(String type){
        return(done.get(type));
    }
}

    

