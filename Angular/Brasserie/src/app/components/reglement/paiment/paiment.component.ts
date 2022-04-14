import { StatutResa } from 'src/app/model/enum/statut-resa';
import { Client } from './../../../model/client';
import { ActivatedRoute, Router } from '@angular/router';
import { Reglement } from './../../../model/enum/reglement';
import { faCcPaypal } from '@fortawesome/free-brands-svg-icons';
import { faCreditCard } from '@fortawesome/free-solid-svg-icons';
import { ClientService } from './../../../services/client.service';
import { ReservationService } from 'src/app/services/reservation.service';
import { ReglementService } from 'src/app/services/reglement.service';
import { AchatService } from './../../../services/achat.service';
import { InfoReglement } from './../../../model/info-reglement';
import { Component, OnInit } from '@angular/core';
import { StatutCommande } from 'src/app/model/enum/statut-commande';
import { Reservation } from 'src/app/model/reservation';

@Component({
  selector: 'app-paiment',
  templateUrl: './paiment.component.html',
  styleUrls: ['./paiment.component.css'],
})
export class PaimentComponent implements OnInit {
  id: number = Number(localStorage.getItem('id'));
  reglement: InfoReglement = new InfoReglement();
  client: Client = new Client();
  resa: Reservation = new Reservation();
  iconCB = faCreditCard;
  iconPp = faCcPaypal;
  modeReg = Reglement;
  type: string = '';
  idResa: number | undefined;

  constructor(
    private aR: ActivatedRoute,
    private clientService: ClientService,
    private resaService: ReservationService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['type']) {
        this.type = params['type'];
      }
      if (params['id']) {
        this.idResa = params['id'];
      }
    });
  }

  valid() {
    if (this.type == 'achat') {
      this.clientService.get(this.id).subscribe((result) => {
        this.client = result;
        this.client.statut = StatutCommande.validee;
        this.clientService.update(this.client).subscribe(() => {
          this.router.navigateByUrl('/index');
        });
      });
    } else if (this.type == 'resa') {
      this.resaService.get(this.idResa!).subscribe((result) => {
        this.resa = result;
        this.resa.statut = StatutResa.validee;
        this.resaService.update(this.resa).subscribe(() => {
          this.router.navigateByUrl('/index');
        });
      });
    }
  }
}
