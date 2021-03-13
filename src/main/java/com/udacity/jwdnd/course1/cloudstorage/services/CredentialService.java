package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CredentialService {

    private CredentialMapper credentialMapper;
    private UserService userService;
    private EncryptionService encryptionService;

    public CredentialService(CredentialMapper credentialMapper, UserService userService, EncryptionService encryptionService) {
        this.credentialMapper = credentialMapper;
        this.userService = userService;
        this.encryptionService = encryptionService;
    }

    public void addCredential(Credential credential, String username) {
        String key = encryptionService.generateKey();
        String encryptedPassword = encryptionService.encryptValue(credential.getPassword(), key);
        credential.setUserId(userService.getUser(username).getUserId());
        credential.setPassword(encryptedPassword);
        credential.setKey(key);
        credentialMapper.insertCredentials(credential);
    }

    public List<Credential> getCredentials(String username) {
        return credentialMapper.getCredentials(userService.getUser(username).getUserId());
    }

    public void deleteCredential(Credential credential) {
        credentialMapper.deleteCredential(credential.getCredentialId());
    }

    public void updateCredential(Credential credential) {
        String encryptedPassword = encryptionService.encryptValue(credential.getPassword(), credential.getKey());
        credential.setPassword(encryptedPassword);
        credentialMapper.updateCredentials(credential);
    }

}
