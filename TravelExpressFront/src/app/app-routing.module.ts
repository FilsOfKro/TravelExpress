import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

import { ConnectionComponent } from './connection/connection.component';
import { RechercheComponent } from './recherche/recherche.component';
import { PanierComponent } from './panier/panier.component';
import { ListAllVoyagesComponent } from './list-all-voyages/list-all-voyages.component';
import { NewAccountComponent } from './connection/newAccount/newAccount.component';

const routes: Routes = [
  { path: '', redirectTo: '/flight', pathMatch: 'full' },
  { path: 'login', component: ConnectionComponent },
  { path: 'search', component: RechercheComponent },
  { path: 'basket', component: PanierComponent },
  { path: 'flight', component: ListAllVoyagesComponent},
  { path: 'new-account', component: NewAccountComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
