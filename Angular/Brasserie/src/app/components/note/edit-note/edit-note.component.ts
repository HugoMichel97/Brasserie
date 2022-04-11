import { Note } from './../../../model/note';
import { NoteService } from './../../../services/note.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-edit-note',
  templateUrl: './edit-note.component.html',
  styleUrls: ['./edit-note.component.css'],
})
export class EditNoteComponent implements OnInit {
  note: Note = new Note();
  constructor(
    private aR: ActivatedRoute,
    private noteService: NoteService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id_note']) {
        this.note = new Note();
      } else {
        this.noteService.getById(params['id_note']).subscribe((n) => {
          this.note = new Note(n.id_note, n.biere, n.note, n.commentaire);
        });
      }
    });
  }

  save() {
    if (this.note.id_note) {
      this.noteService.update(this.note).subscribe(() => {
        this.router.navigateByUrl('/note');
      });
    } else {
      this.noteService.create(this.note).subscribe(() => {
        this.router.navigateByUrl('/note');
      });
    }
  }
}
