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
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

import { AppComponent } from './app.component';
import { ReservationListComponent } from './components/reservation/reservation-list/reservation-list.component';
import { ReservationEditComponent } from './components/reservation/reservation-edit/reservation-edit.component';
import { EvenementEditComponent } from './components/evenement/evenement-edit/evenement-edit.component';
import { IngredientEditComponent } from './components/ingredient/ingredient-edit/ingredient-edit.component';
import { EvenenementListComponent } from './components/evenement/evenenement-list/evenenement-list.component';
import { IngredientListComponent } from './components/ingredient/ingredient-list/ingredient-list.component';
import { ClientListComponent } from './components/client/client-list/client-list.component';
import { ClientEditComponent } from './components/client/client-edit/client-edit.component';
import { ClientComponent } from './components/client/client/client.component';
import { ClientBrasseurEditComponent } from './components/client/client-brasseur-edit/client-brasseur-edit.component';
import { ReglementComponent } from './components/reglement/reglement.component';
import { BiereComponent } from './components/produit/biere/biere.component';
import { SnackComponent } from './components/produit/snack/snack.component';
import { NoteClientComponent } from './components/note/note-client/note-client.component';
import { PanierAchatComponent } from './components/achat/panier-achat/panier-achat.component';

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
    ClientListComponent,
    ClientEditComponent,
    ClientComponent,
    ClientBrasseurEditComponent,
    ReglementComponent,
    BiereComponent,
    SnackComponent,
    NoteClientComponent,
    PanierAchatComponent,
  ],

  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    FontAwesomeModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
