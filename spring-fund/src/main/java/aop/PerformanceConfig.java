package aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (25.04.18)
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class PerformanceConfig {

    @Bean
    public Audience audience() {
        return new Audience();
    }
}
