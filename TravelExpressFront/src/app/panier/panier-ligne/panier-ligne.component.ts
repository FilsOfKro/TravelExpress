import { Component, Input, EventEmitter, Output, OnInit } from '@angular/core';
import { Voyage } from '../../voyage';
import { PanierService } from '../panier.service';
import { TravelRowService } from '../../travel-row/travelRow.service';
import { Airlines } from '../../airlines';

@Component({
  selector: 'app-panier-ligne',
  templateUrl: './panier-ligne.component.html',
  styleUrls: ['./panier-ligne.component.css'],
  providers: [PanierService, TravelRowService]
})
export class PanierLigneComponent implements OnInit {
  @Input() voyage: Voyage;
  @Output() majListPanier: EventEmitter<any> = new EventEmitter<any>();
  airline: Airlines;

  constructor(private panierService: PanierService, private travelRowService: TravelRowService) { }

  ngOnInit() {

    this.travelRowService.getAirline(this.voyage.departureIata, this.voyage.departureIcao).subscribe(response => {
      this.airline = response;
    });
  }

  removeFromCart() {
    this.panierService.removeVoyage(this.voyage);
  }

}
