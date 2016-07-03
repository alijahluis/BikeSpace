package com.capstone.bikespace.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityFeed {
    private String activityOwner;
    private String activityName;
    private String activityDesc;

    public ActivityFeed() {
    }

    public String getActivityOwner() {
        return activityOwner;
    }

    public void setActivityOwner(String activityOwner) {
        this.activityOwner = activityOwner;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
    }
}
