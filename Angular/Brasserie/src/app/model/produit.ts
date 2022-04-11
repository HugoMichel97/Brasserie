export class Produit {
  public constructor(
    private _id?: number | undefined,
    private _nom?: string | undefined,
    private _description?: string | undefined,
    private _prix?: number | undefined,
    private _stock?: number | undefined,
    private _points?: number | undefined
  ) {}

  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }

  public get nom(): string | undefined {
    return this._nom;
  }

  public set nom(value: string | undefined) {
    this._nom = value;
  }

  public get description(): string | undefined {
    return this._description;
  }

  public set description(value: string | undefined) {
    this._description = value;
  }

  public get prix(): number | undefined {
    return this._prix;
  }

  public set prix(value: number | undefined) {
    this._prix = value;
  }

  public get stock(): number | undefined {
    return this._stock;
  }

  public set stock(value: number | undefined) {
    this._stock = value;
  }

  public get points(): number | undefined {
    return this._points;
  }

  public set points(value: number | undefined) {
    this._points = value;
  }
}
