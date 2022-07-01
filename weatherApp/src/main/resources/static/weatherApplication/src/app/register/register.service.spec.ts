import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { HttpInterceptorService } from '../HttpInterceptorService';
import { LoginComponent } from '../login/login.component';
import { RegisterComponent } from './register.component';

import { RegisterService } from './register.service';

describe('RegisterService', () => {
  let service: RegisterService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [
        RegisterComponent,
     
         
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
    service = TestBed.inject(RegisterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
