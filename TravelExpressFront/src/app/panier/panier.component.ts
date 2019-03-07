import { Component, OnInit } from '@angular/core';
import { Voyage } from '../voyage';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent implements OnInit {
  fullPrize: number;
  voyages: Voyage[];
  loadButton: any;
  constructor() { }

  ngOnInit() {

  }

  pay() {

  }

}
