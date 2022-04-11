import { Note } from './../../../model/note';
import { NoteService } from './../../../services/note.service';
import { Component, OnInit } from '@angular/core';
import { runInThisContext } from 'vm';

@Component({
  selector: 'app-note',
  templateUrl: './note.component.html',
  styleUrls: ['./note.component.css'],
})
export class NoteComponent implements OnInit {
  notes: Note[] = [];
  constructor(private noteService: NoteService) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.noteService.getAll().subscribe((result) => {
      this.notes = [];
      for (let n of result) {
        this.notes.push(new Note(n.id_note, n.biere, n.note, n.commentaire));
      }
    });
  }

  delete(id: number) {
    this.noteService.delete(id).subscribe((done) => {
      this.list();
    });
  }
}
