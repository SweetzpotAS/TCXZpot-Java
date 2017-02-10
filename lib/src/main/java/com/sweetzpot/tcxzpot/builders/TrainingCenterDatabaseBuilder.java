package com.sweetzpot.tcxzpot.builders;

import com.sweetzpot.tcxzpot.AbstractSource;
import com.sweetzpot.tcxzpot.Activities;
import com.sweetzpot.tcxzpot.TrainingCenterDatabase;

public class TrainingCenterDatabaseBuilder {

    public static TrainingCenterDatabaseBuilder trainingCenterDatabase() {
        return new TrainingCenterDatabaseBuilder();
    }

    private TrainingCenterDatabaseBuilder() {}

    private Activities activities;
    private AbstractSource author;

    public TrainingCenterDatabaseBuilder withActivities(Activities activities) {
        this.activities = activities;
        return this;
    }

    public TrainingCenterDatabaseBuilder withAuthor(AbstractSource author) {
        this.author = author;
        return this;
    }

    public TrainingCenterDatabaseBuilder withAuthor(AbstractSourceBuilder authorBuilder) {
        this.author = authorBuilder.build();
        return this;
    }

    public TrainingCenterDatabase build() {
        return new TrainingCenterDatabase(activities, author);
    }
}
