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
  airline: Airlines = {

    nameAirline : '',
    codeIso2Country: '',
  };

  constructor(private panierService: PanierService, private travelRowService: TravelRowService) { }

  ngOnInit() {
    console.log(this.airline);
    console.log('iata airport', this.voyage.airlineIata);

    this.travelRowService.getAirline(this.voyage.airlineIata).subscribe(response => {
      console.log('iata airport', this.voyage.airlineIata);
      this.airline = response;
    });
  }

  removeFromCart() {
    this.panierService.removeVoyage(this.voyage);
    this.majListPanier.emit('maj');
  }

}
