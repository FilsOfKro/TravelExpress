import { Component, OnInit } from '@angular/core';
import {PasswordModule} from 'primeng/password';
@Component({
  selector: 'app-newaccount',
  templateUrl: './newAccount.component.html',
  styleUrls: ['./newAccount.component.css']
})
export class NewAccountComponent implements OnInit {
  password: String;
  passwordDeux: String;

  constructor() { }

  ngOnInit() {
  }

  createAccount () {
    // connection de l'user à l'appli
  }
}
