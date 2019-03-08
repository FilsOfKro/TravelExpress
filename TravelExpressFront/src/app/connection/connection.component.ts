import { Component, OnInit } from '@angular/core';
import { ConnectionService } from './connection.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-connection',
  templateUrl: './connection.component.html',
  styleUrls: ['./connection.component.css'],
  providers: [ConnectionService]
})
export class ConnectionComponent implements OnInit {
  password: String;
  log: String;
  connected: boolean;
  constructor(private connectionService: ConnectionService, private router: Router) { }

  ngOnInit() {
    if (localStorage.getItem('connecte') === 'true') {
      this.connected = true;
    } else {
      this.connected = false;
    }
  }

  login() {
    // connection de l'user à l'appli
    this.connectionService.getConnect(this.log, this.password).subscribe(response => {
      console.log('vous etes connecté');
    });
    if (localStorage.getItem('connecte') === 'true') {
      this.connected = true;
    } else {
      this.connected = false;
    }
    this.router.navigate(['/search']);
  }

  disconnect(){
    localStorage.setItem('connecte', 'false');
    this.connected = false;
  }
}
