import { Achat } from './../../../model/achat';
import { AchatService } from './../../../services/achat.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-achat',
  templateUrl: './achat.component.html',
  styleUrls: ['./achat.component.css'],
})
export class AchatComponent implements OnInit {
  achats: Achat[] = [];
  constructor(private achatService: AchatService) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.achatService.getAll().subscribe((result) => {
      this.achats = [];
      for (let a of result) {
        this.achats.push(
          new Achat(a.id_achat, a.id_client, a.id_produit, a.quantite)
        );
      }
    });
  }

  delete(id: number) {
    this.achatService.delete(id).subscribe((ok) => {
      this.list();
    });
  }
}
