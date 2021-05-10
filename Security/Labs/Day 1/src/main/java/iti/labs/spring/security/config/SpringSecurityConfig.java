package iti.labs.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@Configuration
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class SpringSecurityConfig {

    public SpringSecurityConfig(){
        System.out.println("Default constructor of Spring Config Called");
    }
    
}
