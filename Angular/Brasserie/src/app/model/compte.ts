import { Achat } from './achat';
export abstract class Compte {
  public constructor(
    private _id?: number | undefined,
    private _mail?: String | undefined,
    private _password?: String | undefined,
    private _achats?: Achat[] | undefined
  ) {}

  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }

  public get mail(): String | undefined {
    return this._mail;
  }

  public set mail(value: String | undefined) {
    this._mail = value;
  }

  public get password(): String | undefined {
    return this._password;
  }

  public set password(value: String | undefined) {
    this._password = value;
  }

  public get achat(): Achat[] | undefined {
    return this._achats;
  }

  public set achats(value: Achat[] | undefined) {
    this._achats = value;
  }
}
