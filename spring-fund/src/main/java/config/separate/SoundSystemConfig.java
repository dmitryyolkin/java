package config.separate;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (13.04.18)
 */
@Configuration
@Import(CDPlayerSeparateConfig.class)
@ImportResource("classpath:cdplayer_config.xml")
public class SoundSystemConfig {
}
