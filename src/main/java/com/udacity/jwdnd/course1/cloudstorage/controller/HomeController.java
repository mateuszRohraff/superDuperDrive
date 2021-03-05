package com.udacity.jwdnd.course1.cloudstorage.controller;


import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.EncryptionService;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class HomeController {

    private NoteService noteService;
    private CredentialService credentialService;
    private EncryptionService encryptionService;

    public HomeController(NoteService noteService, CredentialService credentialService, EncryptionService encryptionService) {
        this.noteService = noteService;
        this.credentialService = credentialService;
        this.encryptionService = encryptionService;
    }

    @GetMapping
    public String homeView(Model model, Authentication authentication){
        model.addAttribute("notes", this.noteService.getNotes(authentication.getName()));
        model.addAttribute("credentials", this.credentialService.getCredentials(authentication.getName()));
        model.addAttribute("encryption", encryptionService);
        return "home";
    }
}
