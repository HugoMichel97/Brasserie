import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { InfoReglement } from '../model/info-reglement';

@Injectable({
  providedIn: 'root'
})
export class ReglementService {

  private static URL: string = 'http://localhost:8080/brasserie/api/infoReglement';

    constructor(private http: HttpClient) {}


    public delete(id: number): Observable<void> {
      return this.http.delete<void>(ReglementService.URL + '/' + id);
    }

    public get(id: number): Observable<InfoReglement> {
      return this.http.get<InfoReglement>('http://localhost:8080/brasserie/api/client/getInfoReg/' + '/' + id);
    }
    public create(infoReglement: InfoReglement): Observable<InfoReglement> {
      let obj = {
    client: infoReglement.client,
    mode: infoReglement.mode ,
    num: infoReglement.num,
    nom: infoReglement.nom,
    dateValid: infoReglement.dateValid,
    identifiant_paypal: infoReglement.identifiant_paypal
      };

      return this.http.post<InfoReglement>(ReglementService.URL, obj);
    }

    public update(infoReglement: InfoReglement): Observable<InfoReglement> {
      console.log(infoReglement);
      return this.http.put<InfoReglement>(
        ReglementService.URL + '/' + infoReglement.id,
        infoReglement
      );
    }
}
