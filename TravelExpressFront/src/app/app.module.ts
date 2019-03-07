import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ListAllVoyagesComponent } from './list-all-voyages/list-all-voyages.component';

import { MenubarModule } from 'primeng/menubar';
import { ButtonModule } from 'primeng/button';
import { DataScrollerModule } from 'primeng/datascroller';
import { TravelRowComponent } from './travel-row/travel-row.component';
import { DataViewModule } from 'primeng/dataview';
import { DropdownModule } from 'primeng/dropdown';
import { PanelModule } from 'primeng/panel';
import { ConnectionComponent } from './connection/connection.component';
import { RechercheComponent } from './recherche/recherche.component';
import { PanierComponent } from './panier/panier.component';
import { CalendarModule } from 'primeng/calendar';
import { CardModule } from 'primeng/card';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { InputTextModule } from 'primeng/inputtext';
import { NewAccountComponent } from './connection/newAccount/newAccount.component';
import { PanierLigneComponent } from './panier/panier-ligne/panier-ligne.component';
import { PasswordModule } from 'primeng/password';

@NgModule({
  declarations: [
    AppComponent,
    ListAllVoyagesComponent,
    TravelRowComponent,
    ConnectionComponent,
    RechercheComponent,
    PanierComponent,
    NewAccountComponent,
    PanierLigneComponent
  ],
  imports: [
    BrowserModule,
    MenubarModule,
    ButtonModule,
    DataScrollerModule,
    DataViewModule,
    DropdownModule,
    PanelModule,
    AppRoutingModule,
    CalendarModule,
    CardModule,
    BrowserAnimationsModule,
    InputTextModule,
    PasswordModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
