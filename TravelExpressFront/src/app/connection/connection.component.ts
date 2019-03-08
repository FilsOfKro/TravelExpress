import { Component, OnInit } from '@angular/core';
import { ConnectionService } from './connection.service';

@Component({
  selector: 'app-connection',
  templateUrl: './connection.component.html',
  styleUrls: ['./connection.component.css'],
  providers: [ConnectionService]
})
export class ConnectionComponent implements OnInit {
  password: String;
  constructor(private connectionService: ConnectionService) { }

  ngOnInit() {
  }
  login() {
    // connection de l'user à l'appli
    this.connectionService.getCreateAccount(this.login, this.password).subscribe(response => {
      console.log('vous etes connecté');
    });
  }
}
