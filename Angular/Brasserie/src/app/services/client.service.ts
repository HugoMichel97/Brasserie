import { Client } from './../model/client';
import { StatutCommande } from '../model/enum/statut-commande';
import { Achat } from '../model/achat';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { InfoReglement } from '../model/info-reglement';

@Injectable({
  providedIn: 'root',
})
export class ClientService {
  private static URL: string = 'http://localhost:8080/brasserie/api/client';

  constructor(private http: HttpClient) {}

  public getAll(): Observable<Client[]> {
    return this.http.get<Client[]>(ClientService.URL);
  }

  public getAchat(id: number): Observable<Achat[]> {
    return this.http.get<Achat[]>(`${ClientService.URL}/${id}/getAchat`);
  }

  public getInfoReg(id: number): Observable<InfoReglement[]> {
    return this.http.get<InfoReglement[]>(
      `${ClientService.URL}/getInfoReg/${id}`
    );
  }

  public get(id: number): Observable<Client> {
    return this.http.get<Client>(`${ClientService.URL}/${id}`);
  }

  public getByMail(mail: string): Observable<Client> {
    return this.http.get<Client>(`${ClientService.URL}/mail/${mail}`);
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<any>(`${ClientService.URL}/${id}`);
  }

  public create(client: any): Observable<any> {
    return this.http.post(ClientService.URL, this.clientToJson(client));
  }

  public update(client: Client): Observable<any> {
    return this.http.patch(
      ClientService.URL + '/' + client.id,
      this.clientToJsonUpdate(client)
    );
  }

  public updateStatut(client: Client, value: string): Observable<Client> {
    return this.http.patch<Client>(ClientService.URL + '/' + client.id, {
      statut: value,
    });
  }

  public updatePassword(client: Client, value: string): Observable<Client> {
    return this.http.patch<Client>(ClientService.URL + '/' + client.id, {
      password: value,
    });
  }

  private clientToJsonUpdate(client: Client): any {
    let obj = {
      id: client.id,
      mail: client.mail,
      nom: client.nom,
      prenom: client.prenom,
      tel: client.tel,
      naissance: client.naissance,
      fidelite: client.fidelite,
      statut: client.statut,
    };
    return obj;
  }

  private clientToJson(client: Client): any {
    let obj = {
      mail: client.mail,
      password: client.password,
      nom: client.nom,
      prenom: client.prenom,
      tel: client.tel,
      naissance: client.naissance,
      fidelite: client.fidelite,
      statut: client.statut,
    };
    return obj;
  }
}
