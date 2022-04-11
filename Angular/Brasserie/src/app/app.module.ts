import { routes } from './routes';
import { HttpClientModule } from '@angular/common/http';

import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { ReservationListComponent } from './components/reservation/reservation-list/reservation-list.component';
import { ReservationEditComponent } from './components/reservation/reservation-edit/reservation-edit.component';
import { ProduitListComponent } from './components/produit/produit-list/produit-list.component';
import { ProduitEditComponent } from './components/produit/produit-edit/produit-edit.component';
import { EvenementEditComponent } from './components/evenement/evenement-edit/evenement-edit.component';
import { IngredientEditComponent } from './components/ingredient/ingredient-edit/ingredient-edit.component';

import { EvenenementListComponent } from './components/evenement/evenenement-list/evenenement-list.component';
import { IngredientListComponent } from './components/ingredient/ingredient-list/ingredient-list.component';

@NgModule({
  declarations: [AppComponent, ReservationListComponent, ReservationEditComponent, ProduitListComponent, ProduitEditComponent, EvenementEditComponent, IngredientEditComponent, EvenenementListComponent, IngredientListComponent],
  imports: [BrowserModule, FormsModule, HttpClientModule, RouterModule.forRoot(routes)],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
