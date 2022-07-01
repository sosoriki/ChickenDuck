import { TestBed } from '@angular/core/testing';

import { WeatherResolverService } from './weather-resolver.service';

describe('WeatherResolverService', () => {
  let service: WeatherResolverService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WeatherResolverService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
