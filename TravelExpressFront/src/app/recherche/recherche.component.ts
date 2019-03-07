import { Component, OnInit } from '@angular/core';
import { RechercheService } from './recherche.service';

import { Voyage } from '../voyage';

@Component({
  selector: 'app-recherche',
  templateUrl: './recherche.component.html',
  styleUrls: ['./recherche.component.css'],
  providers: [RechercheService]
})
export class RechercheComponent implements OnInit {
  departCity: String = '';
  arriveeCity: String = '';
  arriveeId: String;
  departId: String;
  voyages: Voyage[];

  constructor(private rechercheService: RechercheService) { }

  ngOnInit() {
  }

  recherche() {

    this.rechercheService.getIdCity(this.departCity).subscribe(response => {

      this.departId = response[0].codeIcaoAirport;
      console.log(this.departId);
      if (this.departId !== undefined) {
        this.rechercheService.getIdCity(this.arriveeCity).subscribe(res => {

          this.arriveeId = res[0].codeIcaoAirport;
          console.log(this.arriveeId);
          if (this.arriveeId !== undefined) {
            this.rechercheService.getSearchedVoyages(this.arriveeId, this.departId ).subscribe(ret => {

              this.voyages = ret;
            });

          }
        });
      }

    });
  }
}
