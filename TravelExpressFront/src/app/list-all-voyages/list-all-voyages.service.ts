import { Injectable } from '@angular/core';
import { ListAllVoyagesComponent } from './list-all-voyages.component';

import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { map, catchError, tap } from 'rxjs/operators';

@Injectable()
export class ListAllListAllVoyagesComponentService {

  constructor(private http: HttpClient) { }

}
