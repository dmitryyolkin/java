package web.spittr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (27.06.18)
 */

@Configuration
@EnableWebSecurity
public class InMemorySecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //create two users in Memory store
        auth
                .inMemoryAuthentication()
                .withUser("user").password("psw").roles("USER").and()
                .withUser("admin").password("admin").roles("USER", "ADMIN");
    }
}
