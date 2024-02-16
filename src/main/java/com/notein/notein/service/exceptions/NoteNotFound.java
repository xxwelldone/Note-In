package com.notein.notein.service.exceptions;

public class NoteNotFound extends RuntimeException {
 public NoteNotFound(Object id){
     super("Not Found id: "+ id);
 }
}
