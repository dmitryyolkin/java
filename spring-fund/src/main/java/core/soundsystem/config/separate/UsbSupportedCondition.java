package core.soundsystem.config.separate;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (17.04.18)
 */
public class UsbSupportedCondition implements Condition{
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        Boolean withUsbSupport = environment.getProperty("withUsbSupport", Boolean.class);
        return withUsbSupport != null && withUsbSupport == Boolean.TRUE;
    }
}
