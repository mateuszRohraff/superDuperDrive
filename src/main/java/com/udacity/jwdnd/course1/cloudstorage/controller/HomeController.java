package com.udacity.jwdnd.course1.cloudstorage.controller;


import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.*;
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
    private FileService fileService;
    private UserService userService;

    public HomeController(NoteService noteService, CredentialService credentialService, EncryptionService encryptionService, FileService fileService, UserService userService) {
        this.noteService = noteService;
        this.credentialService = credentialService;
        this.encryptionService = encryptionService;
        this.fileService = fileService;
        this.userService = userService;
    }

    @GetMapping
    public String homeView(Model model, Authentication authentication){
        User user = userService.getUser(authentication.getName());
        model.addAttribute("notes", this.noteService.getNotes(authentication.getName()));
        model.addAttribute("credentials", this.credentialService.getCredentials(authentication.getName()));
        model.addAttribute("encryption", encryptionService);
        model.addAttribute("files", fileService.getAllFilesByUserId(user.getUserId()));
        return "home";
    }
}
