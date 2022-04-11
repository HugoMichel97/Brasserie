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
}
