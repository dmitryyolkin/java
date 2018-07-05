package web.spittr.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * !!!NOTE!!! This class is must be specified to register DelegatingFilterProxy before all other filters.
 * If we don't create it then all Security rules specified in SecurityConfig.configure(HttpSecurity http) won't
 * be invoked.
 *
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (05.07.18)
 */
public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer {
    // к данному классу не надо добавлять аннотации
    // он находится в класспасе, поэтому система при ресолве зависимостей автоматически создает
    // инстанс этого класса, а после старта приложения вызывается его метод onStartup(),
    // в котором происходит необходимая инициализация и регистрация
}
