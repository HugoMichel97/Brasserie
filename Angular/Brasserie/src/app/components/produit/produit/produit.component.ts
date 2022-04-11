import { Snack } from './../../../model/snack';
import { Biere } from './../../../model/biere';
import { Produit } from './../../../model/produit';
import { ProduitService } from './../../../services/produit.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css'],
})
export class ProduitComponent implements OnInit {
  produits: Produit[] = [];
  constructor(private produitService: ProduitService) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.produitService.getAll().subscribe((result) => {
      this.produits = [];
      for (let p of result) {
        if (p.type == 'biere') {
          this.produits.push(
            new Biere(p.id, p.nom, p.description, p.prix, p.stock, p.points)
          );
        } else {
          this.produits.push(
            new Snack(p.id, p.nom, p.description, p.prix, p.stock, p.points)
          );
        }
      }
    });
  }

  getType(produit: Produit): string {
    if (produit instanceof Biere) {
      return 'Biere';
    } else {
      return 'Snack';
    }
  }

  //delete by id ou by produit ?
  delete(id: number) {
    this.produitService.delete(id).subscribe((done) => {
      this.list();
    });
  }
}
