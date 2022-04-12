import { Evenement } from './../../../model/evenement';
import { Reservation } from './../../../model/reservation';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReservationService } from 'src/app/services/reservation.service';
import { EvenementService } from 'src/app/services/evenements.service';
import { Client } from 'src/app/model/client';
import { StatutResa } from 'src/app/model/enum/statut-resa';
import { FormGroup } from '@angular/forms';


@Component({
  selector: 'app-reservation-edit',
  templateUrl: './reservation-edit.component.html',
  styleUrls: ['./reservation-edit.component.css']
})
export class ReservationEditComponent implements OnInit {

  reservation: Reservation = new Reservation();
  evenements: Evenement[] = [];
  client : Client = new Client();
  evt : Evenement = new Evenement();
  libelle: string | undefined;
  statutResa = StatutResa;
  form!: FormGroup;


  constructor(
    private aR: ActivatedRoute,
    private reservationService: ReservationService,
    private evenementService: EvenementService,
    private router: Router
  ) { }
  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.reservationService.get(params['id']).subscribe((result) => {
          this.reservation = result;
          this.form.get('client.nom')?.setValue(result.client?.nom);
          this.form.get('client.prenom')?.setValue(result.client?.prenom);
          this.form.get('evt.libelle')?.setValue(result.evt?.libelle);
          this.form.get('nbParticipants')?.setValue(result.nbParticipants)
        });
      }
    });
  }

  list() {
    this.evenementService.getAll().subscribe((result) => {
      this.evenements = result;
      console.log(this.evenements)
    });
  }
  save() {
    if (this.reservation.id) {
      this.reservationService.update(this.reservation).subscribe((result) => {
        this.goList();
      });
    } else {
      this.reservationService.create(this.reservation).subscribe((result) => {
        this.goList();
      });
    }
  }

  goList() {
    this.router.navigateByUrl('/reservationList');
  }
}
