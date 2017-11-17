package com.yolkin.bookservice.ejb.timer;

import com.yolkin.bookservice.Customer;

import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;

/**
 * This is example when time is created programmatically through TimeService injection and @Timeout annotation.
 * Programmatic timers components can have only one method annotated with @Timeout
 *
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (04.10.17)
 */
@Stateless
public class ProgrammaticTimerEJBExample {
    @Resource
    private TimerService timerService;

    @PersistenceContext(unitName = "BookService_PU")
    private EntityManager entityManager;

    public void createCustomer(Customer customer) {
        entityManager.persist(customer);

        //working with dates can be incorect - it's just an example
        ScheduleExpression scheduleExpression = new ScheduleExpression()
                .dayOfMonth(LocalDateTime.now().getDayOfMonth())
                .month(LocalDateTime.now().getMonth().getValue());
        timerService.createCalendarTimer(scheduleExpression, new TimerConfig(customer, true));
    }

    @Timeout
    public void sendBithdayEmail(Timer timer) {
        Customer customer = (Customer) timer.getInfo();
        System.out.println("ProgrammaticTimerEJBExample.sendBithdayEmail" + customer);
    }
}
