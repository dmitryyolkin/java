package web.spittr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (29.06.18)
 */
// Enable if we want to have users stored in memory
//@Configuration
//@EnableWebSecurity
public class SecurityConfigJdbc extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // save users in DB
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)

                // usersByUsernameQuery is not nessesary
                // if it's not specified then default scheme is used
                //      "select username,password,enabled from users " +
                //      "where username = ?";
                .usersByUsernameQuery(
                        "select username, password, true from Spitter where username=?"
                )

                // authoritiesByUsernameQuery is not nessesary
                // if it's not specified then default scheme is used
                //      "select username,authority from authorities where username = ?"
                .authoritiesByUsernameQuery(
                        "select username, 'ROLE_USER' from Spitter where username=?"
                )
                // encode password stored in DB
                .passwordEncoder(new BCryptPasswordEncoder());

    }
}
