package aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (07.05.18)
 */
@Aspect
public class SceneCounterAspect {
    private Map<Integer, Integer> scene2Count = new HashMap<Integer, Integer>();

    @Pointcut("execution(** aop.Performance.perform(int)) && args(sceneNumber)")
    public void scenePerformed(int sceneNumber) {}

    @Before("scenePerformed(sceneNumber)")
    public void countScene(int sceneNumber) {
        Integer count = scene2Count.get(sceneNumber);
        scene2Count.put(sceneNumber, count != null ? count + 1 : 1);
    }

    public int get(int sceneNumber) {
        return Optional.ofNullable(scene2Count.get(sceneNumber)).orElse(0);
    }
}
