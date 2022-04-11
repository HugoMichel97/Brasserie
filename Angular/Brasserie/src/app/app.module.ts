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
import { ClientListComponent } from './components/client/client-list/client-list.component';
import { ClientEditComponent } from './components/client/client-edit/client-edit.component';
import { ClientComponent } from './components/client/client/client.component';
import { HttpClientModule } from '@angular/common/http';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { ClientBrasseurEditComponent } from './components/client/client-brasseur-edit/client-brasseur-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    ReservationListComponent,
    ReservationEditComponent,
    ProduitListComponent,
    ProduitEditComponent,
    ClientListComponent,
    ClientEditComponent,
    ClientComponent,
    ClientBrasseurEditComponent,
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    FontAwesomeModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
