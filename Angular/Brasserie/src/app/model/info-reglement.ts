import { Reglement } from './enum/reglement';
import { Client } from './client';
export class InfoReglement {
  public constructor(
    private _id?: number | undefined,
    private _client?: Client | undefined,
    private _mode?: Reglement | undefined,
    private _num?: number | undefined,
    private _nom?: String | undefined,
    private _dateValid?: String | undefined,
    private _identifiant_paypal?: String | undefined
  ) {}
}
