import { Achat } from './../model/achat';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AchatService {
  private static url: string = 'http://localhost:8080/brasserie/api/achat';

  constructor(private http: HttpClient) {}

  public getAll(): Observable<any[]> {
    return this.http.get<any[]>(AchatService.url);
  }

  public getById(id: number): Observable<any> {
    return this.http.get<any>(`${AchatService.url}/${id}`);
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<any>(`${AchatService.url}/${id}`);
  }

  public achatToJson(achat: Achat): any {
    let a = {
      id_achat: achat.id_achat,
      id_client: { id: achat.id_client?.id },
      id_produit: { id: achat.id_produit?.id },
      quantite: achat.quantite,
    };
    return a;
  }

  public create(achat: Achat): Observable<any> {
    return this.http.post(AchatService.url, this.achatToJson(achat));
  }

  public update(achat: Achat): Observable<any> {
    return this.http.put(
      `${AchatService.url}/${achat.id_achat}`,
      this.achatToJson(achat)
    );
  }
}
