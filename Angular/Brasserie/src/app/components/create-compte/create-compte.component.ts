import { Router } from '@angular/router';
import { ClientService } from './../../services/client.service';
import { Client } from 'src/app/model/client';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-create-compte',
  templateUrl: './create-compte.component.html',
  styleUrls: ['./create-compte.component.css'],
})
export class CreateCompteComponent implements OnInit {
  confirmPassword: string = '';
  client: Client = new Client();

  constructor(private clientService: ClientService, private router: Router) {}

  ngOnInit(): void {}

  create() {
    this.clientService.create(this.client).subscribe(() => {
      this.router.navigateByUrl('/login');
    });
  }
}
