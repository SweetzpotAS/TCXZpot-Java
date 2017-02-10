package com.sweetzpot.tcxzpot;

import com.sweetzpot.tcxzpot.builders.ActivityBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Activities implements TCXSerializable {

    public static Activities activities(Activity... activities) {
        return new Activities(activities);
    }

    public static Activities activities(List<Activity> activities) {
        return new Activities(activities);
    }

    public static Activities activities(ActivityBuilder... activityBuilders) {
        List<Activity> activities = new ArrayList<>();
        for(ActivityBuilder builder : activityBuilders) {
            activities.add(builder.build());
        }
        return new Activities(activities);
    }

    private final List<Activity> activities;

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public Activities(Activity... activities) {
        this.activities = new ArrayList<>();
        Collections.addAll(this.activities, activities);
    }

    @Override
    public void serialize(Serializer serializer) {
        serializer.print("<Activities>");
        for(Activity activity : activities) {
            activity.serialize(serializer);
        }
        serializer.print("</Activities>");
    }
}
