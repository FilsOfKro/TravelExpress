import { Component, OnInit, Input } from '@angular/core';
import { Voyage } from '../../voyage';

@Component({
  selector: 'app-panier-ligne',
  templateUrl: './panier-ligne.component.html',
  styleUrls: ['./panier-ligne.component.css']
})
export class PanierLigneComponent implements OnInit {

  @Input() voyage: Voyage;
  constructor() { }

  ngOnInit() {
  }

  removeFromCart() {

  }

}
