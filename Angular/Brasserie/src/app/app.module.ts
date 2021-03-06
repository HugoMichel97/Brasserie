import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { NgPaymentCardModule } from 'ng-payment-card';
import { AppComponent } from './app.component';
import { AdminComponent } from './app/admin/admin.component';
import { FooterComponent } from './app/footer/footer/footer.component';
import { HeaderComponent } from './app/header/header.component';
import { IndexComponent } from './app/index/index.component';
import { AchatComponent } from './components/achat/achat/achat.component';
import { EditAchatComponent } from './components/achat/edit-achat/edit-achat.component';
import { PanierAchatComponent } from './components/achat/panier-achat/panier-achat.component';
import { BrasseurEditComponent } from './components/brasseur/brasseur-edit/brasseur-edit.component';
import { BrasseurComponent } from './components/brasseur/brasseur/brasseur.component';
import { InfoComponent } from './components/brasseur/info/info.component';
import { CarteCreditComponent } from './components/carte-credit/carte-credit.component';
import { ClientBrasseurEditComponent } from './components/client/client-brasseur-edit/client-brasseur-edit.component';
import { ClientEditComponent } from './components/client/client-edit/client-edit.component';
import { ClientListComponent } from './components/client/client-list/client-list.component';
import { ClientComponent } from './components/client/client/client.component';
import { PasswordEditComponent } from './components/client/password-edit/password-edit.component';
import { CreateCompteComponent } from './components/create-compte/create-compte.component';
import { EvenementEditComponent } from './components/evenement/evenement-edit/evenement-edit.component';
import { EvenenementListComponent } from './components/evenement/evenenement-list/evenenement-list.component';
import { HomeComponent } from './components/home/home.component';
import { IngredientEditComponent } from './components/ingredient/ingredient-edit/ingredient-edit.component';
import { IngredientListComponent } from './components/ingredient/ingredient-list/ingredient-list.component';
import { LoginComponent } from './components/login/login.component';
import { EditNoteComponent } from './components/note/edit-note/edit-note.component';
import { NoteClientComponent } from './components/note/note-client/note-client.component';
import { NoteComponent } from './components/note/note/note.component';
import { BiereComponent } from './components/produit/biere/biere.component';
import { EditProduitComponent } from './components/produit/edit-produit/edit-produit.component';
import { ProduitComponent } from './components/produit/produit/produit.component';
import { SnackComponent } from './components/produit/snack/snack.component';
import { ReglementEditComponent } from './components/reglement-edit/reglement-edit.component';
import { ReglementComponent } from './components/reglement/reglement.component';
import { ReservationClientComponent } from './components/reservation/reservation-client/reservation-client.component';
import { ReservationEditComponent } from './components/reservation/reservation-edit/reservation-edit.component';
import { ReservationListClientComponent } from './components/reservation/reservation-list-client/reservation-list-client.component';
import { ReservationListComponent } from './components/reservation/reservation-list/reservation-list.component';
import { Interceptor } from './model/interceptor';
import { routes } from './routes';
import { PaimentComponent } from './components/reglement/paiment/paiment.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EditAchatComponent,
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
    EvenementEditComponent,
    IngredientEditComponent,
    EvenenementListComponent,
    IngredientListComponent,
    ClientListComponent,
    ClientEditComponent,
    ClientComponent,
    ClientBrasseurEditComponent,
    ReglementComponent,
    PasswordEditComponent,
    FooterComponent,
    HeaderComponent,
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
    InfoComponent,
    CreateCompteComponent,
    ReservationClientComponent,
    PanierAchatComponent,
    PaimentComponent,
  ],

  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    FontAwesomeModule,
    NgPaymentCardModule,
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: Interceptor, multi: true },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
