import { Component, OnInit } from '@angular/core';
import { Evenement } from 'src/app/model/evenement';
import { EvenementService } from 'src/app/services/evenements.service';

@Component({
  selector: 'app-evenenement-list',
  templateUrl: './evenenement-list.component.html',
  styleUrls: ['./evenenement-list.component.css'],
})
export class EvenenementListComponent implements OnInit {
  evenement: Evenement[] = [];
  constructor(private evenementsService: EvenementService) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.evenementsService.getAll().subscribe((result) => {
      this.evenement = [];
      for (let e of result) {
        this.evenement.push(
          new Evenement(
            e.id,
            e.date,
            e.heure,
            e.libelle,
            e.prix,
            e.ptsRequis,
            e.description,
            e.nbPlaces
          )
        );
      }
    });
  }

  delete(id: number) {
    this.evenementsService.delete(id).subscribe((noResult) => {
      this.list();
    });
  }
}
