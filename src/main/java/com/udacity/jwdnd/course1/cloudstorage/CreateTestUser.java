package com.udacity.jwdnd.course1.cloudstorage;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class CreateTestUser {

    private UserService userService;

    public CreateTestUser(UserService userService) {
        this.userService = userService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createTestUser() {
        userService.createUser(new User(null, "kupa", null, "kupa", "mateusz", "mateusz"));
    }
}
