import { Biere } from './biere';
export class Ingredient {
  public constructor(
    private _id_ingredient?: number | undefined,
    private _nom?: string | undefined,
    private _stock: number = 0,
    private _bieres?: Biere[] | undefined
  ) {}

  public get id_ingredient(): number | undefined {
    return this._id_ingredient;
  }

  public set id_ingredient(value: number | undefined) {
    this._id_ingredient = value;
  }

  public get nom(): string | undefined {
    return this._nom;
  }

  public set nom(value: string | undefined) {
    this._nom = value;
  }



  public get stock(): number  {
    return this._stock;
  }

  public set stock(value: number) {
    this._stock = value;
  }


public get bieres(): Biere []| undefined {
    return this._bieres;
  }

  public set bieres(value : Biere []| undefined) {
    this._bieres = value;
  }














}
