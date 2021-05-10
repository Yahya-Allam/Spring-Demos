package iti.labs.spring.security.impl;

import java.util.ArrayList;
import java.util.List;
import iti.labs.spring.security.HelloService;

public class HelloServiceImpl implements HelloService {

    private List<String> userList = new ArrayList<>(List.of("Yahya", "Khalil", "Allam"));

    @Override
    public String onlyUserCanAccess(String message) {
        System.out.println("Hello " + message);
        System.out.println();
        return "You have been granted user permission";
    }

    @Override
    public String onlyManagerCanAccess(String message) {
        System.out.println("Hello " + message);
        return "You have been granted manager permission";
    }

    @Override
    public String onlyAdminCanAccess(String message) {
        System.out.println("Hello " + message);
        return "You have been granted admin permission";
    }

    @Override
    public void userRoleAnnotaion(String message) {
        System.out.println("User Role @RolesAllowed annotation");

    }

    @Override
    public void adminPostAuthorized() {
        System.out.println("Use adminPostAuthorized()");

    }


    public List<String> getAllUsers() {       
        return userList;
    }

    @Override
    public void printAllUsers() {
        System.out.println(userList);
        
    }

    @Override
    public void addUser(String name) {
       userList.add(name);
    }

}
