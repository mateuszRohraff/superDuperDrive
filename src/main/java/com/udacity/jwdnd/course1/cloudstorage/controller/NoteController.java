package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/note")
public class NoteController {

    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping()
    public String addNote(Note note, Authentication authentication) {
        noteService.addNote(note, authentication.getName());
        return "redirect:/home";
    }

    @DeleteMapping()
    public String deleteNote(@ModelAttribute Note note) {
        noteService.deleteNote(note.getNoteId());
        return "redirect:/home";
    }

    @PutMapping()
    public String updateNote(@ModelAttribute Note note, Authentication authentication) {
        System.out.println(note.getNoteId());
        noteService.updateNote(note, authentication.getName());
        return "redirect:/home";
    }
}
