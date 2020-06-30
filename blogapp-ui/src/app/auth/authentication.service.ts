import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {LoginPayload} from './login-payload';
import {JwtAuthResponse} from './jwt-auth-response';
import {map} from 'rxjs/operators';
import {LocalStorageService} from 'ngx-webstorage';
import {RegisterPayload} from './RegisterPayload';

// @ts-ignore
@Injectable({
  providedIn: 'root'
})
// @ts-ignore
export class AuthenticationService {
  private url = 'http://localhost:8080/blogapp/auth';

  constructor(private httpClient: HttpClient, private localStorageService: LocalStorageService) {

  }

  register(registerPayload: RegisterPayload): Observable<any> {
    return this.httpClient.post(this.url + 'signUp', registerPayload);
  }

  login(loginPayload: LoginPayload): Observable<boolean> {
    return this.httpClient.post<JwtAuthResponse>(this.url + 'login', loginPayload)
      .pipe(map(data => {
        this.localStorageService.store(this.url + 'authenticationToken', data.authenticationToken);
        this.localStorageService.store(this.url + 'userName', data.userName);
        return true;
      }));
  }
}

