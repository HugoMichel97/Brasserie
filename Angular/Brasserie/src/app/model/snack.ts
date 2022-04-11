import { Biere } from './biere';
import { Produit } from './produit';
export class Snack extends Produit {
  public constructor(
    id?: number | undefined,
    nom?: string | undefined,
    description?: string | undefined,
    prix?: number | undefined,
    stock?: number | undefined,
    points?: number | undefined,
    private _bieres?: Biere[] | undefined
  ) {
    super(id, nom, description, prix, stock, points);
  }

  public get bieres(): Biere[] | undefined {
    return this.bieres;
  }

  public set bieres(value: Biere[] | undefined) {
    this._bieres = value;
  }
}
