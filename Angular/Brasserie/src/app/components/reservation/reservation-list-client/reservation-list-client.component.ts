import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { StatutResa } from 'src/app/model/enum/statut-resa';
import { Reservation } from 'src/app/model/reservation';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-reservation-list-client',
  templateUrl: './reservation-list-client.component.html',
  styleUrls: ['./reservation-list-client.component.css'],
})
export class ReservationListClientComponent implements OnInit {
  reservations: Reservation[] = [];
  statutResa = StatutResa;
  constructor(
    private reservationService: ReservationService,
    private aR: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.reservationService
          .getWithClient(params['id'])
          .subscribe((result) => {
            this.reservations = result;
            console.log(this.reservations);
          });
      }
    });
  }

  delete(id: number) {
    this.reservationService.delete(id).subscribe((noResult) => {
      this.list();
    });
  }
}
