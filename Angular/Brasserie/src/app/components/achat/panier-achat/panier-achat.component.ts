import { AchatService } from './../../../services/achat.service';
import { Component, OnInit } from '@angular/core';
import { Achat } from 'src/app/model/achat';

@Component({
  selector: 'app-panier-achat',
  templateUrl: './panier-achat.component.html',
  styleUrls: ['./panier-achat.component.css'],
})
export class PanierAchatComponent implements OnInit {
  achats: Achat[] = [];
  id: number = Number(localStorage.getItem('id'));
  totalPrix: number = 0;
  totalQuantite: number = 0;
  constructor(private achatService: AchatService) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.achatService.getByClient(this.id).subscribe((result) => {
      this.achats = [];
      for (let a of result) {
        this.achats.push(
          new Achat(a.id_achat, a.id_client, a.id_produit, a.quantite)
        );
        this.totalQuantite += a.quantite;
        if (this.achats.length > 1) {
          for (let p of a.id_produit) {
            this.totalPrix += p.prix;
          }
        } else {
          this.totalPrix = a.id_produit.prix;
        }
      }
    });
  }

  delete(id: number) {
    this.achatService.delete(id).subscribe((ok) => {
      this.list();
    });
  }
}
