package core.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (19.04.18)
 */
@Configuration
@PropertySource("classpath:app.properties")
public class PropConfig {
    @Autowired
    private Environment environment;


}
