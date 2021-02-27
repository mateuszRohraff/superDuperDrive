package com.udacity.jwdnd.course1.cloudstorage;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class CreateTestData {

    private UserService userService;
    private NoteMapper noteMapper;
    private CredentialMapper credentialMapper;

    public CreateTestData(UserService userService, NoteMapper noteMapper, CredentialMapper credentialMapper) {
        this.userService = userService;
        this.noteMapper = noteMapper;
        this.credentialMapper = credentialMapper;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createTestUser() {
        userService.createUser(new User(null, "user", null, "user", "mateusz", "mateusz"));
        noteMapper.insertNote(new Note(null, "Test title", "Test Message", userService.getUser("user").getUserId()));
        credentialMapper.insertCredentials(new Credential(null, "wwww.testURL.pl", "TestUsername", "5", "testPassword", userService.getUser("user").getUserId()));
    }
}
