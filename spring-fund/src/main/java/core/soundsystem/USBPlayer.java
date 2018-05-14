package core.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (17.04.18)
 */
@Component
public class USBPlayer extends CDPlayer{

    @Autowired
    public USBPlayer(CD cd) {
        super(cd);
    }
}
