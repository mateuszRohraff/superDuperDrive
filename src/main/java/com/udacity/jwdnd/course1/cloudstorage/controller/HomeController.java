package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import org.apache.ibatis.annotations.Update;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("home")
public class HomeController {

    private NoteService noteService;

    public HomeController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping()
    public String homeView(Note note, Model model, Authentication authentication){
        model.addAttribute("notes", this.noteService.getNotes(authentication.getName()));
        return "home";
    }

    @PostMapping()
    public String addNote(Note note, Authentication authentication, Model model) {
        noteService.addNote(note, authentication.getName());
        model.addAttribute("notes", noteService.getNotes(authentication.getName()));
        return "home";
    }

    @GetMapping("delete/{id}")
    public String deleteNote(@PathVariable("id") int id) {
        noteService.deleteNote(id);
        return "redirect:/home";
    }

    @PutMapping("edit")
    public String editNote(Note note, Authentication authentication) {
        noteService.updateNote(note, authentication.getName());
        return "redirect:/home";
    }

}
