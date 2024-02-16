package com.notein.notein.repository;

import com.notein.notein.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Note, String > {
}
