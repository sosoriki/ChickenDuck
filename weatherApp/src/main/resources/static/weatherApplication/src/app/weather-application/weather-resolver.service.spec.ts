import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { AppRoutingModule } from '../app-routing.module';
import { HttpInterceptorService } from '../HttpInterceptorService';
import { LoginComponent } from '../login/login.component';
import { WeatherApplicationComponent } from './weather-application.component';

import { WeatherResolverService } from './weather-resolver.service';

describe('WeatherResolverService', () => {
  let service: WeatherResolverService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [
        WeatherApplicationComponent,
     
         
      ],
      imports: [
        HttpClientModule,
        AppRoutingModule,
    
         
      ],
      providers: [{
        provide: HTTP_INTERCEPTORS,
        useClass: HttpInterceptorService,
        multi: true
      },LoginComponent],
    })
    .compileComponents();
  });

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WeatherResolverService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
