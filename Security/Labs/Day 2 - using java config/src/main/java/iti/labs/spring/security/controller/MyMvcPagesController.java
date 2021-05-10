package iti.labs.spring.security.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyMvcPagesController {

    @GetMapping("/")
    public String getHomePage(){
        return "HomePage";
    }

    @GetMapping("/products")
    public String getProductPage(){
        return "ProductPage";
    }

    @GetMapping("/error")
    public String getErrorPage(){
        return "ErrorPage";
    }

    @GetMapping("/signup")
    public String getSignupPage(){
        return "SignupPage";
    }

    @GetMapping("/user/profile")
    public String getProfilePage(){
        return "ProfilePage";
    }

    @GetMapping("/admin/dashboard")
    public String getDashboard(){
        return "DashboardPage";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "LoginPage";
    }

    @GetMapping("/logout")
    public String getLogout(){
        return "LogoutPage";
    }



    @GetMapping(value="/custom-login")
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
    @RequestParam(value = "logout", required = false) String logout,
     HttpServletRequest request) {
         ModelAndView modelAndView = new ModelAndView();
         if(error != null){
             modelAndView.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
         }

         if(logout != null){
            modelAndView.addObject("msg", "You have been loggedout succesfully.");
        }

        modelAndView.setViewName("LoginPage");

        return modelAndView;

    }

    private String getErrorMessage(HttpServletRequest request, String key) {

        Exception  exception = (Exception) request.getSession().getAttribute(key);
        String error;

        if(exception instanceof BadCredentialsException){
            error = "Invalid username and password!";
        }else if(exception instanceof LockedException){
            error = exception.getMessage();
        }else{
            error = "Invalid username and password!";
        }  
        return error;
    }
    
    

    
}
