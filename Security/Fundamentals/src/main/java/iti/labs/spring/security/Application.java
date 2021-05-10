package iti.labs.spring.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Application {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("beans.xml");

        Scanner scanner = new Scanner(System.in);
        System.out.println("User Name : ");
        String userName = scanner.nextLine();
        System.out.println("Password : ");
        String password = scanner.nextLine();

        scanner.close();

        System.out.println(
                "Encoding of Password : " + new BCryptPasswordEncoder().encode("psw123") + "\n");

                // List<String> userList = new ArrayList<>(List.of("Yahya", "Khalil", "Allam"));
                // System.out.println(userList);
                // userList.remove("Yahya");
                // System.out.println(userList);




        try {
            Authentication authenticationToken =
                    new UsernamePasswordAuthenticationToken(userName, password);
            AuthenticationManager authenticationManager =
                    applicationContext.getBean(AuthenticationManager.class);
            Authentication authenticatedToken =
                    authenticationManager.authenticate(authenticationToken);

            SecurityContext securityContext = new SecurityContextImpl();
            securityContext.setAuthentication(authenticatedToken);
            SecurityContextHolder.setContext(securityContext);

            HelloService helloService =
                    applicationContext.getBean("helloService", HelloService.class);
            helloService.userRoleAnnotaion("Hello user");
            helloService.adminPostAuthorized();
            helloService.printAllUsers();
            System.out.println("Trying the PostFilter annotation");
            System.out.println(helloService.getAllUsers());
            System.out.println("Trying pointcut and custom annotation after the filter has filterd the list");
            helloService.printAllUsers();
            helloService.addUser("Abdelhalim");
            System.out.println("After adding new user");
            helloService.printAllUsers();
            // System.out.println(helloService.onlyManagerCanAccess("Hello, JETS - User"));
            

        } catch (BadCredentialsException e) {
            System.out.println("Not Authenticated");
        } catch (AccessDeniedException e) {
            System.out.println("Not Authorized");
        } finally {
            applicationContext.close();
        }


    }

}
