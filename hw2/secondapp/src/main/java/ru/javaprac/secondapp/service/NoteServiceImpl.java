package ru.javaprac.secondapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import ru.javaprac.secondapp.dto.noteDto;
import ru.javaprac.secondapp.entity.Note;
import ru.javaprac.secondapp.repository.NoteRepository;

@Component
public class NoteServiceImpl implements NoteService{
    private NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

    @Override
    public void addNote(noteDto noteDto) {
        Note note = noteRepository.save(Note.builder()
                                        .name(noteDto.getName())
                                        .text(noteDto.getText())
                                        .build());
        noteDto.setId(note.getId());
    }

    @Override
    public Page<Note> pagination(int page, String search) {
        Pageable pageable = PageRequest.of(page, 5);
        return noteRepository.findAllNotesByName(search, pageable);
    }


    @Override
    public Page<Note> pagination(int page) {
        Pageable pageable = PageRequest.of(page, 5);
        return noteRepository.findAll(pageable);
    }
}
