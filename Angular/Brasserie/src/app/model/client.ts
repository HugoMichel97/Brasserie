import { Reservation } from './reservation';
import { InfoReglement } from './info-reglement';
import { StatutCommande } from './enum/statut-commande';
import { Achat } from './achat';
import { Compte } from './compte';

export class Client extends Compte {
  public constructor(
    _id?: number | undefined,
    _mail?: String | undefined,
    _password?: String | undefined,
    _achats?: Achat[] | undefined,
    private _nom?: String | undefined,
    private _prenom?: String | undefined,
    private _tel?: String | undefined,
    private _fidelite?: number | undefined,
    private _naissance?: Date | undefined, // à voir avec moment (?)
    private _statut: StatutCommande = StatutCommande.vide,
    private _reglements?: InfoReglement[] | undefined,
    private _reservations?: Reservation[] | undefined
  ) {
    super(_id, _mail, _password, _achats);
  }

  public get nom(): String | undefined {
    return this._nom;
  }

  public set nom(value: String | undefined) {
    this._nom = value;
  }

  public get prenom(): String | undefined {
    return this._prenom;
  }

  public set prenom(value: String | undefined) {
    this._prenom = value;
  }

  public get tel(): String | undefined {
    return this._tel;
  }

  public set tel(value: String | undefined) {
    this._tel = value;
  }

  public get fidelite(): number | undefined {
    return this._fidelite;
  }

  public set fidelite(value: number | undefined) {
    this._fidelite = value;
  }

  public get naissance(): Date | undefined {
    return this._naissance;
  }

  public set naissance(value: Date | undefined) {
    this._naissance = value;
  }

  public get statut(): StatutCommande {
    return this._statut;
  }

  public set statut(value: StatutCommande) {
    this._statut = value;
  }

  public get reglement(): InfoReglement[] | undefined {
    return this._reglements;
  }

  public set reglement(value: InfoReglement[] | undefined) {
    this._reglements = value;
  }

  public get reservation(): Reservation[] | undefined {
    return this._reservations;
  }

  public set reservation(value: Reservation[] | undefined) {
    this._reservations = value;
  }
}
