package core.soundsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import core.soundsystem.CD;
import core.soundsystem.CDPlayer;
import core.soundsystem.RockCD;

/**
 * This core.soundsystem.config can be used when we have a few implementations for the same interface
 * We use @Bean instead of @ComponentScan
 *
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (12.04.18)
 */
@Configuration
public class CDPlayerWithBeanConfig {

    @Bean
    public CD cd() {
        return new RockCD();
    }

    @Bean
    public CDPlayer cdPlayer(CD cd) {
        return new CDPlayer(cd);
    }
}
