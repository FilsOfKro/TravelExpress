import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'environments/environment';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Observable';
import { Voyage } from '../voyage';
import { Airlines } from '../airlines';
import { AirportCity } from '../airportCity';
import { AirportByCities } from '../airportByCities';
const API_URL = environment.apiUrl;

@Injectable()
export class TravelRowService {
    constructor(private http: HttpClient) { }

    // API: GET /todos
    public getAirline(iata, icao): Observable<Airlines> {

        let params = new HttpParams();
        params = params.append('codeIataAirport', iata);
        params = params.append('codeIcaoAirport', icao);

        return this.http.get(API_URL + 'airports', { params: params }).map((response) => {
            const airline = response;
            console.log(airline);
            return airline;
        })
            .catch(this.handleError);

    }


    private handleError(error: Response | any) {
        console.error('ApiService::handleError', error);
        return Observable.throw(error);
    }

}
