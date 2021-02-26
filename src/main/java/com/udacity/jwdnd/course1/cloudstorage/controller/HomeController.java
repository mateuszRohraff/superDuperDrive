package com.udacity.jwdnd.course1.cloudstorage.controller;


import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
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

    public HomeController(NoteService noteService, CredentialService credentialService) {
        this.noteService = noteService;
        this.credentialService = credentialService;
    }

    @GetMapping
    public String homeView(Model model, Authentication authentication){
        model.addAttribute("notes", this.noteService.getNotes(authentication.getName()));
        model.addAttribute("credentials", this.credentialService.getCredentials(authentication.getName()));
        return "home";
    }
}
