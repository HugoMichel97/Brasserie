import { Compte } from './compte';

export class Brasseur extends Compte {
  public constructor(
    _id?: number | undefined,
    _mail?: String | undefined,
    _password?: String | undefined,
    private _recettes?: number | undefined,
    private _depenses?: number | undefined,
    private _tresorerie?: number | undefined
  ) {
    super(_id, _mail, _password);
  }

  public get recettes(): number | undefined {
    return this._recettes;
  }

  public set recettes(value: number | undefined) {
    this._recettes = value;
  }

  public get depenses(): number | undefined {
    return this._depenses;
  }

  public set depenses(value: number | undefined) {
    this._depenses = value;
  }

  public get tresorerie(): number | undefined {
    return this._tresorerie;
  }

  public set tresoreri(value: number | undefined) {
    this._tresorerie = value;
  }
}
