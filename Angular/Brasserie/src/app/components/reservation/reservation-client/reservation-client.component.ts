import { faCreditCard } from '@fortawesome/free-solid-svg-icons';
import { Router } from '@angular/router';
import { Libelle } from './../../../model/enum/libelle';
import { Component, OnInit } from '@angular/core';
import { StatutResa } from 'src/app/model/enum/statut-resa';
import { Reservation } from 'src/app/model/reservation';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-reservation-client',
  templateUrl: './reservation-client.component.html',
  styleUrls: ['./reservation-client.component.css'],
})
export class ReservationClientComponent implements OnInit {
  reservations: Reservation[] = [];
  statutResa = StatutResa;
  libelles = Libelle;
  private id: number | undefined;
  iconCard = faCreditCard;

  constructor(
    private reservationService: ReservationService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.id = Number(localStorage.getItem('id'));
    this.list(this.id);
  }

  list(id: number) {
    this.reservationService.getWithClient(id).subscribe((result) => {
      this.reservations = result;
    });
  }

  delete(id: number) {
    this.reservationService.delete(id).subscribe((noResult) => {
      this.list(this.id!);
    });
  }
}
