import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ListAllVoyagesComponent } from './list-all-voyages/list-all-voyages.component';

import {MenubarModule} from 'primeng/menubar';
import {ButtonModule} from 'primeng/button';
import {DataScrollerModule} from 'primeng/datascroller';

import { environment } from '../environments/environment';
import {APP_BASE_HREF} from '@angular/common';

let path = '/';

if (environment.production) {
  path = '/travelExpress';
}

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
  providers: [{provide: APP_BASE_HREF, useValue: path}],
  bootstrap: [AppComponent]
})
export class AppModule { }
