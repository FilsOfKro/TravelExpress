import { Component, OnInit, Input } from '@angular/core';
import { Voyage } from '../voyage';
import { Airlines } from '../airlines';
import { TravelRowService } from './travelRow.service';
import { PanierService } from '../panier/panier.service';
@Component({
  selector: 'app-travel-row',
  templateUrl: './travel-row.component.html',
  styleUrls: ['./travel-row.component.css'],
  providers: [TravelRowService, PanierService]

})
export class TravelRowComponent implements OnInit {
  @Input() voyage: Voyage;
  @Input() depart: String;
  @Input() arrivee: String;
  airline: Airlines;
  showVoyage: any;

  constructor(private travelRowService: TravelRowService, private panierService: PanierService) { }

  ngOnInit() {
    this.travelRowService.getAirline(this.voyage.departureIata, this.voyage.departureIcao).subscribe(response => {
      this.airline = response;
    });
    this.voyage.prix = this.voyage.distance / 2;

  }

  addToCart() {
    let papa = JSON.parse(localStorage.getItem('panier'));
    if (papa === null) {
      papa = [];

    }
    papa.push(this.voyage);
    localStorage.setItem('panier', JSON.stringify(papa));
    this.panierService.addToListVoyage(this.voyage);
    console.log('panier', localStorage.getItem('panier'));
  }

}
