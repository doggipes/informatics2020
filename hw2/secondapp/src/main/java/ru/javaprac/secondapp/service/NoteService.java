package ru.javaprac.secondapp.service;

import org.springframework.data.domain.Page;
import ru.javaprac.secondapp.dto.noteDto;
import ru.javaprac.secondapp.entity.Note;

import java.util.List;

public interface NoteService {
    void addNote(noteDto noteDto);

    Page<Note> pagination(int page, String search);

    Page<Note> pagination(int page);
}
