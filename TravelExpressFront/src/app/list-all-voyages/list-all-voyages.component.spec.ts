import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListAllVoyagesComponent } from './list-all-voyages.component';

describe('ListAllVoyagesComponent', () => {
  let component: ListAllVoyagesComponent;
  let fixture: ComponentFixture<ListAllVoyagesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListAllVoyagesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListAllVoyagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
