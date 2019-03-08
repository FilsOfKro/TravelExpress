import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TravelRowComponent } from './travel-row.component';

describe('TravelRowComponent', () => {
  let component: TravelRowComponent;
  let fixture: ComponentFixture<TravelRowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TravelRowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TravelRowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
