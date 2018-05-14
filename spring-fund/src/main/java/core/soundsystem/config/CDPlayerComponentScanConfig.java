package core.soundsystem.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import core.soundsystem.CD;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (10.04.18)
 */

@Configuration
//@ComponentScan(basePackages = {"core.soundsystem"}) // - specify packages where Spring has to scan Components
@ComponentScan(basePackageClasses = {CD.class}) // - specify scan packages via Classes located in these packages
public class CDPlayerComponentScanConfig {
}
