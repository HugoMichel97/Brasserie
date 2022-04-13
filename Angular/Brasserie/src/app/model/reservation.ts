import { StatutResa } from './enum/statut-resa';
import { Evenement } from './evenement';
import { Client } from './client';
export class Reservation {
  public constructor(
    private _id?: number | undefined,
    private _client?: Client | undefined,
    private _evt?: Evenement | undefined,
    private _statut?: StatutResa | undefined,
    private _nbParticipants: number = 1
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

  public get evt(): Evenement | undefined {
    return this._evt;
  }

  public set evt(value: Evenement | undefined) {
    this._evt = value;
  }
  public get statut(): StatutResa | undefined {
    return this._statut;
  }

  public set statut(value: StatutResa | undefined) {
    this._statut = value;
  }

  public get nbParticipants(): number {
    return this._nbParticipants;
  }

  public set nbParticipants(value: number) {
    this._nbParticipants = value;
  }
}
