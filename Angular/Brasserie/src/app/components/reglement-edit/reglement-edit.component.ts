import { Reglement } from './../../model/enum/reglement';
import { InfoReglement } from './../../model/info-reglement';
import { ReglementService } from 'src/app/services/reglement.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-reglement-edit',
  templateUrl: './reglement-edit.component.html',
  styleUrls: ['./reglement-edit.component.css']
})
export class ReglementEditComponent implements OnInit {

  reglement: InfoReglement = new InfoReglement();

  moyens = Reglement;




  constructor(
    private aR: ActivatedRoute,
    private reglementService: ReglementService,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.reglementService.get(params['id']).subscribe((result) => {
          this.reglement = result;

        });
      }
    });
  }

  save() {
    if (this.reglement.id) {
      this.reglementService.update(this.reglement).subscribe((result) => {
        this.goList();
      });
    } else {
      this.reglementService.create(this.reglement).subscribe((result) => {
        this.goList();
      });
    }
  }

  goList() {
    this.router.navigateByUrl('/reglement');
  }
}
