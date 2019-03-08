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

  }
}
