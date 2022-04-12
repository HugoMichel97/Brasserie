import { ClientService } from './../../../services/client.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Client } from './../../../model/client';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-password-edit',
  templateUrl: './password-edit.component.html',
  styleUrls: ['./password-edit.component.css'],
})
export class PasswordEditComponent implements OnInit {
  client: Client = new Client();
  newPassword: string | undefined;
  confirmPassword: string | undefined;

  constructor(
    private clientService: ClientService,
    private aR: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.clientService.get(params['id']).subscribe((result) => {
          this.client = result;
        });
      }
    });
  }

  save(value: string) {
    if (this.client.id) {
      this.clientService
        .updatePassword(this.client, value)
        .subscribe((result) => {
          this.goList();
        });
    }
  }

  goList() {
    this.router.navigateByUrl('/client');
  }
}
