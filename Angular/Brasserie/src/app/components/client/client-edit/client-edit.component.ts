import { ClientService } from './../../../services/client.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from './../../../model/client';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-client-edit',
  templateUrl: './client-edit.component.html',
  styleUrls: ['./client-edit.component.css'],
})
export class ClientEditComponent implements OnInit {
  client: Client = new Client();
  cathegorie: string = '';

  constructor(
    private aR: ActivatedRoute,
    private clientService: ClientService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.clientService.get(params['id']).subscribe((result) => {
          this.client = result;
        });
      }
      if (params['cathegorie']) {
        this.cathegorie = params['cathegorie'];
        console.log(this.cathegorie);
      }
    });
  }
}
