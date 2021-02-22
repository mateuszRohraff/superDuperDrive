package com.udacity.jwdnd.course1.cloudstorage.model;

public class Note {

    private Integer noteId;
    private String title;
    private String message;
    private Integer userId;

    public Note(Integer noteId, String title, String message, Integer userId) {
        this.noteId = noteId;
        this.title = title;
        this.message = message;
        this.userId = userId;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
