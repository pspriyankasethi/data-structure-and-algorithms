package com.sethip.test.applications;
import com.sethip.main.applications.JobScheduler;
import com.sethip.main.models.Job;
import org.junit.jupiter.api.Test;

import java.util.Date;

class JobSchedulerTest {

    @Test
    public void poll() {
        Job job1 = new Job("J1", new Date(), 5, null),
                job2 = new Job("J2", new Date(), 10, null),
                job3 = new Job("J3", new Date(), 15, null),
                job4 = new Job("J4", new Date(), 20, null),
                job5 = new Job("J5", new Date(), 2, null);
        JobScheduler jobScheduler = new JobScheduler();
        jobScheduler.add(job1);
        jobScheduler.add(job2);
        jobScheduler.add(job3);
        jobScheduler.add(job4);
        jobScheduler.add(job5);

        while(true) {
            jobScheduler.poll();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}