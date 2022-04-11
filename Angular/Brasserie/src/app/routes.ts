import { ReservationEditComponent } from './components/reservation/reservation-edit/reservation-edit.component';
import { Routes } from '@angular/router';
import { ReservationListComponent } from './components/reservation/reservation-list/reservation-list.component';

export const routes: Routes = [
  {path: 'reservationList', component: ReservationListComponent},
  {path: 'reservation/edit', component: ReservationEditComponent},
  {path: 'reservation/edit/:id', component: ReservationEditComponent},
];
