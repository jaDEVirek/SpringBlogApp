import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {RegisterComponent} from './auth/register/register.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {ServiceComponent} from './auth/service/service.component';
import {LoginComponent} from './auth/login/login.component';
import {RegisterSuccessComponent} from './auth/register-success/register-success.component';
import {Ng2Webstorage} from 'ngx-webstorage';
import {ApplicationRoutingModule} from './application-routing.module';
import {HeaderComponent} from './header/header.component';

// @ts-ignore
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
    ApplicationRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    Ng2Webstorage.forRoot(),

    RouterModule.forRoot([
        {path: 'register', component: RegisterComponent},
        {path: 'login', component: LoginComponent},
        {path: 'register-success', component: RegisterSuccessComponent}
      ]
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
