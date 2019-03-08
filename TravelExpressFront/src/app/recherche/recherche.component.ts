import { Component, OnInit } from '@angular/core';
import { RechercheService } from './recherche.service';

import { Voyage } from '../voyage';
import { AirportCity } from '../airportCity';

const message = 'Veuillez choisir un aéroport';

@Component({
  selector: 'app-recherche',
  templateUrl: './recherche.component.html',
  styleUrls: ['./recherche.component.css'],
  providers: [RechercheService]
})
export class RechercheComponent implements OnInit {
  departCity: String = '';
  arriveeCity: String = '';
  arriveeId: String = message;
  departId: String = message;
  voyages: Voyage[];
  departureAirports: AirportCity[];
  arrivalAirports: AirportCity[];

  constructor(private rechercheService: RechercheService) { }

  ngOnInit() {
  }

  departCityChanged() {
    if (this.departCity.length >= 3) {
      this.rechercheService.getIdCity(this.departCity).subscribe(response => {
        this.departureAirports = response;
      });
    }
  }

  arrivalCityChanged() {
    if (this.arriveeCity.length >= 3) {
      this.rechercheService.getIdCity(this.arriveeCity).subscribe(response => {
        this.arrivalAirports = response;
      });
    }
  }

  recherche() {
      if (this.departId !== undefined && this.arriveeId !== undefined) {
        if (this.departId !== message && this.arriveeId !== message) {
          this.rechercheService.getSearchedVoyages(this.arriveeId, this.departId ).subscribe(ret => {
            this.voyages = ret;
          });
        }
      }
    }
}
