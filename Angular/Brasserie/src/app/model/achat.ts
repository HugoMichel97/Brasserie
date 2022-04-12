import { Client } from './client';
import { Produit } from './produit';
export class Achat {
  public constructor(
    private _id_achat?: number | undefined,
    private _id_client?: Client | undefined,
    private _id_produit?: Produit | undefined,
    private _quantite?: number | undefined
  ) {}

  public get id_achat(): number | undefined {
    return this._id_achat;
  }

  public set id_achat(value: number | undefined) {
    this._id_achat = value;
  }

  public get id_client(): Client | undefined {
    return this._id_client;
  }

  public set id_client(value: Client | undefined) {
    this._id_client = value;
  }

  public get id_produit(): Produit | undefined {
    return this._id_produit;
  }

  public set id_produit(value: Produit | undefined) {
    this._id_produit = value;
  }

  public get quantite(): number | undefined {
    return this._quantite;
  }

  public set quantite(value: number | undefined) {
    this._quantite = value;
  }
}
