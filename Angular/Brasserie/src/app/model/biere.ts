import { Snack } from './snack';
import { Note } from './note';
import { Produit } from './produit';
import { Ingredient } from './ingredient';
export class Biere extends Produit {
  public constructor(
    id?: number | undefined,
    nom?: string | undefined,
    description?: string | undefined,
    prix?: number | undefined,
    stock?: number | undefined,
    points?: number | undefined,
    private _notes?: Note[] | undefined,
    private _suggestions?: Snack[] | undefined,
    private _recette?: Ingredient[] | undefined
  ) {
    super(id, nom, description, prix, stock, points);
  }

  public get notes(): Note[] | undefined {
    return this._notes;
  }

  public set notes(value: Note[] | undefined) {
    this._notes = value;
  }

  public get suggestions(): Snack[] | undefined {
    return this._suggestions;
  }

  public set suggestions(value: Snack[] | undefined) {
    this._suggestions = value;
  }

  public get recette(): Ingredient[] | undefined {
    return this._recette;
  }

  public set recette(value: Ingredient[] | undefined) {
    this._recette = value;
  }
}
