import { Client } from './../../../model/client';
import { ClientService } from './../../../service/client.service';
import { AchatService } from './../../../services/achat.service';
import { NoteService } from './../../../services/note.service';
import { Component, OnInit } from '@angular/core';
import { Biere } from 'src/app/model/biere';
import { Produit } from 'src/app/model/produit';
import { ProduitService } from 'src/app/services/produit.service';
import { Achat } from 'src/app/model/achat';

@Component({
  selector: 'app-biere',
  templateUrl: './biere.component.html',
  styleUrls: ['./biere.component.css'],
})
export class BiereComponent implements OnInit {
  bieres: Biere[] = [];
  moyenne: number[] = [];
  cpt: number = 0;
  somme: number = 0;
  moy: number = 0;
  client: Client = new Client();
  constructor(
    private produitService: ProduitService,
    private noteService: NoteService,
    private achatService: AchatService
  ) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.produitService.getAllBeers().subscribe((result) => {
      this.bieres = [];
      for (let b of result) {
        this.bieres.push(
          new Biere(
            b.id,
            b.nom,
            b.description,
            b.prix,
            b.stock,
            b.points,
            b.notes
          )
        );

        for (let n of b.notes) {
          this.cpt++;
          this.somme += n.note;
        }
        this.moy = this.somme / this.cpt;
      }
    });
  }

  // getMoyenne(biere: Biere): number {
  //   this.noteService.getMoyenne(biere).subscribe((result) => {
  //     this.moyenne = [];
  //     for (let i in [0, 1]) {
  //       this.moyenne[i] = result[i];
  //     }
  //   });
  //   return this.moyenne[0];
  // }

  // getNbAvis(biere: Biere): number {
  //   this.noteService.getMoyenne(biere).subscribe((result) => {
  //     this.moyenne = [];
  //     for (let i in [0, 1]) {
  //       this.moyenne[i] = result[i];
  //     }
  //   });
  //   return this.moyenne[1];
  // }

  ajoutPanier(biere: Biere) {
    this.achatService.createCatalogue(
      // ajouter le client connecté dans le constructeur
      new Achat(undefined, this.client, biere, 1)
    );
    console.log(new Achat(undefined, this.client, biere, 1));
  }

  triPrix() {
    this.bieres = this.bieres.sort((a, b) => {
      return a.prix! > b.prix! ? 1 : -1;
    });
  }

  triPrixR() {
    this.bieres = this.bieres.sort((a, b) => {
      return a.prix! < b.prix! ? 1 : -1;
    });
  }

  triAlpha() {
    this.bieres = this.bieres.sort((a, b) => {
      return a.nom!.localeCompare(b.nom!);
    });
  }

  triAlphaR() {
    this.bieres = this.bieres.sort((a, b) => {
      return b.nom!.localeCompare(a.nom!);
    });
  }

  triAvis() {}

  get tableau(): Biere[] {
    return this.bieres;
  }
}
