package com.yolkin.api;

import com.google.common.collect.Sets;
import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.Set;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (28.02.18)
 */
@ApplicationPath("rs")
public class ApplicationConfig extends Application{

    private final Set<Class<?>> services;

    public ApplicationConfig() {
        services = Collections.unmodifiableSet(Sets.<Class<?>>newHashSet(
                BookRestService.class,
                MOXyJsonProvider.class
        ));
    }

    @Override
    public Set<Class<?>> getClasses() {
        // определяем root path = rs для всех сервисов, к-е находятся в сете services
        // т.е. теперь мы будем обращаться к BookRestService как http://localhost:8080/../rs/book
        // По сути такой конфиг позволяет задать корень пути для определенного набора сервисов
        return services;
    }
}
