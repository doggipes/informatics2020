package ru.javaprac.firstapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.javaprac.firstapp.dto.noteDto;

import java.util.ArrayList;
import java.util.List;

@Controller
public class startController {

    private List<noteDto> noteList = new ArrayList<>();
    private List<noteDto> searchList = new ArrayList<>();
    private String optimizedSearch = " ";

    @GetMapping("/")
    public String hello(){
        return "start";
    }

    @PostMapping("/")
    public String addNumber(@ModelAttribute noteDto noteDto){
        noteList.add(noteDto);
        return "start";
    }

    @GetMapping("/notes")
    public String viewNotes(@RequestParam(defaultValue = "", required = false) String search, @RequestParam(defaultValue = "1", required = false) int page, Model model){
        if(!noteList.isEmpty()) {
            model.addAttribute("search", search);

            if(search.equals("")){
                searchList = noteList;
                optimizedSearch = " ";
            }
            else
            if(!optimizedSearch.equals(search)) {
                optimizedSearch = search;
                searchList = new ArrayList<>();

                for (noteDto check : noteList) {
                    if (check.getName().equals(search))
                        searchList.add(check);
                }
            }


            int pages = (int) Math.ceil((double) searchList.size()/5);
            if(pages == page) {
                model.addAttribute("pages", pages);
                model.addAttribute("notes", searchList.subList(page * 5 - 5, searchList.size()));
            }
            else
            if(pages > page && page > 0){
                model.addAttribute("pages", pages);
                model.addAttribute("notes", searchList.subList(page * 5 - 5, page * 5));
            }
            else{
                model.addAttribute("pages", 1);
                model.addAttribute("notes", searchList.subList(0, 5));
            }
        }
        return "notes";
    }

    @PostMapping("/notes")
    public String searchNotes(){
        return "notes";
    }
}
