package ru.javaprac.secondapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.javaprac.secondapp.dto.noteDto;
import ru.javaprac.secondapp.entity.Note;
import ru.javaprac.secondapp.service.NoteService;

@Controller
public class startController
{
    private NoteService noteService;

    @Autowired
    public startController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/")
    public String hello(){
        return "start";
    }

    @PostMapping("/")
    public String addNumber(@ModelAttribute noteDto noteDto){
        noteService.addNote(noteDto);

        return "start";
    }

    @GetMapping("/notes")
    public String viewNotes(@RequestParam(defaultValue = "", required = false) String search, @RequestParam(defaultValue = "1", required = false) int page, Model model){
        if(true) {
            if(page < 1)
                return "redirect:/notes?search=" + search + "&page=1";
            Page<Note> notes = search.equals("") ?  noteService.pagination(page - 1) : noteService.pagination(page - 1, search);
            if(page > notes.getTotalPages())
                return "redirect:/notes?search=" + search + "&page=1";
            model.addAttribute("notes", notes.toList());
            model.addAttribute("search", search);
            model.addAttribute("pages", notes.getTotalPages());
        }
        return "notes";
    }

    @PostMapping("/notes")
    public String searchNotes(){
        return "notes";
    }
}
