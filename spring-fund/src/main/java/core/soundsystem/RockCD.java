package core.soundsystem;

import org.springframework.stereotype.Component;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (10.04.18)
 */
@Component
// @Profile("dev") - Profile can  be specified as annotation or in spring core.soundsystem.config
public class RockCD implements CD{
    public void play() {
        System.out.println(getClass().getSimpleName() + " plays");
    }
}
