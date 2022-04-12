import { Biere } from './biere';
import { Client } from './client';
export class Note {
  public constructor(
    private _id_note?: number | undefined,
    private _id_client?: Client | undefined,
    private _biere?: Biere | undefined,
    private _note?: number | undefined,
    private _commentaire?: string | undefined
  ) {}

  public get id_note(): number | undefined {
    return this._id_note;
  }

  public set id_note(value: number | undefined) {
    this._id_note = value;
  }

  public get id_client(): Client | undefined {
    return this._id_client;
  }

  public set id_client(value: Client | undefined) {
    this._id_client = value;
  }

  public get biere(): Biere | undefined {
    return this._biere;
  }

  public set biere(value: Biere | undefined) {
    this._biere = value;
  }

  public get note(): number | undefined {
    return this._note;
  }

  public set note(value: number | undefined) {
    this._note = value;
  }

  public get commentaire(): string | undefined {
    return this._commentaire;
  }

  public set commentaire(value: string | undefined) {
    this._commentaire = value;
  }
}
