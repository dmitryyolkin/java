package msg;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by dmitry on 24.02.16.
 * It's test home projects
 *
 * This class is needed as alternative for ResteasyBootstrap for loading Resteasy services
 * In addition see web.xml <init-param> tag
 *
 */
public class MessageApplication extends Application {
    private Set<Object> singletons = new HashSet<>();

    public MessageApplication() {
        singletons.add(new ResteasyMessageService());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
