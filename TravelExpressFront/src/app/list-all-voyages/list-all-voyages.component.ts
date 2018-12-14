import { Component, OnInit } from '@angular/core';
import { Voyage } from '../voyage';

@Component({
  selector: 'app-list-all-voyages',
  templateUrl: './list-all-voyages.component.html',
  styleUrls: ['./list-all-voyages.component.css']
})
export class ListAllVoyagesComponent implements OnInit {
  voyages:Voyage[];
  constructor() { }

  ngOnInit() {
    this.voyages = [{dateDepart: "01/08/2018", dateArrive: "08/12/2148", lieuDepart:"ici", lieuArrive:"labas",locomotion:"voiture"}];
    this.voyages.push({dateDepart: "01/08/2018", dateArrive: "08/12/2148", lieuDepart:"ici", lieuArrive:"labas",locomotion:"voiture"});
    this.voyages.push({dateDepart: "01/08/2018", dateArrive: "08/12/2148", lieuDepart:"ici", lieuArrive:"labas",locomotion:"voiture"});
    this.voyages.push({dateDepart: "01/08/2018", dateArrive: "08/12/2148", lieuDepart:"ici", lieuArrive:"labas",locomotion:"voiture"});
    this.voyages.push({dateDepart: "01/08/2018", dateArrive: "08/12/2148", lieuDepart:"ici", lieuArrive:"labas",locomotion:"voiture"});
    this.voyages.push({dateDepart: "01/08/2018", dateArrive: "08/12/2148", lieuDepart:"ici", lieuArrive:"labas",locomotion:"voiture"});
    this.voyages.push({dateDepart: "01/08/2018", dateArrive: "08/12/2148", lieuDepart:"ici", lieuArrive:"labas",locomotion:"voiture"});
    this.voyages.push({dateDepart: "01/08/2018", dateArrive: "08/12/2148", lieuDepart:"ici", lieuArrive:"labas",locomotion:"voiture"});
    this.voyages.push({dateDepart: "01/08/2018", dateArrive: "08/12/2148", lieuDepart:"ici", lieuArrive:"labas",locomotion:"voiture"});
    this.voyages.push({dateDepart: "01/08/2018", dateArrive: "08/12/2148", lieuDepart:"ici", lieuArrive:"labas",locomotion:"voiture"});
    this.voyages.push({dateDepart: "01/08/2018", dateArrive: "08/12/2148", lieuDepart:"ici", lieuArrive:"labas",locomotion:"voiture"});
    this.voyages.push({dateDepart: "01/08/2018", dateArrive: "08/12/2148", lieuDepart:"ici", lieuArrive:"labas",locomotion:"voiture"});

  }

}
