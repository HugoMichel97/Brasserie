import { Router } from '@angular/router';
import { ReservationService } from 'src/app/services/reservation.service';
import { Brasseur } from './../../../model/brasseur';
import { Client } from 'src/app/model/client';
import { BrasseurService } from './../../../services/brasseur.service';
import { ClientService } from './../../../services/client.service';
import { AuthentificationService } from './../../../services/authentification.service';
import {
  faCalendarDay,
  faPencil,
  faTrashCan,
} from '@fortawesome/free-solid-svg-icons';
import { Component, OnInit } from '@angular/core';
import { Evenement } from 'src/app/model/evenement';
import { EvenementService } from 'src/app/services/evenements.service';
import { Reservation } from 'src/app/model/reservation';

@Component({
  selector: 'app-evenenement-list',
  templateUrl: './evenenement-list.component.html',
  styleUrls: ['./evenenement-list.component.css'],
})
export class EvenenementListComponent implements OnInit {
  evenement: Evenement[] = [];
  client: Client = new Client();
  brasseur: Brasseur = new Brasseur();
  iconEdit = faPencil;
  iconDelete = faTrashCan;
  iconResa = faCalendarDay;

  constructor(
    private evenementsService: EvenementService,
    private resaService: ReservationService,
    private authService: AuthentificationService,
    private clientService: ClientService,
    private brasseurService: BrasseurService,
    private router: Router
  ) {}

  ngOnInit(): void {
    if (localStorage.getItem('role') == 'client') {
      this.clientService
        .getByMail(localStorage.getItem('login')!)
        .subscribe((result) => {
          this.client = new Client(result.id);
        });
    } else if (localStorage.getItem('role') == 'brasseur') {
      this.brasseurService
        .getByMail(localStorage.getItem('login')!)
        .subscribe((result) => {
          this.brasseur = new Brasseur(result.id, result.mail);
        });
    }
    this.list();
  }

  list() {
    this.evenementsService.getAll().subscribe((result) => {
      this.evenement = [];
      for (let e of result) {
        this.evenement.push(
          new Evenement(
            e.id,
            e.date,
            e.heure,
            e.libelle,
            e.prix,
            e.ptsRequis,
            e.description,
            e.nbPlaces
          )
        );
      }
    });
  }

  isAutenticated() {
    return this.authService.isAutenticated();
  }

  get role() {
    return localStorage.getItem('role');
  }

  createResa(evt: Evenement) {
    let resa = {
      client: { id: this.client.id },
      evt: { id: evt.id },
    };
    console.log(resa);

    this.resaService.create(resa).subscribe(() => {
      this.router.navigateByUrl('/reservation/client/' + this.client.id);
    });
  }

  delete(id: number) {
    this.evenementsService.delete(id).subscribe((noResult) => {
      this.list();
    });
  }
}
