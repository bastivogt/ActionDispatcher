package com.herr.vogt.actions;

import java.util.HashMap;

public class ActionDispatcher {

    protected HashMap<String, ActionListener> actions;


    public ActionDispatcher() {
        actions = new HashMap<>();
    }


    public HashMap<String, ActionListener> getActions() {
        return actions;
    }

    public Boolean hasAction(String type) {
        return actions.containsKey(type);
    }


    public Boolean addAction(String type, ActionListener listener) {
        if(!hasAction(type)) {
            actions.put(type, listener);
            return true;
        }
        return false;
    }




    public Boolean removeAction(String type) {
        if(hasAction(type)) {
            actions.remove(type);
            return true;
        }
        return false;
    }


    public void dispatchAction(String type, Object source) {
        if(hasAction(type)) {
            actions.get(type).onAction(type, source);
        }
    }
}
