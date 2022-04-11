import { AchatService } from './../../../services/achat.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Achat } from './../../../model/achat';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-edit-achat',
  templateUrl: './edit-achat.component.html',
  styleUrls: ['./edit-achat.component.css'],
})
export class EditAchatComponent implements OnInit {
  achat: Achat = new Achat();
  constructor(
    private aR: ActivatedRoute,
    private achatService: AchatService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id_note']) {
        this.achat = new Achat();
      } else {
        this.achatService.getById(params['id_achat']).subscribe((a) => {
          this.achat = new Achat(
            a.id_achat,
            a.id_client,
            a.id_produit,
            a.quantite
          );
        });
      }
    });
  }

  save() {
    if (this.achat.id_achat) {
      this.achatService.update(this.achat).subscribe(() => {
        this.router.navigateByUrl('/achat');
      });
    } else {
      this.achatService.create(this.achat).subscribe(() => {
        this.router.navigateByUrl('/achat');
      });
    }
  }
}
