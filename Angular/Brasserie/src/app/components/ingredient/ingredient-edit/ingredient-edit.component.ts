import { Component, OnInit } from '@angular/core';
import { Ingredient } from 'src/app/model/ingredient';
import { ActivatedRoute, Router } from '@angular/router';
import { IngredientService } from 'src/app/services/ingredient.service';

@Component({
  selector: 'app-ingredient-edit',
  templateUrl: './ingredient-edit.component.html',
  styleUrls: ['./ingredient-edit.component.css']
})
export class IngredientEditComponent implements OnInit {

  ingredient : Ingredient = new Ingredient();

  constructor(
    private aR: ActivatedRoute,
    private ingredientService: IngredientService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.ingredientService.get(params['id']).subscribe((result) => {
          this.ingredient = result;
          console.log(result);
        });
      }
    });
  }

  save() {
    if (this.ingredient.id_ingredient) {
      this.ingredientService.update(this.ingredient).subscribe((result) => {
        this.goList();
      });
    } else {
      this.ingredientService.create(this.ingredient).subscribe((result) => {
        this.goList();
      });
    }
  }

  goList() {
    this.router.navigateByUrl('/ingredient');
  }

}
