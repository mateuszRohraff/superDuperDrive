package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/credential")
public class CredentialController {

    private CredentialService credentialService;

    public CredentialController(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    @PostMapping()
    public String addCredentials(Credential credential, Authentication authentication) {
        credentialService.addCredential(credential, authentication.getName());
        return "redirect:/home";
    }

    @DeleteMapping()
    public String deleteCredential(@ModelAttribute Credential credential) {
        credentialService.deleteCredential(credential);
        return "redirect:/home";
    }

    @PutMapping()
    public String updateCredentials(@ModelAttribute Credential credential) {
        credentialService.updateCredential(credential);
        return "redirect:/home";
    }
}
