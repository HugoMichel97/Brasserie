import { StatutCommande } from './../../model/enum/statut-commande';
import { debounceTime, map, Observable } from 'rxjs';
import { Router } from '@angular/router';
import { ClientService } from './../../services/client.service';
import { Client } from 'src/app/model/client';
import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import * as moment from 'moment';

@Component({
  selector: 'app-create-compte',
  templateUrl: './create-compte.component.html',
  styleUrls: ['./create-compte.component.css'],
})
export class CreateCompteComponent implements OnInit {
  form!: FormGroup;

  constructor(private clientService: ClientService, private router: Router) {
    this.form = new FormGroup({
      telephone: new FormControl('', Validators.pattern(/^0|(\+33)[1-9]$/)),
      emailPasswordGroup: new FormGroup(
        {
          email: new FormControl(
            '',
            [Validators.required, Validators.email],
            this.checkEmail()
          ),
          passwordGroup: new FormGroup(
            {
              password: new FormControl('', [
                Validators.required,
                Validators.pattern(
                  /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[*_!@-\\.])([a-zA-Z0-9*_!@-\\.]{5,25})$/
                ),
              ]),
              confirm: new FormControl('', Validators.required),
            },
            this.passwordAndConfirmEquals
          ),
        },
        this.mailAndPasswordNotEquals
      ),
      nom: new FormControl('', Validators.required),
      prenom: new FormControl('', Validators.required),
      naissance: new FormControl('', Validators.required),
    });
  }

  checkEmail(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.clientService.getByMail(control.value).pipe(
        debounceTime(1000),
        map((result) => {
          return result ? { emailExist: true } : null;
        })
      );
    };
  }

  mailAndPasswordNotEquals(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    if (group.get('email')?.invalid || group.get('passwordGroup')?.invalid) {
      return null;
    }
    return group.get('email')?.value ==
      group.get('passwordGroup.password')?.value
      ? { mailAndPasswordEquals: true }
      : null;
  }

  passwordAndConfirmEquals(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    if (group.get('password')?.errors) {
      return null;
    }
    return group.get('password')?.value == group.get('confirm')?.value
      ? null
      : { passwordAndConfirmNotEquals: true };
  }

  ngOnInit(): void {}

  create() {
    let client = {
      nom: this.form.get('nom')?.value,
      prenom: this.form.get('prenom')?.value,
      naissance: this.form.get('naissance')?.value,
      tel: this.form.get('telephone')?.value,
      mail: this.form.get('emailPasswordGroup.email')?.value,
      password: this.form.get('emailPasswordGroup.passwordGroup.password')
        ?.value,
      fidelite: 0,
      statut: StatutCommande.vide,
    };

    this.clientService.create(client).subscribe(() => {
      this.router.navigateByUrl('/login');
    });
  }
}
