package com.zzk.moduleenum;

public enum Belong {
    LEADER("领导"),
    MAINTENANCE("保养"),
    CHANGE_TARGET("换靶");

    private final String name;
 
    Belong(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
