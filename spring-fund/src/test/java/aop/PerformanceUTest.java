package aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (25.04.18)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PerformanceConfig.class)
public class PerformanceUTest {

    @Autowired
    private Performance performance;

    @Test
    public void testPerformance() {
        try{
            performance.perform();
        } catch (Exception e) {
            System.out.println("Performance throws an exception");
        }

    }

}
