import { StatutCommande } from './../../../model/enum/statut-commande';
import { Achat } from './../../../model/achat';
import { ClientService } from '../../../services/client.service';
import { Client } from './../../../model/client';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-client-brasseur-edit',
  templateUrl: './client-brasseur-edit.component.html',
  styleUrls: ['./client-brasseur-edit.component.css'],
})
export class ClientBrasseurEditComponent implements OnInit {
  client: Client = new Client();
  statutCommande = StatutCommande;
  commande: Achat[] = [];

  constructor(
    private aR: ActivatedRoute,
    private clientService: ClientService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.clientService.get(params['id']).subscribe((result) => {
          this.client = result;
        });
        this.clientService.getAchat(params['id']).subscribe((result) => {
          for (let a of result) {
            this.commande.push(
              new Achat(a.id_achat, this.client, a.id_produit, a.quantite)
            );
          }
        });
      }
    });
  }

  save(value: string) {
    if (this.client.id) {
      this.clientService
        .updateStatut(this.client, value)
        .subscribe((result) => {
          this.goList();
        });
    }
  }

  goList() {
    this.router.navigateByUrl('/brasseur/clients');
  }
}
