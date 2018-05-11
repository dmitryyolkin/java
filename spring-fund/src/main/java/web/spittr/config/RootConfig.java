package web.spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (11.05.18)
 */
@Configuration
@ComponentScan(
        basePackages = {"web.spittr"},
        excludeFilters = {
                //don't scan WebConfig
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        }
)
public class RootConfig {
}
