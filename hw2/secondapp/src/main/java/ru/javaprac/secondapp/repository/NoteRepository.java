package ru.javaprac.secondapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.javaprac.secondapp.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

    Page<Note> findAllNotesByName(String user,Pageable pageable);
}
