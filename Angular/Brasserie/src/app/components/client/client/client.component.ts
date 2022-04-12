import { Reglement } from './../../../model/enum/reglement';
import { InfoReglement } from './../../../model/info-reglement';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from './../../../services/client.service';
import { Client } from './../../../model/client';
import { Component, OnInit } from '@angular/core';
import {
  faCreditCard,
  faPencil,
  faPlus,
} from '@fortawesome/free-solid-svg-icons';
import { faCcPaypal } from '@fortawesome/free-brands-svg-icons';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css'],
})
export class ClientComponent implements OnInit {
  client: Client = new Client();
  reglements: InfoReglement[] = [];
  modeReg = Reglement;
  iconCB = faCreditCard;
  iconPayPal = faCcPaypal;
  iconEdit = faPencil;
  iconAdd = faPlus;

  constructor(
    private clientService: ClientService,
    private aR: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.clientService.get(params['id']).subscribe((result) => {
          this.client = result;
        });
        this.clientService.getInfoReg(params['id']).subscribe((result) => {
          for (let ir of result) {
            this.reglements.push(
              new InfoReglement(
                ir.id,
                this.client,
                ir.mode,
                ir.num,
                ir.nom,
                ir.dateValid,
                ir.identifiant_paypal
              )
            );
          }
        });
      }
    });
  }
}
