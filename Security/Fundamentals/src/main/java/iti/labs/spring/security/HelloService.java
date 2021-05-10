package iti.labs.spring.security;

import java.util.List;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import iti.labs.spring.security.custom.AdminPermission;

public interface HelloService {

    @Secured(value = {"ROLE_USER"})
    String onlyUserCanAccess(String message);


    @Secured(value = {"ROLE_MANAGER"})
    String onlyManagerCanAccess(String message);


    @Secured(value = {"ROLE_ADMIN"})
    String onlyAdminCanAccess(String message);

    @RolesAllowed("ROLE_USER")
    void userRoleAnnotaion(String message);

    @PostAuthorize("hasRole('ADMIN')")
    void adminPostAuthorized();


    @PreAuthorize("permitAll()")
    @PostFilter("filterObject == authentication.name")
    List<String> getAllUsers();


    // @PermitAll
    @AdminPermission
    void printAllUsers();

    // @AdminPermission
    void addUser(String name);


}
