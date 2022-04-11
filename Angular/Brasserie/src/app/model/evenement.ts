import { Reservation } from './reservation';
import { Time } from '@angular/common';

export class Evenement {
  public constructor(
    private _id?: number | undefined,
    private _date?: Date | undefined,
    private _heure?: Time | undefined,
    private _libelle?: string | undefined,
    private _prix?: number | undefined,
    private _ptsRequis: number = 0,
    private _description?: string | undefined,
    private _nbPlaces: number = 1,
    private _reservations?: Reservation[] | undefined
  ) {}

  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }

  public get date(): Date | undefined {
    return this._date;
  }

  public set date(value: Date | undefined) {
    this._date = value;
  }

  public get heure(): Time | undefined {
    return this._heure;
  }

  public set heure(value: Time | undefined) {
    this._heure = value;
  }

  public get libelle(): string | undefined {
    return this._libelle;
  }

  public set libelle(value: string | undefined) {
    this._libelle = value;
  }

  public get prix(): number | undefined {
    return this._prix;
  }

  public set prix(value: number | undefined) {
    this._prix = value;
  }

  public get ptsRequis(): number {
    return this._ptsRequis;
  }

  public set ptsRequis(value: number) {
    this._ptsRequis = value;
  }

  public get description(): string | undefined {
    return this._description;
  }

  public set description(value: string | undefined) {
    this._description = value;
  }

  public get nbPlaces(): number {
    return this._nbPlaces;
  }

  public set nbPlaces(value: number) {
    this._nbPlaces = value;
  }

  public get reservations(): Reservation[] | undefined {
    return this._reservations;
  }

  public set reservations(value: Reservation[] | undefined) {
    this._reservations = value;
  }
}
