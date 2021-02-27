package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private NoteMapper noteMapper;
    private UserService userService;

    public NoteService(NoteMapper noteMapper, UserService userService) {
        this.noteMapper = noteMapper;
        this.userService = userService;
    }

    public List<Note> getNotes(String username) {
        return noteMapper.getNotes(userService.getUser(username).getUserId());
    }

    public void addNote(Note note, String username) {
        note.setUserId(userService.getUser(username).getUserId());
        noteMapper.insertNote(note);
    }

    public int deleteNote(Note note) {
        return noteMapper.deleteNote(note.getNoteId());
    }

    public void updateNote(Note note, String username) {
        note.setUserId(userService.getUser(username).getUserId());
        noteMapper.updateNote(note);
    }
}
