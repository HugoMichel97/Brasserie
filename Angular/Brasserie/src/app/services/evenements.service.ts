import { Evenement } from './../model/evenement';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class EvenementService {
  private static URL: string = 'http://localhost:8080/brasserie/api/evenement';

  constructor(private http: HttpClient) {}

  public getAll(): Observable<any[]> {
    return this.http.get<any[]>(EvenementService.URL);
  }

  public get(id: number): Observable<any> {
    return this.http.get<any>(`${EvenementService.URL}/${id}`);
  }

  public getResa(id: number): Observable<any> {
    return this.http.get<any>(`${EvenementService.URL}/${id}/getResa`);
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<any>(`${EvenementService.URL}/${id}`);
  }

  public create(evenement: Evenement): Observable<any> {
    return this.http.post(
      EvenementService.URL,
      this.evenementToJson(evenement)
    );
  }

  public update(evenement: Evenement): Observable<any> {
    console.log(this.evenementToJson(evenement));
    return this.http.put(
      `${EvenementService.URL}/${evenement.id}`,
      this.evenementToJson(evenement)
    );
  }

  private evenementToJson(evenement: Evenement): any {
    let obj = {
      id: evenement.id,
      date: evenement.date,
      heure: evenement.heure,
      libelle: evenement.libelle,
      prix: evenement.prix,
      ptsRequis: evenement.ptsRequis,
      description: evenement.description,
      nbPlaces: evenement.nbPlaces,
    };
    return obj;
  }
}
