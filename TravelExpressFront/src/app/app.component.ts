import { Component } from '@angular/core';
import {MenubarModule} from 'primeng/menubar';
import {MenuItem} from 'primeng/api';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  items: MenuItem[];
  ngOnInit() {
    this.items = [
      {
          label: 'Voiture',
          icon: 'fa fa-car',
      },
      {
          label: 'Avion',
          icon: 'fa fa-plane',
          
      },
      {
          label: 'Bateau',
          icon: 'fa fa-ship',
          
      }
  ];
}
}
