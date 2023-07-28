package com.example.servingwebcontent.event.listener;

import com.example.servingwebcontent.event.RegistrationCompleteEvent;
import com.example.servingwebcontent.user.User;
import com.example.servingwebcontent.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
 private final UserService userService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // 1. Get the newly registered user
        User theUser = event.getUser();
        // 2. Create a verification token for the user
        String verificationToken = UUID.randomUUID().toString();
        // 3. Save the verification token
        userService.saveUserVerificationToken(theUser, verificationToken);
        // 4. build the verification url
        String url = event.getApplicationUrl()+"/register/verifyEmail?token="+verificationToken;
        // 5. Send the email
        log.info("Click the link for verification: {}", url);
    }
}
