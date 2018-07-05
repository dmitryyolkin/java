package web.spittr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;

import javax.sql.DataSource;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (27.06.18)
 */

@Configuration
@EnableWebSecurity
public class SecurityConfigInMemory extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //create two users in Memory store
        auth
                .inMemoryAuthentication()
                .withUser("user").password("psw").roles("USER").and()
                .withUser("admin").password("admin").roles("USER", "ADMIN");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                    .loginPage("/login")
                .and()
                    .logout()
                    .   logoutSuccessUrl("/")
                .and()
                    .rememberMe()
                    .tokenRepository(new InMemoryTokenRepositoryImpl())
                    .tokenValiditySeconds(86400) // 24 hours
                    .key("spittrKey")
                .and()
                    .authorizeRequests()
                    .antMatchers("/spittles/**").authenticated() //all /spittles/ request require authentication
                    .anyRequest().permitAll(); // all requests except requests above are permitted
    }
}
