import { ClientEditComponent } from './components/client/client-edit/client-edit.component';
import { PasswordEditComponent } from './components/client/password-edit/password-edit.component';
import { ClientComponent } from './components/client/client/client.component';
import { EditProduitComponent } from './components/produit/edit-produit/edit-produit.component';
import { NoteComponent } from './components/note/note/note.component';
import { EditNoteComponent } from './components/note/edit-note/edit-note.component';
import { ProduitComponent } from './components/produit/produit/produit.component';
import { EditProduitComponent } from './components/produit/edit-produit/edit-produit.component';
import { EvenementEditComponent } from './components/evenement/evenement-edit/evenement-edit.component';
import { ClientBrasseurEditComponent } from './components/client/client-brasseur-edit/client-brasseur-edit.component';
import { ClientListComponent } from './components/client/client-list/client-list.component';
import { ReservationEditComponent } from './components/reservation/reservation-edit/reservation-edit.component';
import { Routes } from '@angular/router';
import { ReservationListComponent } from './components/reservation/reservation-list/reservation-list.component';

export const routes: Routes = [
  { path: 'brasseur/clients', component: ClientListComponent },
  { path: 'brasseur/clients/edit/:id', component: ClientBrasseurEditComponent },
  { path: 'client/:id', component: ClientComponent },
  { path: 'client/editPassword/:id', component: PasswordEditComponent },
  { path: 'client/edit/:cathegorie/:id', component: ClientEditComponent },
  {
    path: 'client/edit/:idReg/:cathegorie/:id',
    component: ClientEditComponent,
  },
  { path: 'produit', component: ProduitComponent },
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
