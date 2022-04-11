import { Biere } from './biere';
import { Client } from './client';
export class Note {
  public constructor(
    private _id_note?: number | undefined,
    private _client?: Client | undefined,
    private _biere?: Biere | undefined,
    private _note?: number | undefined,
    private _commentaire?: String | undefined
  ) {}
}
