import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'environments/environment';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Observable';
import { Voyage } from '../voyage';
import { AirportCity } from '../airportCity';
import { AirportByCities } from '../airportByCities';
const API_URL = environment.apiUrl;

@Injectable()
export class PanierService {
    constructor(private http: HttpClient) { }
    voyages: Voyage[] = [];


    addToListVoyage(voyage: Voyage) {
        this.voyages.push(voyage);
    }

    getListVoyage() {
        return this.voyages;
    }

    removeVoyage(voyage: Voyage) {
        const res = this.voyages.indexOf(this.voyages.find(voy => voy.regNumber === voyage.regNumber));
        if (res !== -1) {
            this.voyages.splice(res, 1);
        }
    }

}
