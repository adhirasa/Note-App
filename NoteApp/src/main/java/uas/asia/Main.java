
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package uas.asia;

import uas.asia.noteapp.NoteAppMenu;

/**
 *
 * @author alf
 */
public class Main {

    public static void main(String[] args) {
        NoteAppMenu noteapp = new NoteAppMenu("notes.db");
        noteapp.start();
    }
}
