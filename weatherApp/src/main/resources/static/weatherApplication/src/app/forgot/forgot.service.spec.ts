import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { HttpInterceptorService } from '../HttpInterceptorService';
import { LoginComponent } from '../login/login.component';
import { ForgotComponent } from './forgot.component';

import { ForgotService } from './forgot.service';

describe('ForgotService', () => {
  let service: ForgotService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [
        ForgotComponent,
     
         
      ],
      imports: [
        HttpClientModule,
    
         
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
    service = TestBed.inject(ForgotService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
