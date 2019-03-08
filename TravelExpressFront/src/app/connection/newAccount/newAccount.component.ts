import { Component, OnInit } from '@angular/core';
import {PasswordModule} from 'primeng/password';
import { ConnectionService } from '../connection.service';
@Component({
  selector: 'app-newaccount',
  templateUrl: './newAccount.component.html',
  styleUrls: ['./newAccount.component.css'],
  providers: [ConnectionService]
})
export class NewAccountComponent implements OnInit {
  password: String;
  passwordDeux: String;
  login: String;
  constructor(private connectionService: ConnectionService) { }

  ngOnInit() {
  }

  createAccount () {
    // connection de l'user à l'appli
    this.connectionService.getCreateAccount(this.login, this.password).subscribe(response => {
      console.log('vous etes connecté');
    });
  }
}
