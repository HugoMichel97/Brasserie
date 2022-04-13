import { HttpClientModule } from '@angular/common/http';
import { EditAchatComponent } from './components/achat/edit-achat/edit-achat.component';
import { AchatComponent } from './components/achat/achat/achat.component';
import { EditNoteComponent } from './components/note/edit-note/edit-note.component';
import { NoteComponent } from './components/note/note/note.component';
import { EditProduitComponent } from './components/produit/edit-produit/edit-produit.component';
import { ProduitComponent } from './components/produit/produit/produit.component';
import { routes } from './routes';

import { NgModule } from '@angular/core';
import { FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
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
// import { ClientBrasseurEditComponent } from './components/client/client-brasseur-edit/client-brasseur-edit.component';
import { ReglementComponent } from './components/reglement/reglement.component';
import { BiereComponent } from './components/produit/biere/biere.component';
import { SnackComponent } from './components/produit/snack/snack.component';
import { NoteClientComponent } from './components/note/note-client/note-client.component';
import { LoginComponent } from './components/login/login.component';
import { ReservationListClientComponent } from './components/reservation/reservation-list-client/reservation-list-client.component';
import { FooterComponent } from './app/footer/footer/footer.component';
import { HeaderComponent } from './app/header/header.component';
import { PasswordEditComponent } from './components/client/password-edit/password-edit.component';
import { IndexComponent } from './app/index/index.component';
import { AdminComponent } from './app/admin/admin.component';
import { HomeComponent } from './components/home/home.component';
import { BrasseurComponent } from './components/brasseur/brasseur/brasseur.component';
import { BrasseurEditComponent } from './components/brasseur/brasseur-edit/brasseur-edit.component';
import { ReglementEditComponent } from './components/reglement-edit/reglement-edit.component';
import { CarteCreditComponent } from './components/carte-credit/carte-credit.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ReservationListClientComponent,
    FooterComponent,
    HeaderComponent,
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
    // ClientBrasseurEditComponent,
    ReglementComponent,
    PasswordEditComponent,
    IndexComponent,
    AdminComponent,
    HomeComponent,
    BrasseurComponent,
    BrasseurEditComponent,
    ReglementEditComponent,
    CarteCreditComponent,
    BiereComponent,
    SnackComponent,
    NoteClientComponent,
  ],

  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    FontAwesomeModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
