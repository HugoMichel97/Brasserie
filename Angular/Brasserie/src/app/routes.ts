import { ClientBrasseurEditComponent } from './components/client/client-brasseur-edit/client-brasseur-edit.component';
import { ClientListComponent } from './components/client/client-list/client-list.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'brasseur/clients', component: ClientListComponent },
  { path: 'brasseur/clients/edit/:id', component: ClientBrasseurEditComponent },
];
