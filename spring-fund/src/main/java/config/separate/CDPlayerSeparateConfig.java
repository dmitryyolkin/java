package config.separate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import soundsystem.CD;
import soundsystem.CDPlayer;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (13.04.18)
 */
@Configuration
public class CDPlayerSeparateConfig {
    @Bean
    public CDPlayer cdPlayer(CD cd) {
        return new CDPlayer(cd);
    }

}
