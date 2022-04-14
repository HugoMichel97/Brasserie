import { Component, OnInit } from '@angular/core';
import { Biere } from 'src/app/model/biere';
import { Note } from 'src/app/model/note';
import { NoteService } from 'src/app/services/note.service';

@Component({
  selector: 'app-note-client',
  templateUrl: './note-client.component.html',
  styleUrls: ['./note-client.component.css'],
})
export class NoteClientComponent implements OnInit {
  notes: Note[] = [];
  constructor(private noteService: NoteService) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.noteService
      .getByClient(Number(localStorage.getItem('id')))
      .subscribe((result) => {
        this.notes = [];
        for (let n of result) {
          this.notes.push(
            new Note(n.id_note, n.client, n.biere, n.note, n.commentaire)
          );
        }
      });
  }

  getBiere(note: Note): Biere | undefined {
    return note.biere;
  }
}
