import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ListAllVoyagesComponent } from './list-all-voyages/list-all-voyages.component';

import {MenubarModule} from 'primeng/menubar';
import {ButtonModule} from 'primeng/button';
import {DataScrollerModule} from 'primeng/datascroller';

@NgModule({
  declarations: [
    AppComponent,
    ListAllVoyagesComponent
  ],
  imports: [
    BrowserModule,
    MenubarModule,
    ButtonModule,
    DataScrollerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
