package com.greenHat.springsecurityclient.controllers;

import com.greenHat.springsecurityclient.Events.RegistrationCompleteEvent;
import com.greenHat.springsecurityclient.entities.User;
import com.greenHat.springsecurityclient.models.UserModel;
import com.greenHat.springsecurityclient.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class RegistrationController {
    @Autowired
    private UserService userService;
    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("/hello")
    public String getStarted(){
        return "Hello Pranav";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request){
        User user=userService.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(
                user,
                applicationUrl(request)
        ));

        return "Success";
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://"+ request.getServerName() +
                ":"+
                request.getServerPort() +
                request.getContextPath();
    }
}
