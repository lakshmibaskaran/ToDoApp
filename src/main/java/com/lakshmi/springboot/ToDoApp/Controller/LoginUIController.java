package com.lakshmi.springboot.ToDoApp.Controller;


import com.lakshmi.springboot.ToDoApp.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequiredArgsConstructor
@SessionAttributes("name")
public class LoginUIController
{
    private Logger logger = LoggerFactory.getLogger((getClass()));

    //@RequiredArgsConstructor from lombok auto generates boiler plate code
    //for single argument constructor
    private final AuthenticationService authenticationService;

    //Call this method when the request is initiated from login-jsp and the method is GET.
    //This method will return the login page at the first instantiation.
    @RequestMapping(value="/login-jsp", method= RequestMethod.GET)
    public String goToLoginPage()
    {
        logger.debug ("Into Login Page");
        return "Login";
    }

    //Call this method when the request is initiated after entering the username and password
    // from login-jsp and the method is POST
    @RequestMapping(value="/login-jsp", method= RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String userName, @RequestParam String password, ModelMap modelMap)
    {
        logger.debug("Into goToWelcome controller method");
        boolean authenticated = authenticationService.authenticateUser(userName,password);
        if (authenticated) {
            logger.debug("Authentication successful");
            modelMap.put("name", userName);
            return "Welcome";
        }
        else {
            logger.debug("Authentication not successful");
            return "Login";
        }
    }
}
