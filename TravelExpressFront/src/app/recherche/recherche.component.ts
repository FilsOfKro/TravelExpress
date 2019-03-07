import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-recherche',
  templateUrl: './recherche.component.html',
  styleUrls: ['./recherche.component.css']
})
export class RechercheComponent implements OnInit {
  departCity: String;
  arriveeCity: String;

  constructor() { }

  ngOnInit() {
  }

  recherche() {
    console.log('event rechercher');
    // redirection vers listallvoyages component mais avec les params du tri pour que celui ci soit effectué
  }
}
