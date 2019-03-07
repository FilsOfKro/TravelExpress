import { Component, OnInit, Input } from '@angular/core';
import { Voyage } from '../voyage';

@Component({
  selector: 'app-travel-row',
  templateUrl: './travel-row.component.html',
  styleUrls: ['./travel-row.component.css']
})
export class TravelRowComponent implements OnInit {
  @Input() voyage: Voyage[];
  constructor() { }

  ngOnInit() {
  }

}
