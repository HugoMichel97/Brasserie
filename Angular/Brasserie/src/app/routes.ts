import { PaimentComponent } from './components/reglement/paiment/paiment.component';
import { IngredientEditComponent } from './components/ingredient/ingredient-edit/ingredient-edit.component';
import { IngredientListComponent } from './components/ingredient/ingredient-list/ingredient-list.component';
import { PanierAchatComponent } from './components/achat/panier-achat/panier-achat.component';
import { ReservationClientComponent } from './components/reservation/reservation-client/reservation-client.component';
import { IndexComponent } from './app/index/index.component';
import { ClientBrasseurEditComponent } from './components/client/client-brasseur-edit/client-brasseur-edit.component';
import { ReglementComponent } from './components/reglement/reglement.component';
import { ClientEditComponent } from './components/client/client-edit/client-edit.component';
import { ClientComponent } from './components/client/client/client.component';
import { EditProduitComponent } from './components/produit/edit-produit/edit-produit.component';
import { NoteClientComponent } from './components/note/note-client/note-client.component';
import { SnackComponent } from './components/produit/snack/snack.component';
import { BiereComponent } from './components/produit/biere/biere.component';
import { Component } from '@angular/core';
import { EditAchatComponent } from './components/achat/edit-achat/edit-achat.component';
import { AchatComponent } from './components/achat/achat/achat.component';
import { NoteComponent } from './components/note/note/note.component';
import { EditNoteComponent } from './components/note/edit-note/edit-note.component';
import { ProduitComponent } from './components/produit/produit/produit.component';
import { EvenementEditComponent } from './components/evenement/evenement-edit/evenement-edit.component';
import { ClientListComponent } from './components/client/client-list/client-list.component';
import { ReservationEditComponent } from './components/reservation/reservation-edit/reservation-edit.component';
import { Routes } from '@angular/router';
import { ReservationListComponent } from './components/reservation/reservation-list/reservation-list.component';
import { EvenenementListComponent } from './components/evenement/evenenement-list/evenenement-list.component';
import { BrasseurEditComponent } from './components/brasseur/brasseur-edit/brasseur-edit.component';
import { BrasseurComponent } from './components/brasseur/brasseur/brasseur.component';
import { InfoComponent } from './components/brasseur/info/info.component';
import { PasswordEditComponent } from './components/client/password-edit/password-edit.component';
import { CreateCompteComponent } from './components/create-compte/create-compte.component';
import { LoginComponent } from './components/login/login.component';
import { ReglementEditComponent } from './components/reglement-edit/reglement-edit.component';

export const routes: Routes = [
  { path: 'index', component: IndexComponent },
  { path: '', redirectTo: 'index', pathMatch: 'full' },
  { path: 'infoBrasseur', component: InfoComponent },
  { path: 'login', component: LoginComponent },
  { path: 'create', component: CreateCompteComponent },
  { path: 'payer/:type', component: PaimentComponent },
  { path: 'payer/:type/:id', component: PaimentComponent },

  { path: 'ingredient', component: IngredientListComponent },
  { path: 'ingredient/edit/:id', component: IngredientEditComponent },
  { path: 'ingredient/edit', component: IngredientEditComponent },

  { path: 'produit', component: ProduitComponent },
  { path: 'produit/edit', component: EditProduitComponent },
  { path: 'produit/edit/:id', component: EditProduitComponent },
  { path: 'produit/add/:type', component: EditProduitComponent },
  { path: 'biere', component: BiereComponent },
  { path: 'snack', component: SnackComponent },
  { path: 'panier/:id', component: PanierAchatComponent },

  { path: 'evenement', component: EvenenementListComponent },

  { path: 'reservation/client/:id', component: ReservationClientComponent },
  { path: 'reservation/brasseur', component: ReservationListComponent },
  { path: 'reservationList', component: ReservationListComponent },
  { path: 'reservation/edit/:id', component: ReservationEditComponent },

  { path: 'brasseur/info/:id', component: BrasseurComponent },
  { path: 'brasseur/edit/:cathegorie/:id', component: BrasseurEditComponent },

  { path: 'brasseur/clients', component: ClientListComponent },
  { path: 'brasseur/clients/edit/:id', component: ClientBrasseurEditComponent },
  { path: 'brasseur/clients', component: ClientListComponent },
  { path: 'brasseur/clients/edit/:id', component: ClientBrasseurEditComponent },
  { path: 'client/:id', component: ClientComponent },
  { path: 'client/edit/:cathegorie/:id', component: ClientEditComponent },
  {
    path: 'client/edit/:idReg/:cathegorie/:id',
    component: ClientEditComponent,
  },
  { path: 'client/editPassword/:id', component: PasswordEditComponent },

  { path: 'reglement/edit', component: ReglementEditComponent },
  { path: 'reglement', component: ReglementComponent },

  { path: 'evenement', component: EvenementEditComponent },

  { path: 'note', component: NoteComponent },
  { path: 'note/edit', component: EditNoteComponent },
  { path: 'note/edit/:id_note', component: EditNoteComponent },
  { path: 'note/client/:id', component: NoteClientComponent },
  { path: 'note/add', component: EditNoteComponent },

  { path: 'achat', component: AchatComponent },
  { path: 'achat/edit', component: EditAchatComponent },
  { path: 'achat/edit/:id_achat', component: EditAchatComponent },
];
