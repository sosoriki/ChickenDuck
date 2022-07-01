import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { WeatherApplicationComponent } from './weather-application/weather-application.component';
import { ErrorComponent } from './error/error.component'; 
import { ProfileComponent } from './profile/profile.component';
import { ForgotComponent } from './forgot/forgot.component';
import { WeatherResolverService } from './weather-application/weather-resolver.service';


const routes: Routes = [
  {path:'',  component: LoginComponent},
  {path:'main',
  component: WeatherApplicationComponent,
  resolve:{addressdata: WeatherResolverService}
},
  {path:'logout', component: LoginComponent},
  {path:'register', component: RegisterComponent},
  {path:'error',component: ErrorComponent},
  {path:'profile',component: ProfileComponent},
  {path: 'forgot', component: ForgotComponent},
 
  ];
 

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }