import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {RegisterComponent} from './auth/register/register.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import { ServiceComponent } from './auth/service/service.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    HeaderComponent,
    LoginComponent,
    RegisterSuccessComponent,
    ServiceComponent
  ],
  imports: [
    BrowserModule,
    AplicationRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
        (path: 'register', component: RegisterComponent),
        (path: 'login', component: LoginComponent),
        (path: 'register-success', component: RegisterSuccessComponent),
      ]
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
