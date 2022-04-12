import { Component, OnInit } from '@angular/core';
import { Ingredient } from 'src/app/model/ingredient';
import { IngredientService } from 'src/app/services/ingredient.service';

@Component({
  selector: 'app-ingredient-list',
  templateUrl: './ingredient-list.component.html',
  styleUrls: ['./ingredient-list.component.css'],
})
export class IngredientListComponent implements OnInit {
  ingredient: Ingredient[] = [];
  constructor(private ingredientsService: IngredientService) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.ingredientsService.getAll().subscribe((result) => {
      this.ingredient = [];
      for (let i of result) {
        this.ingredient.push(new Ingredient(i.id_ingredient, i.nom, i.stock));
      }
    });
  }

  delete(id: number) {
    this.ingredientsService.delete(id).subscribe((noResult) => {
      this.list();
    });
  }
}
