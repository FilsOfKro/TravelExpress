import { Component, OnInit } from '@angular/core';
import { ConnectionService } from '../connection/connection.service';
import { TravelRowService } from '../travel-row/travelRow.service';
import { Voyage } from '../voyage';
import { PanierService } from './panier.service';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css'],
  providers: [PanierService, TravelRowService, ConnectionService]

})
export class PanierComponent implements OnInit {
  fullPrize: number;
  voyages: Voyage[];
  loadButton: any;
  connected: boolean;

  constructor(private connectionService: ConnectionService,
    private panierService: PanierService, private travelRowService: TravelRowService) { }

  ngOnInit() {
    if (localStorage.getItem('connecte') === 'true') {
      this.connected = true;
    } else {
      this.connected = false;
    }
    this.voyages = JSON.parse(localStorage.getItem('panier'));
    this.fullPrize = 0;
    for (let i = 0; i < this.voyages.length; i++) {
      this.fullPrize = this.fullPrize + this.voyages[i].prix;
    }
    console.log(this.voyages);
  }

  public changeList() {
    this.voyages = JSON.parse(localStorage.getItem('panier'));
    for (let i = 0; i < this.voyages.length; i++) {
      this.fullPrize = this.fullPrize + this.voyages[i].prix;
    }
  }

  pay() {
    if (localStorage.getItem('connecte') === 'true') {
      // payement autorisé
    } else {
      // pas connecté payement impossible
    }
  }

}
