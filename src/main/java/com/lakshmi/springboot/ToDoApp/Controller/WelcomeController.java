package com.lakshmi.springboot.ToDoApp.Controller;


//import com.lakshmi.springboot.ToDoApp.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequiredArgsConstructor
@SessionAttributes("name")
public class WelcomeController
{
    private Logger logger = LoggerFactory.getLogger((getClass()));

    //@RequiredArgsConstructor from lombok auto generates boiler plate code
    //for single argument constructor
    //private final AuthenticationService authenticationService;

    /*
    //Call this method when the request is initiated when a user access the root of the application.
    //This method will return the welcome page at the first instantiation.
    @RequestMapping(value="/", method= RequestMethod.GET)
    public String goToWelcomePage(ModelMap modelMap)
    {
        logger.debug ("Into goToWelcomePage method");
        modelMap.put("name",getLoggedInUserName());
        return "Welcome";
    }

    private String getLoggedInUserName()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUserName = authentication.getName();
        return loggedInUserName;

    }

     */

 /*

    //Call this method when the request is initiated after entering the username and password
    // from login-jsp and the method is POST
    @RequestMapping(value="/login-jsp", method= RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String userName, @RequestParam String password, ModelMap modelMap)
    {
        logger.debug("Into goToWelcome controller method");
        boolean authenticated = authenticationService.authenticateUser(userName,password);

        //If the login is successful, the page navigates to Welcome.jsp
        if (authenticated) {
            logger.debug("Authentication successful");
            modelMap.put("name", userName);
            return "Welcome";
        }
        else {
            logger.debug("Authentication not successful");
            return "Login";
        }
   */
}
