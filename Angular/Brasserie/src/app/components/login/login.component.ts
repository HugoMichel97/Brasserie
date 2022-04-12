import { Router } from '@angular/router';
import { AuthentificationService } from './../../services/authentification.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  mail: string = '';
  password: string = '';
  err: boolean = false;

  constructor(
    private authService: AuthentificationService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  check() {
    //controle login/password
    this.authService.authentication(this.mail, this.password).subscribe({
      next: (value: string) => {
        localStorage.setItem('login', this.mail);
        localStorage.setItem(
          'token',
          'Basic ' + btoa(this.mail + ':' + this.password)
        );
        localStorage.setItem('role', value);
        this.err = false;
      },
      error: (error: any) => {
        console.log(error);
        this.err = true;
      },
    });
  }
}
