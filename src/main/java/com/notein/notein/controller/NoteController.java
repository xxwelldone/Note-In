package com.notein.notein.controller;

import com.notein.notein.model.Note;
import com.notein.notein.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "mynotes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping
    public ResponseEntity<List<Note>> findAll(){
        return ResponseEntity.ok().body(noteService.getNote());
    }
    @PostMapping
    public ResponseEntity<Note>post(@RequestBody Note note){
       Note noteSaved  = noteService.postNote(note);
       URI uri = ServletUriComponentsBuilder.
               fromCurrentRequest().path("/{id}").
               buildAndExpand(noteSaved.getId()).toUri();
       return ResponseEntity.created(uri).body(noteSaved);
    }
}
