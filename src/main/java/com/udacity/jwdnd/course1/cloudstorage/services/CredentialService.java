package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CredentialService {

    private CredentialMapper credentialMapper;
    private UserService userService;

    public CredentialService(CredentialMapper credentialMapper, UserService userService) {
        this.credentialMapper = credentialMapper;
        this.userService = userService;
    }

    public void addCredential(Credential credential, String username) {
        Random random = new Random();
        credential.setKey(String.valueOf(random.nextInt(10)));
        credential.setUserId(userService.getUser(username).getUserId());
        credentialMapper.insertCredentials(credential);
    }

    public List<Credential> getCredentials(String username) {
        return credentialMapper.getCredentials(userService.getUser(username).getUserId());
    }
}
