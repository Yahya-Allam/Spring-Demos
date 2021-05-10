package iti.labs.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   
    @Bean
    // if @Bean is forgotten:
    // java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }

    // @Autowired
	// public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // OR
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        PasswordEncoder encoder = passwordEncoder();
        auth.inMemoryAuthentication().withUser("Yahya")
            .password(encoder.encode("psw123"))
            .roles("USER")
            
            .and().withUser("Allam")
            .password(encoder.encode("psw123"))
            .roles("USER", "ADMIN");


    }

   
    @Override
     protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
        // "/user/*" works with "/user/profile" and "/user/" but do not with "/user"
        // "/user/**" works with all cases     
        .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/**").permitAll()
                .and().formLogin()
                .loginPage("/custom-login") // default is /login with an HTTP get
                .loginProcessingUrl("/submitlogin") // default is /login
                .usernameParameter("username") // default is username
                .passwordParameter("password") // default is password
                
                .failureUrl("/custom-login?error") // default is /login?error
                .permitAll() //with and HTTP post
                                                                     
               
                .and()
                .rememberMe()
                .key("key")
                .rememberMeParameter("remember-me")
                .tokenValiditySeconds(2149000)
                
                .and()
                // sample logout customization
                .logout().
                deleteCookies("JSESSIONID").
                invalidateHttpSession(false)
                .logoutUrl("/logout")
                .logoutSuccessUrl("/custom-login?logout")

                
                                                                                                                  
                .and().exceptionHandling().accessDeniedPage("/error")

                .and().sessionManagement()
                .maximumSessions(1)
                // .expiredUrl("/custom-login?logout")
                .maxSessionsPreventsLogin(false);
     }

}
