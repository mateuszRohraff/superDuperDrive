package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {
    @Insert("INSERT INTO NOTES (notetitle, notedescription, userid) VALUES(#{title}, #{message}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    int insertNote(Note note);

    @Select("SELECT * FROM NOTES WHERE userid = #{userid}")
    List<Note> getNotes(int userid);

    @Delete("DELETE FROM NOTES WHERE noteId =#{noteId}")
    int deleteNote(int noteId);

    @Update("UPDATE NOTES SET notetitle=#{title}, notedescription =#{message} WHERE noteid =#{noteId}")
    void updateNote(Note note);
}
