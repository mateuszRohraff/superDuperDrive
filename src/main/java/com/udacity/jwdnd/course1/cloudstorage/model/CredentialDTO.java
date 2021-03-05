package com.udacity.jwdnd.course1.cloudstorage.model;

public class CredentialDTO {

    private Integer credentialId;
    private String url;
    private String username;
    private String key;
    private String password;
    private Integer userId;
    private String decryptedPassword;

    public CredentialDTO() {
    }

    public void setCredentialId(Integer credentialId) {
        this.credentialId = credentialId;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setDecryptedPassword(String decryptedPassword) {
        this.decryptedPassword = decryptedPassword;
    }
}
