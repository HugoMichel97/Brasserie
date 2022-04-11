import { routes } from './routes';

import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { ReservationListComponent } from './components/reservation/reservation-list/reservation-list.component';
import { ReservationEditComponent } from './components/reservation/reservation-edit/reservation-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    ReservationListComponent,
    ReservationEditComponent,
  ],
  imports: [BrowserModule, FormsModule, RouterModule.forRoot(routes)],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
