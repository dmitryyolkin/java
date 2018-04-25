package aop;

import org.springframework.stereotype.Component;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (25.04.18)
 */
@Component
public class Concert implements Performance {
    public void perform() {
        System.out.println("Concert was started");
        if (Math.random() < 0.5) {
            throw new RuntimeException("Something went wrong.. ups");
        }
        System.out.println("Concert was finished");
    }
}
