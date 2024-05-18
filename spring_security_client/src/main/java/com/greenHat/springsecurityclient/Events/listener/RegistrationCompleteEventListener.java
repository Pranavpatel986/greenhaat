package com.greenHat.springsecurityclient.Events.listener;

import com.greenHat.springsecurityclient.Events.RegistrationCompleteEvent;
import com.greenHat.springsecurityclient.entities.User;
import com.greenHat.springsecurityclient.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // create the Verification Token for User with link
        User user =event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);

        //Send Mail to user
        String url= event.getApplicationUrl() + "verifyRegistration?token="+token;

        //send verification email
        log.info("Click te link to verify your account: {}",url);
    }
}
