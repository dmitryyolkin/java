package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by dmitry on 27.04.18.
 */
@Aspect
public class AudienceWithAround {

    @Pointcut("execution(** aop.Performance.perform(..))")
    public void performance() {}

    @Around("performance()")
    public void interceptPerformance(ProceedingJoinPoint point) {
        try {
            System.out.println("[AudienceWithAround] Please silence your phones");
            System.out.println("[AudienceWithAround] Please take your seats");

            // procees basic logic of wrapped method
            point.proceed();
            System.out.println("[AudienceWithAround] Great concert");
        } catch (Throwable t) {
            System.out.println("[AudienceWithAround] Please give me refund");
        }
    }

}
