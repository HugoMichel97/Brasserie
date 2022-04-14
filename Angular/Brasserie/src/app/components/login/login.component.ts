import { BrasseurService } from './../../services/brasseur.service';
import { ClientService } from './../../services/client.service';
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
    private clientService: ClientService,
    private brasseurService: BrasseurService,
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
        if (value == 'client') {
          this.clientService.getByMail(this.mail).subscribe((result) => {
            localStorage.setItem('id', `${result.id}`);
          });
        } else if (value == 'brasseur') {
          this.brasseurService.getByMail(this.mail).subscribe((result) => {
            localStorage.setItem('id', `${result.id}`);
          });
        }
        this.router.navigateByUrl('/index');
        this.err = false;
        this.router.navigateByUrl('');
      },
      error: (error: any) => {
        this.err = true;
      },
    });
  }
}
