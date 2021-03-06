import { BrasseurService } from './../../../services/brasseur.service';
import { Brasseur } from './../../../model/brasseur';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-brasseur-edit',
  templateUrl: './brasseur-edit.component.html',
  styleUrls: ['./brasseur-edit.component.css'],
})
export class BrasseurEditComponent implements OnInit {
  brasseur: Brasseur = new Brasseur();
  cathegorie: string = '';
  newPassword: string | undefined;
  confirmPassword: string | undefined;

  constructor(
    private aR: ActivatedRoute,
    private brasseurService: BrasseurService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.brasseurService.get(params['id']).subscribe((result) => {
          this.brasseur = result;
        });
      }
      if (params['cathegorie']) {
        this.cathegorie = params['cathegorie'];
      }
    });
  }

  save() {
    if (this.cathegorie === 'mail') {
      this.brasseurService.update(this.brasseur).subscribe(() => {
        localStorage.clear();
        this.router.navigateByUrl('/login');
      });
    } else {
      this.brasseurService.update(this.brasseur).subscribe(() => {
        this.goBrasseur();
      });
    }
  }

  savePassword(value: string) {
    this.brasseurService.updatePassword(this.brasseur, value).subscribe(() => {
      localStorage.clear();
      this.router.navigateByUrl('/login');
    });
  }

  goBrasseur() {
    this.router.navigateByUrl('/brasseur/info/' + this.brasseur.id);
  }
}
