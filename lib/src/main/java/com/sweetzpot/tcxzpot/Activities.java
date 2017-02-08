package com.sweetzpot.tcxzpot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Activities {

    private final List<Activity> activities;

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public Activities(Activity... activities) {
        this.activities = new ArrayList<>();
        Collections.addAll(this.activities, activities);
    }
}
