import { ReglementEditComponent } from './components/reglement-edit/reglement-edit.component';
import { BrasseurComponent } from './components/brasseur/brasseur/brasseur.component';
import { BrasseurEditComponent } from './components/brasseur/brasseur-edit/brasseur-edit.component';
import { HomeComponent } from './components/home/home.component';
import { ReglementComponent } from './components/reglement/reglement.component';
import { ClientEditComponent } from './components/client/client-edit/client-edit.component';
import { PasswordEditComponent } from './components/client/password-edit/password-edit.component';
import { ClientComponent } from './components/client/client/client.component';
import { EditProduitComponent } from './components/produit/edit-produit/edit-produit.component';
import { NoteComponent } from './components/note/note/note.component';
import { EditNoteComponent } from './components/note/edit-note/edit-note.component';
import { ProduitComponent } from './components/produit/produit/produit.component';
import { EvenementEditComponent } from './components/evenement/evenement-edit/evenement-edit.component';
// import { ClientBrasseurEditComponent } from './components/client/client-brasseur-edit/client-brasseur-edit.component';
import { ClientListComponent } from './components/client/client-list/client-list.component';
import { ReservationEditComponent } from './components/reservation/reservation-edit/reservation-edit.component';
import { Routes } from '@angular/router';
import { ReservationListComponent } from './components/reservation/reservation-list/reservation-list.component';
import { ReservationListClientComponent } from './components/reservation/reservation-list-client/reservation-list-client.component';
import { LoginComponent } from './components/login/login.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'brasseur/clients', component: ClientListComponent },
  // { path: 'brasseur/clients/edit/:id', component: ClientBrasseurEditComponent },
  { path: 'client/:id', component: ClientComponent },
  { path: 'client/editPassword/:id', component: PasswordEditComponent },
  { path: 'client/edit/:cathegorie/:id', component: ClientEditComponent },
  {
    path: 'client/edit/:idReg/:cathegorie/:id',
    component: ClientEditComponent,
  },
  { path: 'reglement/edit', component: ReglementEditComponent},
  { path: 'brasseur', component: BrasseurComponent },
  { path: 'brasseur/editPassword/:id', component: PasswordEditComponent },
  { path: 'brasseur/edit/:cathegorie/:id', component: BrasseurEditComponent },
  { path: 'login', component: LoginComponent },
  { path: 'produit', component: ProduitComponent },
  {path: 'reservationListClient', component: ReservationListClientComponent },
  {path: 'reglement', component: ReglementComponent},
  { path: 'reservationList', component: ReservationListComponent },
  { path: 'reservation/edit', component: ReservationEditComponent },
  { path: 'reservation/edit/:id', component: ReservationEditComponent },
  { path: 'produit/edit', component: EditProduitComponent },
  { path: 'produit/edit/:id', component: EditProduitComponent },
  { path: 'evenement', component: EvenementEditComponent },
  { path: 'produit/add/:type', component: EditProduitComponent },
  { path: 'note', component: NoteComponent },
  { path: 'note/edit', component: EditNoteComponent },
  { path: 'note/edit/:id_note', component: EditNoteComponent },
];
