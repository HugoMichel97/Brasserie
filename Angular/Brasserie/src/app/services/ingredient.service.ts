import { Injectable } from '@angular/core';
;
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Ingredient } from '../model/ingredient';

@Injectable({
  providedIn: 'root'
})
export class IngredientService {

  private static URL: string = 'http://localhost:8080/brasserie/api/ingredient';

  constructor(private http: HttpClient) {}

  public getAll(): Observable<any[]> {
    return this.http.get<any[]>(IngredientService.URL);
  }

  public get(id: number): Observable<any> {
    return this.http.get<any>(`${IngredientService.URL}/${id}`);
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<any>(`${IngredientService.URL}/${id}`);
  }

  public create(ingredient: Ingredient): Observable<any> {
    return this.http.post(IngredientService.URL, this.ingredientToJson(ingredient));
  }

  public update(ingredient: Ingredient): Observable<any> {
    console.log(this.ingredientToJson(ingredient));
    return this.http.put(
      `${IngredientService.URL}/${ingredient.id_ingredient}`,
      this.ingredientToJson(ingredient)
    );
  }

  private ingredientToJson(ingredient: Ingredient): any {
    let obj = {
      id: ingredient.id_ingredient,
      meteo: ingredient.nom,
      date: ingredient.stock,
      heure: ingredient.bieres,

    };
    return obj;
  }}

