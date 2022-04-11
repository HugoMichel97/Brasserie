import { ClientService } from './../../../service/client.service';
import { Client } from './../../../model/client';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-client-brasseur-edit',
  templateUrl: './client-brasseur-edit.component.html',
  styleUrls: ['./client-brasseur-edit.component.css'],
})
export class ClientBrasseurEditComponent implements OnInit {
  client: Client = new Client();

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
    });
  }

  // save() {
  //   if (this.client.id) {
  //     this.clientService.updateStatut(this.client).subscribe((result) => {
  //       this.goList();
  //     });
  //   }
  // }

  goList() {
    this.router.navigateByUrl('/brasseur/clients');
  }
}
