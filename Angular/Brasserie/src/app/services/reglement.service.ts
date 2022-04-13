import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { InfoReglement } from '../model/info-reglement';

@Injectable({
  providedIn: 'root',
})
export class ReglementService {
  private static URL: string =
    'http://localhost:8080/brasserie/api/infoReglement';

  constructor(private http: HttpClient) {}

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(ReglementService.URL + '/' + id);
  }

  public get(id: number): Observable<InfoReglement> {
    return this.http.get<InfoReglement>(ReglementService.URL + '/' + id);
  }
  public create(reglement: InfoReglement): Observable<any> {
    return this.http.post(
      ReglementService.URL,
      this.reglementToJson(reglement)
    );
  }
  public update(reglement: InfoReglement): Observable<any> {
    return this.http.patch(
      ReglementService.URL + '/' + reglement.id,
      this.reglementToJson(reglement)
    );
  }

  private reglementToJson(reglement: InfoReglement): any {
    let obj = {
      client: reglement.client,
      mode: reglement.mode,
      num: reglement.num,
      nom: reglement.nom,
      dateValid: reglement.dateValid,
      identifiant_paypal: reglement.identifiant_paypal,
    };
    return obj;
  }
}
