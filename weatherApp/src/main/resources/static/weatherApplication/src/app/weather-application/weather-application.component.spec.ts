import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WeatherApplicationComponent } from './weather-application.component';

describe('WeatherApplicationComponent', () => {
  let component: WeatherApplicationComponent;
  let fixture: ComponentFixture<WeatherApplicationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WeatherApplicationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WeatherApplicationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
