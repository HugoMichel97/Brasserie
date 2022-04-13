import { ClientService } from './../../../service/client.service';
import { ProduitService } from './../../../services/produit.service';
import { ProduitComponent } from './../../produit/produit/produit.component';
import { Client } from './../../../model/client';
import { Produit } from './../../../model/produit';
import { AchatService } from './../../../services/achat.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Achat } from './../../../model/achat';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-edit-achat',
  templateUrl: './edit-achat.component.html',
  styleUrls: ['./edit-achat.component.css'],
})
export class EditAchatComponent implements OnInit {
  achat: Achat = new Achat();
  produits: Produit[] = [];
  clients: Client[] = [];
  constructor(
    private aR: ActivatedRoute,
    private achatService: AchatService,
    private produitService: ProduitService,
    private clientService: ClientService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.clientService.getAll().subscribe((result) => {
      this.clients = result;
    });

    this.produitService.getAll().subscribe((result) => {
      this.produits = result;
    });

    this.aR.params.subscribe((params) => {
      if (params['id_achat'] == 'undefined') {
        this.achat = new Achat();
      } else {
        this.achatService.getById(params['id_achat']).subscribe((a) => {
          this.achat = new Achat(
            a.id_achat,
            a.id_client
              ? new Client(a.client?.id, a.client?.prenom, a.client?.nom)
              : undefined,
            a.id_produit,
            a.quantite
          );
        });
      }
    });
  }

  save() {
    if (this.achat.id_achat) {
      this.achatService.update(this.achat).subscribe(() => {
        this.router.navigateByUrl('/achat');
      });
    } else {
      this.achatService.create(this.achat).subscribe(() => {
        this.router.navigateByUrl('/achat');
      });
    }
  }
}
