import { faCcPaypal } from '@fortawesome/free-brands-svg-icons';
import { Reglement } from './../../../model/enum/reglement';
import { ReglementService } from './../../../services/reglement.service';
import { InfoReglement } from './../../../model/info-reglement';
import { ClientService } from './../../../services/client.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from './../../../model/client';
import { Component, OnInit } from '@angular/core';
import { faCreditCard } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-client-edit',
  templateUrl: './client-edit.component.html',
  styleUrls: ['./client-edit.component.css'],
})
export class ClientEditComponent implements OnInit {
  client: Client = new Client();
  cathegorie: string = '';
  addReg: boolean = false;
  reglement: InfoReglement = new InfoReglement();
  modeReg = Reglement;
  iconCB = faCreditCard;
  iconPayPal = faCcPaypal;

  constructor(
    private aR: ActivatedRoute,
    private clientService: ClientService,
    private regService: ReglementService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.clientService.get(params['id']).subscribe((result) => {
          this.client = result;
          this.reglement.client = this.client;
        });
      }
      if (params['cathegorie']) {
        this.cathegorie = params['cathegorie'];
      }
      if (params['idReg']) {
        this.regService.get(params['idReg']).subscribe((result) => {
          this.reglement = result;
        });
      } else {
        this.addReg = true;
      }
    });
  }

  save() {
    if (this.cathegorie === 'mail') {
      this.clientService.update(this.client).subscribe(() => {
        localStorage.clear();
        this.router.navigateByUrl('/login');
      });
    } else {
      this.clientService.update(this.client).subscribe(() => {
        this.goClient();
      });
    }
  }

  saveReglement() {
    if (this.reglement.id) {
      this.regService.update(this.reglement).subscribe(() => {
        this.goClient();
      });
    } else {
      this.regService.create(this.reglement).subscribe(() => {
        this.goClient();
      });
    }
  }

  goClient() {
    this.router.navigateByUrl('/client/' + this.client.id);
  }
}
