import { StatutResa } from './../../../model/enum/statut-resa';
import { Reservation } from './../../../model/reservation';
import { Component, OnInit } from '@angular/core';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css']
})
export class ReservationListComponent implements OnInit {

  reservations: Reservation[] = [];
  statutResa = StatutResa;
  constructor(private reservationService: ReservationService) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.reservationService.getAll().subscribe((result) => {
      this.reservations = result;
      console.log(this.reservations)
    });
  }

  delete(id: number) {
    this.reservationService.delete(id).subscribe((noResult) => {
      this.list();
    });
  }


}
