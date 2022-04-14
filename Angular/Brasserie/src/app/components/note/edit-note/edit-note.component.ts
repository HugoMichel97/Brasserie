import { ClientService } from './../../../services/client.service';
import { ProduitService } from './../../../services/produit.service';
import { Client } from './../../../model/client';
import { Biere } from './../../../model/biere';
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
  bieres: Biere[] = [];
  clients: Client[] = [];
  constructor(
    private aR: ActivatedRoute,
    private noteService: NoteService,
    private produitService: ProduitService,
    private clientService: ClientService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.clientService.getAll().subscribe((result) => {
      this.clients = result;
    });

    this.produitService.getAllBeers().subscribe((result) => {
      this.bieres = result;
    });

    this.aR.params.subscribe((params) => {
      if (params['id_note'] === 'undefined') {
        this.note = new Note();
      } else {
        console.log(this.noteService.getById(params['id_note']));
        this.noteService.getById(params['id_note']).subscribe((n) => {
          this.note = new Note(
            n.id_note,
            n.client
              ? new Client(n.client?.id, n.client?.prenom, n.client?.nom)
              : undefined,
            n.biere ? new Biere(n.biere?.id, n.biere?.nom) : undefined,
            n.note,
            n.commentaire
          );
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
