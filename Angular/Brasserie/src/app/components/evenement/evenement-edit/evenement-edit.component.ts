import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Evenement } from 'src/app/model/evenement';
import { EvenementService } from 'src/app/services/evenements.service';

@Component({
  selector: 'app-evenement-edit',
  templateUrl: './evenement-edit.component.html',
  styleUrls: ['./evenement-edit.component.css']
})
export class EvenementEditComponent implements OnInit {

  evenement: Evenement = new Evenement();

  constructor(
    private aR: ActivatedRoute,
    private evenementService: EvenementService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.evenementService.get(params['id']).subscribe((result) => {
          this.evenement = result;
          console.log(result);
        });
      }
    });
  }

  save() {
    if (this.evenement.id) {
      this.evenementService.update(this.evenement).subscribe((result) => {
        this.goList();
      });
    } else {
      this.evenementService.create(this.evenement).subscribe((result) => {
        this.goList();
      });
    }
  }

  goList() {
    this.router.navigateByUrl('/evenement');
  }

}
