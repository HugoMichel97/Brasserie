import { Router } from '@angular/router';
import { AuthentificationService } from './../../../services/authentification.service';
import { AchatService } from './../../../services/achat.service';
import { Snack } from './../../../model/snack';
import { Component, OnInit } from '@angular/core';
import { ProduitService } from 'src/app/services/produit.service';
import { Achat } from 'src/app/model/achat';
import { Client } from 'src/app/model/client';

@Component({
  selector: 'app-snack',
  templateUrl: './snack.component.html',
  styleUrls: ['./snack.component.css'],
})
export class SnackComponent implements OnInit {
  snacks: Snack[] = [];
  client: Client = new Client(Number(localStorage.getItem('id')));
  quantite: number = 0;
  constructor(
    private produitService: ProduitService,
    private achatService: AchatService,
    private authService: AuthentificationService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.produitService.getAllSnacks().subscribe((result) => {
      this.snacks = [];
      for (let s of result) {
        this.snacks.push(
          new Snack(s.id, s.nom, s.description, s.prix, s.stock, s.points)
        );
      }
    });
  }

  ajoutPanier(snack: Snack) {
    if (this.authService.isAutenticated()) {
      this.achatService
        .createCatalogue({
          id_client: {
            id: this.client.id,
          },
          id_produit: {
            type: 'snack',
            id: snack.id,
          },
          quantite: this.quantite,
        })
        .subscribe(() => {});
      snack.stock! -= this.quantite;
    } else {
      this.router.navigateByUrl('/login');
    }

    //console.log(new Achat(undefined, this.client, snack, 1));
  }

  triPrix() {
    this.snacks = this.snacks.sort((a, b) => {
      return a.prix! > b.prix! ? 1 : -1;
    });
  }

  triPrixR() {
    this.snacks = this.snacks.sort((a, b) => {
      return a.prix! < b.prix! ? 1 : -1;
    });
  }

  triAlpha() {
    this.snacks = this.snacks.sort((a, b) => {
      return a.nom!.localeCompare(b.nom!);
    });
  }

  triAlphaR() {
    this.snacks = this.snacks.sort((a, b) => {
      return b.nom!.localeCompare(a.nom!);
    });
  }

  // triAvis() {}

  get tableau(): Snack[] {
    return this.snacks;
  }
}
