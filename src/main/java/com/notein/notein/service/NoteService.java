package com.notein.notein.service;

import com.notein.notein.model.Note;
import com.notein.notein.repository.NoteRepository;
import com.notein.notein.service.exceptions.NoteNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepository repo;

    public List<Note> getNote(){
        return  repo.findAll();
    }
    public Note getNote(String id){
        return repo.findById(id).orElseThrow(()->new NoteNotFound(id));
    }
    public Note postNote(Note note){
        return repo.save(note);
    }
    public void deleteNote(String id){
        repo.deleteById(id);
    }
}
