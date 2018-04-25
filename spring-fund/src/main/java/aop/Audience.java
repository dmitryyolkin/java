package aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (25.04.18)
 */
@Aspect
public class Audience {

    // this is AspectJ syntax
    //      execution - method's execution stage
    //      ** - not interested in returning type
    //      aop - package name
    //      Performance.perform - interface / class + method name that should be intercepted and proxied
    //      (..) - not interested in method's arguments
    @Pointcut("execution(** aop.Performance.perform(..))")
    public void performance() {}

    @Before("performance()")
    public void silenceCellPhones(){
        System.out.println("Please silence your phones");
    }

    @Before("performance()")
    public void takeYourSeats(){
        System.out.println("Please take your seats");
    }

    @AfterReturning("performance()")
    public void applause(){
        System.out.println("Great concert");
    }

    @AfterThrowing("performance()")
    public void demandRefund(){
        System.out.println("Please give me refund");
    }

}
