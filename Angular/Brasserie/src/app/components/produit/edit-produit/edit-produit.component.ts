import { Snack } from './../../../model/snack';
import { Biere } from './../../../model/biere';
import { Produit } from './../../../model/produit';
import { ProduitService } from './../../../services/produit.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-produit',
  templateUrl: './edit-produit.component.html',
  styleUrls: ['./edit-produit.component.css'],
})
export class EditProduitComponent implements OnInit {
  produit: Produit = new Biere();
  constructor(
    private aR: ActivatedRoute,
    private produitService: ProduitService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      // console.log(params);
      if (params['type']) {
        if (params['type'] == 'biere') {
          this.produit = new Biere();
        } else {
          this.produit = new Snack();
        }
      } else {
        this.produitService.getById(params['id']).subscribe((p) => {
          if (p.type == 'biere') {
            this.produit = new Biere(
              p.id,
              p.nom,
              p.description,
              p.prix,
              p.stock,
              p.points
            );
          } else {
            this.produit = new Snack(
              p.id,
              p.nom,
              p.description,
              p.prix,
              p.stock,
              p.points
            );
          }
        });
      }
    });
  }

  save() {
    if (this.produit.id) {
      this.produitService.update(this.produit).subscribe(() => {
        this.router.navigateByUrl('/produit');
      });
    } else {
      this.produitService.create(this.produit).subscribe(() => {
        this.router.navigateByUrl('/produit');
      });
    }
  }
}
