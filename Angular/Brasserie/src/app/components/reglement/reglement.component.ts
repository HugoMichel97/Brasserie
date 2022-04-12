import { Reglement } from './../../model/enum/reglement';
import { InfoReglement } from './../../model/info-reglement';
import { Component, OnInit } from '@angular/core';
import { ReglementService } from 'src/app/services/reglement.service';
@Component({
  selector: 'app-reglement',
  templateUrl: './reglement.component.html',
  styleUrls: ['./reglement.component.css']
})
export class ReglementComponent implements OnInit {

  reglements: InfoReglement[] = [];
  mode = Reglement;
  id: number = 2;
  constructor(private reglementService: ReglementService) {}

  ngOnInit(): void {
    this.list(this.id)
  }

  list(id: number) {
    this.reglementService.get(id).subscribe((result) => {
      this.reglements.push(result);
      console.log(this.reglements)
    });
  }

  delete(id: number) {
    this.reglementService.delete(id).subscribe((noResult) => {
      this.list(id);
    });
  }
}

