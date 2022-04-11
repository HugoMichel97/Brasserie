import { Achat } from './../../../model/achat';
import { ClientService } from './../../../service/client.service';
import { Client } from './../../../model/client';
import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';
import { faPencil, faShoppingBasket } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css'],
})
export class ClientListComponent implements OnInit {
  clients: Client[] = [];
  iconPanier = faShoppingBasket;
  iconModif = faPencil;

  constructor(private clientService: ClientService) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.clientService.getAll().subscribe((result) => {
      this.clients = [];
      for (let c of result) {
        this.clients.push(
          new Client(
            c.id,
            c.mail,
            c.nom,
            c.prenom,
            c.tel,
            c.fidelite,
            c.naissance,
            c.statut
          )
        );
      }
    });
  }

  panier() {}
}
