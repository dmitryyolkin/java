package core.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (11.04.18)
 */
@Component
public class CDPlayer {

    private CD cd;

    @Autowired
    //@Inject instead of @Autowired we can use @Inject from <artifactId>javax.inject</artifactId>
    public CDPlayer(CD cd) {
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }
}
