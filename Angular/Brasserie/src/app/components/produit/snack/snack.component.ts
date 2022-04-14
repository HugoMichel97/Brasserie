import { Snack } from './../../../model/snack';
import { Component, OnInit } from '@angular/core';
import { ProduitService } from 'src/app/services/produit.service';

@Component({
  selector: 'app-snack',
  templateUrl: './snack.component.html',
  styleUrls: ['./snack.component.css'],
})
export class SnackComponent implements OnInit {
  snacks: Snack[] = [];
  constructor(private produitService: ProduitService) {}

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
