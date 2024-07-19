
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas.asia.noteapp;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alf
 */
public class NoteAppMenu {
    private NoteService noteService;
    private Scanner scanner;

    public NoteAppMenu(String databasePath) {
        noteService = new NoteService(new DatabaseStorage(databasePath));
        scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            switch (choice) {
                case 1:
                    addNote();
                    break;
                case 2:
                    showNotes();
                    break;
                case 3:
                    deleteNote();
                    break;
                case 4:
                    System.out.println("Sistem Selesai. Terimakasih!");
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid. Silahkan masukkan opsi (1-4).");
            }
        } while (choice != 4);
    }

    private void printMenu() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("Note App Menu: Oleh (Adhi Rasa Permana Jayaningrat) NIM (23201122).");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("1. Tambahkan Catatan");
        System.out.println("2. Tampilkan Catatan");
        System.out.println("3. Hapus Catatan");
        System.out.println("4. Keluar");
        System.out.print("Pilih opsi (1-4): ");
    }

    private void addNote() {
        System.out.println(" ");
        System.out.print("Masukkan Catatan: ");
        String note = scanner.nextLine();
        noteService.createNote(note);
        System.out.println("Catatan disimpan: " + note);
    }

    private void showNotes() {
        List<String> notes = noteService.readNotes();
        System.out.println(" ");
        System.out.println("Catatan tersimpan:");
        if (notes.isEmpty()) {
            System.out.println("Belum ada data di Catatan.");
        } else {
            for (int i = 0; i < notes.size(); i++) {
                System.out.println((i + 1) + ". " + notes.get(i));
            }
        }
    }

    private void deleteNote() {
    showNotes();
    List<String> notes = noteService.readNotes();
    if (!notes.isEmpty()) {
        System.out.println(" ");
        System.out.print("Masukkan nomor catatan yang akan dihapus: ");
        int noteIndex = scanner.nextInt() - 1;
        scanner.nextLine();  // Consume newline

        if (noteIndex >= 0 && noteIndex < notes.size()) {
            System.out.println("Menghapus catatan: " + notes.get(noteIndex));
            noteService.deleteNoteByIndex(noteIndex);
            System.out.println("Catatan berhasil dihapus.");
        } else {
            System.out.println("Nomor catatan tidak valid.");
        }
    }
}

    public static void main(String[] args) {
        NoteAppMenu app = new NoteAppMenu("path_to_your_database");
        app.start();
    }
}
