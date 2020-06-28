import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {AuthenticationService} from '../auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerPayload: RegisterPayload;
  registerForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private  authenticationService: AuthenticationService, private router: Router) {
    this.registerForm = this.formBuilder.group({
      userName: '',
      email: '',
      password: '',
      confirmPassword: ''
    });
    this.registerPayload = {
      userName: '',
      email: '',
      password: '',
      confirmPassword: ''
    };
  }

  ngOnInit(): void {
  }

  onSubmit(): void {

    this.authenticationService.register(this.registerPayload).subscribe(data => {
      console.log('Register - success');
      this.router.navigateByUrl('/register-success');
    }, error => {
      console.log('Register - failed ');
    });
  }
}
