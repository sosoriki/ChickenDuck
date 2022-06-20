import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
 
// import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { WeatherApplicationComponent } from './weather-application/weather-application.component';
 

const routes: Routes = [
  {path: '',  component: LoginComponent},
  {path:'main',component:WeatherApplicationComponent,}
  ];
 

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }