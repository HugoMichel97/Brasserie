import { Biere } from './biere';
export class Ingredient {
  public constructor(
    private _id_ingredient?: number | undefined,
    private _nom?: String | undefined,
    private _stock: number = 0,
    private _bieres?: Biere[] | undefined
  ) {}
}
