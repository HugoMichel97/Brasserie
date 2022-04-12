import { Reglement } from './enum/reglement';
import { Client } from './client';
export class InfoReglement {
  public constructor(
    private _id?: number | undefined,
    private _client?: Client | undefined,
    private _mode?: Reglement | undefined,
    private _num: string = '',
    private _nom: string = '',
    private _dateValid: string = '',
    private _identifiant_paypal: string = ''
  ) {}
  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }

  public get client(): Client | undefined {
    return this._client;
  }

  public set client(value: Client | undefined) {
    this._client = value;
  }
  public get mode(): Reglement | undefined {
    return this._mode;
  }

  public set mode(value: Reglement | undefined) {
    this._mode = value;
  }
  public get num(): string {
    return this._num;
  }

  public set num(value: string) {
    this._num = value;
  }

  public get nom(): string {
    return this._nom;
  }

  public set nom(value: string) {
    this._nom = value;
  }

  public get dateValid(): string {
    return this._dateValid;
  }

  public set dateValid(value: string) {
    this._dateValid = value;
  }

  public get identifiant_paypal(): string {
    return this._identifiant_paypal;
  }

  public set identifiant_paypal(value: string) {
    this._identifiant_paypal = value;
  }
}
