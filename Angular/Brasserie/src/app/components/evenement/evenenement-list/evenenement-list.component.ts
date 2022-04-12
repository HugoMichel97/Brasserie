import { Component, OnInit } from '@angular/core';
import { Evenement } from 'src/app/model/evenement';
import { EvenementService } from 'src/app/services/evenements.service';

@Component({
  selector: 'app-evenenement-list',
  templateUrl: './evenenement-list.component.html',
  styleUrls: ['./evenenement-list.component.css']
})
export class EvenenementListComponent implements OnInit {

  evenement : Evenement [] = [];
  constructor(private evenementsService : EvenementService) { }

  ngOnInit(): void {
  }

  list() {
    this.evenementsService.getAll().subscribe((result) => {
      this.evenement = result;
      console.log(this.evenement)
    });
  }

  delete(id: number) {
    this.evenementsService.delete(id).subscribe((noResult) => {
      this.list();
    });
  }

}
