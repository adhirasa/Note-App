
package uas.asia.noteapp;

import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class NoteService {
    private DataStorage storage;
    private List<String> notes;

    public NoteService(DataStorage storage) {
        this.storage = storage;
        this.notes = readNotes();
    }

    public void createNote(String note) {
        storage.writeData(note);
        notes.add(note);
    }

    public List<String> readNotes() {
        return storage.readData();
    }

    public void deleteNoteByIndex(int index) {
    if (index >= 0 && index < notes.size()) {
        String note = notes.get(index);
        notes.remove(index);
        storage.deleteData(note);
    } else {
        throw new IndexOutOfBoundsException("Invalid index for deletion");
    }
}

    public int getNoteCount() {
        return notes.size();
    }

    public String getNoteByIndex(int index) {
        return notes.get(index);
    }
}
