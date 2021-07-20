package com.sethip.main.models;

import java.util.Date;

public class Job {
    String name;
    Date startTime;
    int frequency; // in hrs
    Date endTime;
    Date lastRunTime;

    public Job(String name, Date startTime, int frequency, Date endTime) {
        this.name = name;
        this.startTime = startTime;
        this.frequency = frequency;
        this.endTime = endTime;
        this.lastRunTime = null;
    }

    public Date getStartTime() {
        return startTime;
    }

    public int getFrequency() {
        return frequency;
    }

    public Date getLastRunTime() {
        return lastRunTime;
    }

    public void setLastRunTime(Date lastRunTime) {
        this.lastRunTime = lastRunTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void run() {
        // Threading
        System.out.println("Started Job: " + this.name + "!");
        System.out.println("Going for sleep for 5 secs");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Resumed after 5 secs");
        System.out.println("Job " + this.name + " completed!");
    }
}
