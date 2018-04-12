package soundsystem;

import org.springframework.stereotype.Component;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (10.04.18)
 */
@Component
public class RockCD implements CD{
    public void play() {
        System.out.println(getClass().getSimpleName() + " plays");
    }
}
