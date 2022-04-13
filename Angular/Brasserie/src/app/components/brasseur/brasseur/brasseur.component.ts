import { faPencil } from '@fortawesome/free-solid-svg-icons';
import { BrasseurService } from './../../../services/brasseur.service';
import { Brasseur } from './../../../model/brasseur';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-brasseur',
  templateUrl: './brasseur.component.html',
  styleUrls: ['./brasseur.component.css'],
})
export class BrasseurComponent implements OnInit {
  brasseur: Brasseur = new Brasseur();
  iconEdit = faPencil;

  constructor(private brasseurService: BrasseurService) {}

  ngOnInit(): void {
    this.brasseurService.get(1).subscribe((result) => {
      this.brasseur = result;
    });
  }
}
