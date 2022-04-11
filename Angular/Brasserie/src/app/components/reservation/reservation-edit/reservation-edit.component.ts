import { Evenement } from './../../../model/evenement';
import { Reservation } from './../../../model/reservation';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-reservation-edit',
  templateUrl: './reservation-edit.component.html',
  styleUrls: ['./reservation-edit.component.css']
})
export class ReservationEditComponent implements OnInit {

  reservation: Reservation = new Reservation();
  reservations: Reservation[] = [];

  constructor(
    private aR: ActivatedRoute,
    private reservationService: ReservationService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.list();
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.reservationService.get(params['id']).subscribe((result) => {
          this.reservation = result;
          console.log(result);
        });
      }
    });
  }
  list() {
    this.reservationService.getAll().subscribe((result) => {
      this.reservations = result;
      console.log(this.reservations)
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
