import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Voyage } from '../voyage';

@Component({
  selector: 'app-list-all-voyages',
  templateUrl: './list-all-voyages.component.html',
  styleUrls: ['./list-all-voyages.component.css'],
})
export class ListAllVoyagesComponent implements OnInit {
  voyages: Voyage[];

  constructor() { }

  ngOnInit() {

    this.voyages = [
      {departureIata: 'departueiata',
        departureIcao: 'departureicao',
        departureTerminal: 'departuere terminal',
        departureTime: 'departureTime',
        arrivalIata: 'arivalIata',
        arrivalIcao: 'arrivalIcao',
        arrivalTerminal: 'arrivalTerminal',
        arrivalTime: 'arrivalTime',
        airlineIata: 'airlineIata',
        airlineIcao: 'airlineIcao',
        flightNumber: 'flightnumber',
        regNumber: 5}
      ];

  }
}
