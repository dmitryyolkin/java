package com.yolkin.bookservice.ejb.timer;

import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Stateless;

/**
 * In this example a timer is created automatically by container.
 * And every method annotaed with @Schedule is invoked by container in appropriate time
 *
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (04.10.17)
 */
@Stateless
public class AutoTimerEJBExample {

    @Schedule(dayOfMonth = "1", hour = "5", minute = "30")
    public void everyMonth() {
        System.out.println("AutoTimerEJBExample.everyMonth");
    }

    @Schedules({
            @Schedule(hour = "2"),
            @Schedule(second = "10")
    })
    public void twoSchedules() {
        System.out.println("AutoTimerEJBExample.twoSchedules");
    }

    @Schedule(second = "1", persistent = false)
    public void notPersistent() {
        System.out.println("AutoTimerEJBExample.notPersistent");
    }
}
