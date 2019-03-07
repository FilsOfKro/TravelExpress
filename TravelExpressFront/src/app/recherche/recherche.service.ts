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
export class RechercheService {
    constructor(private http: HttpClient) { }

    // API: GET /todos
    public getSearchedVoyages(depart, arrivee): Observable<Voyage[]> {

        let params = new HttpParams();
        params = params.append('arrivalAirportId', depart);
        params = params.append('departureAirportId', arrivee);

        return this.http.get(API_URL + 'routes', { params: params }).map((response) => {
            const voyages = response;
            console.log(voyages);
            return voyages;
        })
            .catch(this.handleError);

    }

    public getIdCity(nom): Observable<AirportCity[]> {


        let params = new HttpParams();
        params = params.append('input', nom);
        return this.http.get(API_URL + 'autocomplete', { params: params }).map((response) => {
            const id = response;
            console.log(id);
            return id;
        })
            .catch(this.handleError);

    }


    private handleError(error: Response | any) {
        console.error('ApiService::handleError', error);
        return Observable.throw(error);
    }

}
