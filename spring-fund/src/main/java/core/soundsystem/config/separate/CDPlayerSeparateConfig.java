package core.soundsystem.config.separate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import core.soundsystem.CD;
import core.soundsystem.CDPlayer;
import core.soundsystem.USBPlayer;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (13.04.18)
 */
@Configuration
public class CDPlayerSeparateConfig {
    @Bean
    public CDPlayer cdPlayer(CD cd) {
        return new CDPlayer(cd);
    }

    @Bean
    @Conditional(UsbSupportedCondition.class)
    public USBPlayer usbPlayer(CD cd) {
        return new USBPlayer(cd);
    }

}
