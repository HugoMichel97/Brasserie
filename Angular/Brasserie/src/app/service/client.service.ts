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

  public get(id: number): Observable<Client> {
    return this.http.get<Client>(`${ClientService.URL}/${id}`);
  }

  // public updateStatut(client: Client): Observable<Client> {
  //   return this.http.patch<Client>(ClientService.URL + '/' + client.id, );
  // }
}
