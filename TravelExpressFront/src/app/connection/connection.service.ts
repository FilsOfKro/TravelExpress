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
import { User } from '../user';
const API_URL = environment.apiUrl;

@Injectable()
export class ConnectionService {
    constructor(private http: HttpClient) { }
    connected: boolean;
    user: User;
    // API: GET /todos
    public getCreateAccount(nom, mdp): Observable<User> {

        let params = new HttpParams();
        params = params.append('username', nom);
        params = params.append('password', mdp);

        return this.http.post(API_URL + 'authentication/register', {'username': nom, 'password': mdp}).map((response) => {
            const user = response;
            console.log(user);
            this.connected = true;
            return user;
        })
            .catch(this.handleError);

    }

    public getConnect(namae, mdp): Observable<User> {
        console.log('nom', namae);
        console.log('mdp', mdp);
        let params = new HttpParams();
        params = params.append('username', namae);
        params = params.append('password', mdp);

        return this.http.post(API_URL + 'authentication', {'username': namae, 'password': mdp}).map((response) => {
            const user = response;
            this.connected = true;
            console.log(user);
            localStorage.setItem('connecte', 'true');

            return user;
        })
            .catch(this.handleError);

    }

    public Deconnect() {
        this.user = undefined;
        localStorage.setItem('connecte', 'false');
    }


    private handleError(error: Response | any) {
        console.error('ApiService::handleError', error);
        return Observable.throw(error);
    }

    public isConnected() {
        return this.connected;
    }

}
