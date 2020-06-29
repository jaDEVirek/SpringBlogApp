import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {LoginPayload} from '../login-payload';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  loginPayload: LoginPayload;

  constructor(private authenticationService: AuthenticationService) {
    this.loginForm = new FormGroup({
      userName: new FormControl(),
      password: new FormControl()
    });
  }

  ngOnInit(): void {
  }

  /**
   * passing values to the backend
   */
  onSubmit(): void {
    this.loginPayload.userName = this.loginForm.get('userName').value;
    this.loginPayload.password = this.loginForm.get('password').value;

    this.authenticationService.login(this.loginPayload);
  }
}
