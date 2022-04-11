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
