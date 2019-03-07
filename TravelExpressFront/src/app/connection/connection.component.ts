import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-connection',
  templateUrl: './connection.component.html',
  styleUrls: ['./connection.component.css']
})
export class ConnectionComponent implements OnInit {
  password: String;
  constructor() { }

  ngOnInit() {
  }
  login() {
    // connection de l'user à l'appli
  }
}
