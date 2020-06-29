import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {LoginPayload} from './login-payload';


// @ts-ignore
@Injectable({
  providedIn: 'root'
})
// @ts-ignore
export class AuthenticationService {
  private url = 'http://localhost:8080/blogapp/auth';

  constructor(private httpClient: HttpClient) {

  }

  register(registerPayload: RegisterPayload): Observable<any> {
    return this.httpClient.post(this.url + 'signUp', registerPayload);
  }

  login(loginPayload: LoginPayload) {
    this.httpClient.post(this.url + 'login', loginPayload);
  }
}

