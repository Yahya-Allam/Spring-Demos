package iti.labs.spring.security.custom;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.security.access.annotation.Secured;

@Retention(RetentionPolicy.RUNTIME)
@Secured({"ROLE_ADMIN"})
public @interface AdminPermission {

    
}
