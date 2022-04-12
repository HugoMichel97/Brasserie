import { StatutCommande } from './../model/enum/statut-commande';
import { Achat } from './../model/achat';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from '../model/client';

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

  public get(id: number): Observable<Client> {
    return this.http.get<Client>(`${ClientService.URL}/${id}`);
  }

  public updateStatut(client: Client, value: string): Observable<Client> {
    return this.http.patch<Client>(ClientService.URL + '/' + client.id, {
      statut: value,
    });
  }
}
