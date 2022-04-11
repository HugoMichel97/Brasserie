import { HttpClientModule } from '@angular/common/http';
import { EditAchatComponent } from './components/achat/edit-achat/edit-achat.component';
import { AchatComponent } from './components/achat/achat/achat.component';
import { EditNoteComponent } from './components/note/edit-note/edit-note.component';
import { NoteComponent } from './components/note/note/note.component';
import { EditProduitComponent } from './components/produit/edit-produit/edit-produit.component';
import { ProduitComponent } from './components/produit/produit/produit.component';
import { routes } from './routes';

import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { ReservationListComponent } from './components/reservation/reservation-list/reservation-list.component';
import { ReservationEditComponent } from './components/reservation/reservation-edit/reservation-edit.component';
import { EvenementEditComponent } from './components/evenement/evenement-edit/evenement-edit.component';
import { IngredientEditComponent } from './components/ingredient/ingredient-edit/ingredient-edit.component';

import { EvenenementListComponent } from './components/evenement/evenenement-list/evenenement-list.component';
import { IngredientListComponent } from './components/ingredient/ingredient-list/ingredient-list.component';

@NgModule({
  declarations: [
    AppComponent,
    ReservationListComponent,
    ReservationEditComponent,
    ProduitComponent,
    EditProduitComponent,
    NoteComponent,
    EditNoteComponent,
    AchatComponent,
    EditAchatComponent,
    EvenementEditComponent,
    IngredientEditComponent,
    EvenenementListComponent,
    IngredientListComponent,
  ],

  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
