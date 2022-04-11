import { routes } from './routes';

import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { ReservationListComponent } from './components/reservation/reservation-list/reservation-list.component';
import { ReservationEditComponent } from './components/reservation/reservation-edit/reservation-edit.component';
import { ProduitListComponent } from './components/produit/produit-list/produit-list.component';
import { ProduitEditComponent } from './components/produit/produit-edit/produit-edit.component';
import { HttpClientModule } from '@angular/common/http';
import { ReglementComponent } from './components/reglement/reglement.component';

@NgModule({
  declarations: [AppComponent, ReservationListComponent, ReservationEditComponent, ProduitListComponent, ProduitEditComponent, ReglementComponent],
  imports: [BrowserModule, FormsModule, RouterModule.forRoot(routes), HttpClientModule,],

  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
