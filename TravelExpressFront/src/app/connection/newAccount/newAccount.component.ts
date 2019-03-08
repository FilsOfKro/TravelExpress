import { Component, OnInit } from '@angular/core';
import { PasswordModule } from 'primeng/password';
import { ConnectionService } from '../connection.service';
import { Router } from '@angular/router';
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
  displayWarning: boolean;
  constructor(private connectionService: ConnectionService, private router: Router) { }

  ngOnInit() {
    this.displayWarning = false;
  }

  createAccount() {
    // connection de l'user à l'appli
    if (this.password === this.passwordDeux) {

      this.connectionService.getCreateAccount(this.login, this.password).subscribe(response => {
        console.log('vous etes connecté');
      });
      this.router.navigate(['/login']);
    } else {
      this.displayWarning = true;
    }
  }
}
