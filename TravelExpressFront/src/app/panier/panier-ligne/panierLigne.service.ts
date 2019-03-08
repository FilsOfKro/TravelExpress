import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'environments/environment';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Observable';
import { Voyage } from '../../voyage';
import { AirportCity } from '../../airportCity';
import { AirportByCities } from '../../airportByCities';
const API_URL = environment.apiUrl;

@Injectable()
export class PanierLigneService {
    constructor(private http: HttpClient) { }


}
