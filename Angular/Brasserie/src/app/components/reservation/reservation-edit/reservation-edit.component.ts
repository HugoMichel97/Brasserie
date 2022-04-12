import { Evenement } from './../../../model/evenement';
import { Reservation } from './../../../model/reservation';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReservationService } from 'src/app/services/reservation.service';
import { EvenementService } from 'src/app/services/evenements.service';
import { Client } from 'src/app/model/client';


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


  constructor(
    private aR: ActivatedRoute,
    private reservationService: ReservationService,
    private evenementService: EvenementService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.list();
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.reservationService.get(params['id']).subscribe((result) => {
          this.reservation = result;
          this.client = result.client!;
          this.evt = result.evt!
          console.log(result);
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
