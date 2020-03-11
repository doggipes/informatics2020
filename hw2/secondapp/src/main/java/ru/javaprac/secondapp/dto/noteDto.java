package ru.javaprac.secondapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.javaprac.secondapp.entity.Note;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class noteDto {
    private Long id;
    private String name;
    private String text;

    public static noteDto from(Note note){
        return noteDto.builder()
                        .id(note.getId())
                        .name(note.getName())
                        .text(note.getText())
                        .build();
    }

    public static List<noteDto> from(List<Note> notes) {
        return notes.stream().map(noteDto::from).collect(Collectors.toList());
    }
}
