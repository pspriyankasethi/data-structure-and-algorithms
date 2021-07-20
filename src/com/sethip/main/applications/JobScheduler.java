package com.sethip.main.applications;

import com.sethip.main.models.Job;

import java.util.*;

public class JobScheduler {
    List<Job> liveJobs;
    List<Job> completedJobs;

    public JobScheduler() {
        liveJobs = new LinkedList<>();
        completedJobs = new LinkedList<>();
    }

    public void add(Job job) {
        liveJobs.add(job);
    }

    public void poll() {
        if(liveJobs.isEmpty()) {
            return;
        }
        for(Job job: liveJobs) {
            if(null != job.getEndTime() && (new Date()).compareTo(job.getEndTime()) > 0) {
                liveJobs.remove(job);
                completedJobs.add(job);
            }
            Calendar c = Calendar.getInstance();
            if(job.getLastRunTime() != null) {
                c.setTime(job.getLastRunTime());
            } else {
                c.setTime(job.getStartTime());
            }
            c.add(Calendar.SECOND, job.getFrequency()); // Adding 5 secs
            System.out.println(c.getTime());
            System.out.println(new Date());
            System.out.println(c.getTime().compareTo(new Date()));
            if(c.getTime().compareTo(new Date()) < 0) {
                new Thread(() -> {
                    job.run();
                    // Queue to the Agent
                    job.setLastRunTime(new Date());
                }).start();
            }
        }
    }
}
